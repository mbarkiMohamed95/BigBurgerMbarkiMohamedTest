package com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.manager

import com.example.bigburgermbarkimohamedtest.helpers.states.DataState
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.model.BurgerMenuUIModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface BurgerMenuUsesCaseInteraction {
    suspend fun getAllBurgerMenu(scope: CoroutineScope): Flow<DataState<List<BurgerMenuUIModel>>>
}