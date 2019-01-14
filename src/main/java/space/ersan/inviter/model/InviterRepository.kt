package space.ersan.inviter.model

import com.google.gson.Gson
import java.io.File

interface InviterRepository {
    companion object {
        val DUBLIN_OFFICE_LOCATION = Location(53.339428, -6.257664)
    }

    fun getOfficeLocation(): Location
    fun getCustomers(): List<Customer>
}

class DefaultInviterRepository(private val fileName: String) : InviterRepository {

    private val gson = Gson()

    override fun getOfficeLocation() = InviterRepository.DUBLIN_OFFICE_LOCATION

    override fun getCustomers(): List<Customer> {
        val file = File(this::class.java.getResource(fileName).toURI())
        return file.readLines().map { gson.fromJson(it, Customer::class.java)!! }
    }
}