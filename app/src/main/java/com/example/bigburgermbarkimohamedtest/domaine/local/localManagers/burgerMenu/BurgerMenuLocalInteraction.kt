package com.example.bigburgermbarkimohamedtest.domaine.local.localManagers.burgerMenu

import com.example.bigburgermbarkimohamedtest.domaine.local.entitys.BurgerMenuLocalModel
import kotlinx.coroutines.flow.Flow

interface BurgerMenuLocalInteraction {
    fun getAllBurgerMenu():Flow<List<BurgerMenuLocalModel>>
    suspend fun saveAllBurgerMenu(burgerList:List<BurgerMenuLocalModel>)
}