package com.example.bigburgermbarkimohamedtest.di

import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.BurgerMenuRepository
import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.BurgerMenuRepositoryInteraction
import com.example.bigburgermbarkimohamedtest.domaine.local.localManagers.burgerMenu.BurgerMenuLocalInteraction
import com.example.bigburgermbarkimohamedtest.domaine.local.localManagers.burgerMenu.BurgerMenuLocalManager
import com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.manager.BurgerMenuRemoteInteraction
import com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.manager.BurgerMenuRemoteManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomaineModule {

    @Binds
    abstract fun provideBurgerMenuLocalInteraction(burgerMenuLocalManager: BurgerMenuLocalManager): BurgerMenuLocalInteraction

    @Binds
    abstract fun provideBurgerMenuRemoteInteraction(burgerMenuRemoteManager: BurgerMenuRemoteManager): BurgerMenuRemoteInteraction


    @Binds
    abstract fun provideBurgerMenuRepositoryInteraction(burgerMenuRemoteManager: BurgerMenuRepository): BurgerMenuRepositoryInteraction


}