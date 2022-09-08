package com.example.bigburgermbarkimohamedtest.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bigburgermbarkimohamedtest.helpers.states.DataState
import com.example.bigburgermbarkimohamedtest.presentation.home.homeAction.HomeIntent
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.manager.BurgerMenuUsesCaseInteraction
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.model.BurgerMenuUIModel
import com.example.mbarkimohamedblobstorageproject.appUtilsDispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val burgerMenuUsesCaseInteraction: BurgerMenuUsesCaseInteraction,
    private val dispatchers: DispatcherProvider
) :
    ViewModel() {
    private val _dataState: MutableLiveData<DataState<List<BurgerMenuUIModel>>> =
        MutableLiveData(
            DataState.Idle
        )

    val dataState: LiveData<DataState<List<BurgerMenuUIModel>>> get() = _dataState

    fun handleAction(homeIntent: HomeIntent) {
        when (homeIntent) {
            is HomeIntent.LoadBurgers -> {
                loadBurgs()
            }
        }
    }

    private fun loadBurgs() {
        viewModelScope.launch(dispatchers.io) {
            burgerMenuUsesCaseInteraction.getAllBurgerMenu(this).collect {
                withContext(dispatchers.main){
                    _dataState.value = it
                }
            }
        }

    }
}