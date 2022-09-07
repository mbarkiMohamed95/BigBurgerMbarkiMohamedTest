package com.example.bigburgermbarkimohamedtest.di

import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.BurgerMenuRepository
import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.BurgerMenuRepositoryInteraction
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.manager.BurgerMenuUsesCase
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.manager.BurgerMenuUsesCaseInteraction
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class UsesCaseModule {


    @Binds
    abstract fun provideBurgerMenuUsesCaseInteraction(burgerMenuUsesCase: BurgerMenuUsesCase): BurgerMenuUsesCaseInteraction


}