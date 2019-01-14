package space.ersan.inviter.domain

import space.ersan.inviter.model.Customer
import space.ersan.inviter.model.InviterRepository
import space.ersan.inviter.model.Distance
import space.ersan.inviter.model.Location

interface CustomersByDistanceUseCase {
    fun getCustomersWithin(location: Location, distance: Distance): List<Customer>
}

class DefaultCustomersByDistanceUseCase(private val customerRepository: InviterRepository)
    : CustomersByDistanceUseCase {

    override fun getCustomersWithin(location: Location, distance: Distance): List<Customer> {
        return customerRepository.getCustomers()
                .filter { it.location.distanceTo(location) <= distance }
                .sortedBy { it.userId }
    }
}