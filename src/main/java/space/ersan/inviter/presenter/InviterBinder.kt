package space.ersan.inviter.presenter

import space.ersan.inviter.injection.*
import space.ersan.inviter.model.Distance
import javax.inject.Inject

interface InviterBinder {

    fun run(distance: Distance)
}

class DefaultInviterBinder : InviterBinder {

    @Inject
    lateinit var view: InviterView

    @Inject
    lateinit var viewModel: InviterViewModel

    init {
        DaggerInviterComponent.create().inject(this)
    }

    override fun run(distance: Distance) {
        view.setCustomers(viewModel.getCustomersWithin(distance))
    }
}