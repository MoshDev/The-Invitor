package space.ersan.inviter.model

import com.google.gson.annotations.SerializedName

data class Customer(
        @SerializedName("user_id") val userId: Int,
        @SerializedName("name") val name: String,
        @SerializedName("latitude") private val latitude: Double,
        @SerializedName("longitude") private val longitude: Double
) {
    val location: Location
        get() = Location(latitude, longitude)
}