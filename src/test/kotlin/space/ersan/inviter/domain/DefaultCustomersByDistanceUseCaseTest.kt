package space.ersan.inviter.domain

import mock
import onMethod
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import space.ersan.inviter.model.Customer
import space.ersan.inviter.model.InviterRepository
import space.ersan.inviter.model.Distance
import space.ersan.inviter.model.Location


class DefaultCustomersByDistanceUseCaseTest {

    /**
     * the distance between 0.0, 0.0 to 0.1, 0.0 is ~11 KM and
     * the distance between 0.0, 0.0 to 0.0, 0.1 is ~11 KM
     * so we would assume each 0.1 is 11KM for testing purpose and we should
     * not be strict about distance accuracy as all of them are assumptions and
     * ignores the height difference
     */

    private val customerRepository: InviterRepository = mock()

    private lateinit var customersByDistanceUseCase: CustomersByDistanceUseCase

    @Before
    fun setUp() {
        customersByDistanceUseCase = DefaultCustomersByDistanceUseCase(customerRepository)
    }

    @Test
    fun `when customers input is empty`() {
        customerRepository.apply {
            onMethod(getCustomers()).thenReturn(emptyList())
        }

        val filteredCustomers = customersByDistanceUseCase.getCustomersWithin(Location(0.0, 0.0), Distance.Kilometers(10000.0))

        assertEquals(0, filteredCustomers.size)
    }

    @Test
    fun `when all customers are within the distance`() {
        customerRepository.apply {
            onMethod(getCustomers()).thenReturn(listOf(
                    Customer(1, "Name1", 0.1, 0.1),
                    Customer(2, "Name2", 0.001, 0.0),
                    Customer(3, "Name3", 0.0, 0.1),
                    Customer(4, "Name4", 0.0, 0.0)
            ))
        }

        val filteredCustomers = customersByDistanceUseCase.getCustomersWithin(Location(0.0, 0.0), Distance.Kilometers(10000.0))

        assertTrue(filteredCustomers.isNotEmpty())
        assertEquals(4, filteredCustomers.size)
        assertEquals("Name4", filteredCustomers[3].name)
        assertEquals(3, filteredCustomers[2].userId)
    }

    @Test
    fun `customers set are sorted by userId ascending`() {
        customerRepository.apply {
            onMethod(getCustomers()).thenReturn(listOf(
                    Customer(2, "Name2", 0.001, 0.0),
                    Customer(3, "Name3", 0.0, 0.1),
                    Customer(1, "Name1", 0.1, 0.1),
                    Customer(4, "Name4", 0.0, 0.0)
            ))
        }

        val filteredCustomers = customersByDistanceUseCase.getCustomersWithin(Location(0.0, 0.0), Distance.Kilometers(10000.0))

        assertTrue(filteredCustomers.isNotEmpty())
        assertEquals(4, filteredCustomers.size)
        assertEquals(1, filteredCustomers[0].userId)
        assertEquals(2, filteredCustomers[1].userId)
        assertEquals(3, filteredCustomers[2].userId)
        assertEquals(4, filteredCustomers[3].userId)
    }

    @Test
    fun `when some customers are within the range and the result sorted by userId ascending`() {
        customerRepository.apply {
            onMethod(getCustomers()).thenReturn(listOf(
                    Customer(2, "Name2", 3.0, 3.0),
                    Customer(3, "Name3", 0.0, 0.1),
                    Customer(1, "Name1", 0.1, 0.1),
                    Customer(4, "Name4", 4.0, 5.0)
            ))
        }

        val filteredCustomers = customersByDistanceUseCase.getCustomersWithin(Location(0.0, 0.0), Distance.Kilometers(20.0))

        assertTrue(filteredCustomers.isNotEmpty())
        assertEquals(2, filteredCustomers.size)
        assertEquals(1, filteredCustomers[0].userId)
        assertEquals(3, filteredCustomers[1].userId)
    }
}