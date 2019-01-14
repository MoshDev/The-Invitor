package space.ersan.inviter.model

sealed class Distance(private val value: Double) {

    class Meters(meters: Double) : Distance(meters)
    class Kilometers(kilometers: Double) : Distance(kilometers * 1000)

    val inMeters: Double = value
    val inKilometers: Double = value / 1000

    operator fun compareTo(other: Distance): Int = value.compareTo(other.value)
}