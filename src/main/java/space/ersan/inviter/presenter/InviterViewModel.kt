package space.ersan.inviter.presenter

import space.ersan.inviter.domain.InviterInteractor
import space.ersan.inviter.model.Customer
import space.ersan.inviter.model.Distance

interface InviterViewModel {
    fun getCustomersWithin(distance: Distance): List<Customer>
}

class DefaultInviterViewModel(private val inviterInteractor: InviterInteractor) : InviterViewModel {

    override fun getCustomersWithin(distance: Distance): List<Customer> {
        val officeLocation = inviterInteractor.getOfficeLocation()
        return inviterInteractor.getCustomersWithin(officeLocation, distance)
    }
}