package space.ersan.inviter.model

import org.junit.Test

import org.junit.Assert.*

class DistanceTest {

    lateinit var distance: Distance

    @Test
    fun getInMeters() {
        distance = Distance.Meters(100.0)

        assertEquals(100.0, distance.inMeters, 0.0)
    }

    @Test
    fun getInKilometers() {
        distance = Distance.Kilometers(113.5)

        assertEquals(113.5, distance.inKilometers, 0.0)
    }

    @Test
    fun `from meters to kilometers`() {
        distance = Distance.Meters(1350.0)

        assertEquals(1.350, distance.inKilometers, 0.0)

    }

    @Test
    fun `from kilometers to meters`() {
        distance = Distance.Kilometers(14.54)

        assertEquals(14540.0, distance.inMeters, 0.0)

    }

    @Test
    fun `compare less than`() {
        distance = Distance.Meters(120.0)

        assertTrue(distance < Distance.Meters(200.0))
        assertTrue(distance < Distance.Kilometers(1.0))
    }

    @Test
    fun `compare more than`() {
        distance = Distance.Meters(2200.0)

        assertTrue(distance > Distance.Meters(2199.0))
        assertTrue(distance > Distance.Kilometers(2.199))
    }


    @Test
    fun `compare equal`() {
        distance = Distance.Meters(3200.0)

        assertTrue(distance >= Distance.Meters(3200.0))
        assertTrue(distance <= Distance.Meters(3200.0))
        assertTrue(distance >= Distance.Kilometers(3.2))
        assertTrue(distance <= Distance.Kilometers(3.2))
    }
}