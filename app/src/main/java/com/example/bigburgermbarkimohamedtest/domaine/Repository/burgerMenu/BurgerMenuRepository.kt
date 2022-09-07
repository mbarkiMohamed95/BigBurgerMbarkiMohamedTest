package com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu

import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.model.BurgerMenuRepModel
import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenudto.DtoManagers.MappingLocalToRepository
import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenudto.DtoManagers.MappingRemoteToLocal
import com.example.bigburgermbarkimohamedtest.domaine.local.localManagers.burgerMenu.BurgerMenuLocalManager
import com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.manager.BurgerMenuRemoteInteraction
import com.example.bigburgermbarkimohamedtest.helpers.states.DataState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class BurgerMenuRepository @Inject constructor(
    private val remoteManger: BurgerMenuRemoteInteraction,
    private val localManager: BurgerMenuLocalManager,
    private val remoteToLocal: MappingRemoteToLocal,
    private val localToRepository: MappingLocalToRepository
) : BurgerMenuRepositoryInteraction {
    override suspend fun getAllBurgerMenu(scope: CoroutineScope): Flow<DataState<List<BurgerMenuRepModel>>> =
        callbackFlow {
            remoteManger.loadBurgerMenu(scope).collect { res ->
                if (!res.isNullOrEmpty()) {
                    localManager.saveAllBurgerMenu(remoteToLocal.mapDomainToDTO(res))
                    delay(500)
                    localManager.getAllBurgerMenu().collect {
                        send(DataState.Success(localToRepository.mapDomainToDTO(it)))
                    }
                } else {
                    localManager.getAllBurgerMenu().collect {
                        if (!it.isNullOrEmpty()) {
                            send(DataState.Success(localToRepository.mapDomainToDTO(it)))
                        } else {
                            send(DataState.Error(Exception("null data")))
                        }
                    }
                }
            }
            awaitClose()
        }
}