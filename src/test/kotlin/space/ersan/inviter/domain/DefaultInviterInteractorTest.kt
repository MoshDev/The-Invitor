package space.ersan.inviter.domain

import any
import mock
import onMethod
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import space.ersan.inviter.model.Distance
import space.ersan.inviter.model.Location

class DefaultInviterInteractorTest {

    lateinit var inviterInteractor: InviterInteractor

    private val customersByDistanceUseCase: CustomersByDistanceUseCase = mock()

    private val officeLocationUseCase: OfficeLocationUseCase = mock()

    @Before
    fun setUp() {
        inviterInteractor = DefaultInviterInteractor(customersByDistanceUseCase, officeLocationUseCase)
    }

    @Test
    fun getCustomersWithin() {

        customersByDistanceUseCase.apply {
            onMethod(getCustomersWithin(any(), any())).thenReturn(emptyList())
        }

        val location = Location(1.0, 1.5)
        val distance = Distance.Kilometers(20.0)

        val customers = inviterInteractor.getCustomersWithin(location, distance)

        Mockito.verify(customersByDistanceUseCase).getCustomersWithin(location, distance)
        assertTrue(customers.isEmpty())

    }

    @Test
    fun getOfficeLocation() {

        officeLocationUseCase.apply {
            onMethod(getOfficeLocation()).thenReturn(Location(1.0, 1.3))
        }

        val location = inviterInteractor.getOfficeLocation()

        Mockito.verify(officeLocationUseCase).getOfficeLocation()
        assertEquals(Location(1.0 , 1.3), location)
    }
}