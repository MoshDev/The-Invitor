package space.ersan.inviter.model

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class CustomerTest {

    lateinit var customer: Customer
    @Before
    fun setUp() {
        customer = Customer(1, "name1", 0.1, 0.2)
    }

    @Test
    fun getLocation() {
        val location = customer.location

        assertNotNull(location)
        assertEquals(0.1, location.latitude, 0.0)
        assertEquals(0.2, location.longitude, 0.0)
    }
}