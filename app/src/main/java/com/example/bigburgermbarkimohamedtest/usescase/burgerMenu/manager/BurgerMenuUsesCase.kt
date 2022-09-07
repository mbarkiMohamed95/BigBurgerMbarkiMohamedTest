package com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.manager

import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.BurgerMenuRepositoryInteraction
import com.example.bigburgermbarkimohamedtest.helpers.states.DataState
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.dto.MappingRepositoryToUi
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.model.BurgerMenuUIModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class BurgerMenuUsesCase @Inject constructor(
    private val burgerMenuRepositoryInteraction: BurgerMenuRepositoryInteraction,
    private val repositoryToUi: MappingRepositoryToUi
) :
    BurgerMenuUsesCaseInteraction {
    override suspend fun getAllBurgerMenu(scope: CoroutineScope): Flow<DataState<List<BurgerMenuUIModel>>> =
        callbackFlow {
            burgerMenuRepositoryInteraction.getAllBurgerMenu(scope).collect {
                when (it){
                    is DataState.Success->{
                        send(DataState.Success(repositoryToUi.mapDomainToDTO(it.data)))
                    }
                    is DataState.Error ->{
                        send(it)
                    }
                }
            }
            awaitClose()
        }
}