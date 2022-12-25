package com.example.sharepreferenceapplication
data class Topic(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String
)

annotation class SerializedName(val value: String)
