package space.ersan.inviter.presenter

import any
import mock
import onMethod
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import space.ersan.inviter.domain.InviterInteractor
import space.ersan.inviter.domain.OfficeLocationUseCase
import space.ersan.inviter.model.Customer
import space.ersan.inviter.model.Distance
import space.ersan.inviter.model.InviterRepository

class DefaultInviterViewModelTest {

    lateinit var inviterViewModel: InviterViewModel

    private val inviterInteractor: InviterInteractor = mock()

    @Before
    fun setUp() {
        inviterViewModel = DefaultInviterViewModel(inviterInteractor)
    }

    @Test
    fun getCustomersWithin() {
        val distance = Distance.Kilometers(2.0)
        inviterInteractor.apply {
            onMethod(getOfficeLocation()).thenReturn(InviterRepository.DUBLIN_OFFICE_LOCATION)
            onMethod(getCustomersWithin(any(), any())).thenReturn(listOf(Customer(2, "Hye", 1.0, 2.0)))
        }

        val customers = inviterViewModel.getCustomersWithin(distance)
        Mockito.verify(inviterInteractor).getOfficeLocation()
        Mockito.verify(inviterInteractor).getCustomersWithin(InviterRepository.DUBLIN_OFFICE_LOCATION, distance)
        assertEquals(2, customers[0].userId)
        assertEquals("Hye", customers[0].name)
    }
}