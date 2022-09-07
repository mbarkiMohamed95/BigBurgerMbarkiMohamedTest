package com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.manager

import com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.model.BurgerMenuRemoteModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface BurgerMenuRemoteInteraction {
    fun loadBurgerMenu(scope: CoroutineScope): Flow<List<BurgerMenuRemoteModel>?>
}