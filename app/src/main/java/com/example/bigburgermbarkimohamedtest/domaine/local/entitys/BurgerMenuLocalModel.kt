package com.example.bigburgermbarkimohamedtest.domaine.local.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BurgerMenuLocalModel (
    @PrimaryKey
    val ref: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
    val price: Int
)
