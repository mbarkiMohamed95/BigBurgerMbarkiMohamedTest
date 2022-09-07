package com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.manager

import com.example.bigburgermbarkimohamedtest.domaine.remote.ApiServices
import com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.model.BurgerMenuRemoteModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class BurgerMenuRemoteManager @Inject constructor(private val apiServices: ApiServices) :BurgerMenuRemoteInteraction{
    override fun loadBurgerMenu(scope: CoroutineScope):  Flow<List<BurgerMenuRemoteModel>?> = callbackFlow{
       apiServices.getBurgers().enqueue(object : Callback<List<BurgerMenuRemoteModel>>{
            override fun onResponse(
                call: Call<List<BurgerMenuRemoteModel>>,
                response: Response<List<BurgerMenuRemoteModel>>
            ) {
                scope.launch {
                    send(response.body())
                }

            }

            override fun onFailure(call: Call<List<BurgerMenuRemoteModel>>, t: Throwable) {
                scope.launch {
                    send(null)
                }
            }

        })

        awaitClose()
    }

}