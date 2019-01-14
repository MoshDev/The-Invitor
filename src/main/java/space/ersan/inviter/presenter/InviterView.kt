package space.ersan.inviter.presenter

import space.ersan.inviter.model.Customer

interface InviterView {
    fun setCustomers(customers: List<Customer>)
}

class DefaultInviterView : InviterView {

    override fun setCustomers(customers: List<Customer>) {
        if (customers.isEmpty()) {
            println("No Customers Found")
        } else {
            println("The customers which will be invited (${customers.size} Customers):\n")
            customers.forEachIndexed { index: Int, customer: Customer ->
                println("${index + 1}:- Id: ${customer.userId}, Name: ${customer.name}")
            }
        }
    }
}