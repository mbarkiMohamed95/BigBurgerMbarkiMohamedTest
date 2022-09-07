package com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.model

import com.google.gson.annotations.SerializedName

data class BurgerMenuRemoteModel(
    @SerializedName("ref") val ref: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("price") val price: Int
)
