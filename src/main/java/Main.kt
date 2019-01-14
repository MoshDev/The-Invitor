import space.ersan.inviter.model.Distance
import space.ersan.inviter.presenter.DefaultInviterBinder
import space.ersan.inviter.presenter.InviterBinder

fun main(args: Array<String>) {

    val distance = Distance.Kilometers(100.0)

    val inviterBinder: InviterBinder = DefaultInviterBinder()
    inviterBinder.run(distance)

}