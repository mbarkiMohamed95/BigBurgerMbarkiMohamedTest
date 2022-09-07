package com.example.bigburgermbarkimohamedtest.domaine.local.localManagers.burgerMenu

import com.example.bigburgermbarkimohamedtest.domaine.local.dao.burgerMenu.burgerMenuDao
import com.example.bigburgermbarkimohamedtest.domaine.local.entitys.BurgerMenuLocalModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class BurgerMenuLocalManager @Inject constructor(private val dao: burgerMenuDao) :BurgerMenuLocalInteraction{
    override fun getAllBurgerMenu(): Flow<List<BurgerMenuLocalModel>> = callbackFlow{
        send(dao.getAllBurgerMenu())
        awaitClose()
    }

    override suspend fun saveAllBurgerMenu(burgerList: List<BurgerMenuLocalModel>) {
        dao.insertList(burgerList)
    }
}