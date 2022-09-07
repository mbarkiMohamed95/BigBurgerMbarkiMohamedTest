package com.example.bigburgermbarkimohamedtest.domaine.remote

import com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.model.BurgerMenuRemoteModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiServices {
    @Headers("Accept: application/json")
    @GET("/bigburger")
    fun getBurgers(): Call<List<BurgerMenuRemoteModel>>
}