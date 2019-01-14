package space.ersan.inviter.model

data class Location(val latitude: Double,
                    val longitude: Double) {

    fun distanceTo(otherLocation: Location): Distance {

        val R = 6371 // Radius of the earth

        val latDistance = Math.toRadians(otherLocation.latitude - latitude)
        val lonDistance = Math.toRadians(otherLocation.longitude - longitude)
        val a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                (Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(otherLocation.latitude))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2))
        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
        var distance = R.toDouble() * c * 1000.0 // convert to value

        distance = Math.pow(distance, 2.0)

        return Distance.Meters(Math.sqrt(distance))
    }
}