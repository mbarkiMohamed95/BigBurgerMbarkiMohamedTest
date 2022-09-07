package com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu

import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.model.BurgerMenuRepModel
import com.example.bigburgermbarkimohamedtest.helpers.states.DataState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface BurgerMenuRepositoryInteraction {
   suspend fun getAllBurgerMenu(scope: CoroutineScope): Flow<DataState<List<BurgerMenuRepModel>>>

}