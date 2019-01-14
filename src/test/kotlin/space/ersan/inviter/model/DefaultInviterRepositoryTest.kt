package space.ersan.inviter.model

import com.google.gson.JsonSyntaxException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DefaultInviterRepositoryTest {

    lateinit var inviterRepository: InviterRepository

    @Test
    fun getOfficeLocation() {
        inviterRepository = DefaultInviterRepository("/customers.txt")

        val officeLocation = inviterRepository.getOfficeLocation()

        assertEquals(InviterRepository.DUBLIN_OFFICE_LOCATION, officeLocation)
    }

    @Test
    fun getCustomers() {
        inviterRepository = DefaultInviterRepository("/customers0.txt")

        val customers = inviterRepository.getCustomers()

        assertTrue(customers.isNotEmpty())
        assertEquals(32, customers.size)
        assertEquals("Christina McArdle", customers[0].name)
        assertEquals(12, customers[0].userId)

    }

    @Test(expected = NullPointerException::class)
    fun `input file not found`() {
        inviterRepository = DefaultInviterRepository("/not_exists_file.txt")

        inviterRepository.getCustomers()
    }


    @Test(expected = JsonSyntaxException::class)
    fun `malformed json input`() {
        inviterRepository = DefaultInviterRepository("/corrupted_json.txt")

        inviterRepository.getCustomers()
    }
}