package space.ersan.inviter.presenter

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import space.ersan.inviter.model.Customer
import java.io.*
import java.io.PrintStream


class DefaultInviterViewTest {

    lateinit var inviterView: InviterView
    private lateinit var defaultPrintStream: PrintStream

    @Before
    fun setUp() {
        inviterView = DefaultInviterView()
        defaultPrintStream = System.out
    }

    @Test
    fun `set empty list of customers`() {
        val printOut = ByteArrayOutputStream()
        System.setOut(PrintStream(printOut))

        inviterView.setCustomers(emptyList())

        val output = printOut.toString("UTF-8")
        assertEquals("No Customers Found\n", output)
    }

    @Test
    fun `set none list of customers`() {
        val printOut = ByteArrayOutputStream()
        System.setOut(PrintStream(printOut))

        val customers = listOf(
                Customer(1, "Name1", 0.1, 0.2),
                Customer(2, "Name2", 0.4, 0.3)
        )

        inviterView.setCustomers(customers)

        val output = printOut.toString("UTF-8")
        val expected =
                """The customers which will be invited (2 Customers):

1:- Id: 1, Name: Name1
2:- Id: 2, Name: Name2
"""
        assertEquals(expected, output)
    }

    @After
    fun tearDown() {
        System.setOut(defaultPrintStream)
    }
}