package space.ersan.inviter.domain

import mock
import onMethod
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import space.ersan.inviter.model.InviterRepository
import space.ersan.inviter.model.Location

class DefaultOfficeLocationUseCaseTest {

    private val customerRepository: InviterRepository = mock()

    lateinit var officeLocationUseCase: OfficeLocationUseCase

    @Before
    fun setUp() {
        officeLocationUseCase = DefaultOfficeLocationUseCase(customerRepository)
    }

    @Test
    fun getOfficeLocation() {
        customerRepository.apply {
            onMethod(getOfficeLocation()).thenReturn(Location(1.0, 1.0))
        }

        val location = officeLocationUseCase.getOfficeLocation()

        Mockito.verify(customerRepository, Mockito.times(1)).getOfficeLocation()
        assertEquals(1.0, location.latitude, 0.0)
        assertEquals(1.0, location.longitude, 0.0)

    }
}