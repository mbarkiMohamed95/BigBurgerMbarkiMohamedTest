package com.example.bigburgermbarkimohamedtest.di


import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.model.BurgerMenuRepModel
import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenudto.DtoManagers.MappingLocalToRepository
import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenudto.DtoManagers.MappingRemoteToLocal
import com.example.bigburgermbarkimohamedtest.base.baseDto.DomainDTOMappingService
import com.example.bigburgermbarkimohamedtest.domaine.local.entitys.BurgerMenuLocalModel
import com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.model.BurgerMenuRemoteModel
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.dto.MappingRepositoryToUi
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.model.BurgerMenuUIModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppDtoModule {


    @Singleton
    @Binds
    abstract fun provideMappingLocalToRepository(mappingLocalToRepository: MappingLocalToRepository): DomainDTOMappingService<BurgerMenuLocalModel, BurgerMenuRepModel>


    @Singleton
    @Binds
    abstract fun provideMappingRemoteToLocal(mappingRemoteToLocal: MappingRemoteToLocal): DomainDTOMappingService<BurgerMenuRemoteModel, BurgerMenuLocalModel>



    @Singleton
    @Binds
    abstract fun provideMappingRepositoryToUi(mappingRepositoryToUi: MappingRepositoryToUi): DomainDTOMappingService<BurgerMenuRepModel, BurgerMenuUIModel>


}