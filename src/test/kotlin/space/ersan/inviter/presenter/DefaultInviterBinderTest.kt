package space.ersan.inviter.presenter

import any
import mock
import onMethod
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import space.ersan.inviter.model.Customer
import space.ersan.inviter.model.Distance

class DefaultInviterBinderTest {

    lateinit var inviterBinder: DefaultInviterBinder

    @Before
    fun setUp() {
        inviterBinder = DefaultInviterBinder()
        inviterBinder.view = mock()
        inviterBinder.viewModel = mock()
    }

    @Test
    fun run() {
        val distance = Distance.Kilometers(1.2)
        val customers = listOf(Customer(199, "Me", 0.1, 0.2))

        inviterBinder.viewModel.apply {
            onMethod(getCustomersWithin(any())).thenReturn(customers)
        }

        inviterBinder.run(distance)

        Mockito.verify(inviterBinder.viewModel).getCustomersWithin(distance)
        Mockito.verify(inviterBinder.view).setCustomers(customers)

    }
}