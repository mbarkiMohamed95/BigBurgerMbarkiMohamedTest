package com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenudto.DtoManagers

import com.example.bigburgermbarkimohamedtest.base.baseDto.DomainDTOMappingService
import com.example.bigburgermbarkimohamedtest.domaine.local.entitys.BurgerMenuLocalModel
import com.example.bigburgermbarkimohamedtest.domaine.remote.burgerMenu.model.BurgerMenuRemoteModel
import javax.inject.Inject

class MappingRemoteToLocal @Inject constructor() :
    DomainDTOMappingService<BurgerMenuRemoteModel, BurgerMenuLocalModel> {
    override fun mapDomainToDTO(domain: BurgerMenuRemoteModel): BurgerMenuLocalModel= domain.run {
        BurgerMenuLocalModel(
            ref,
            title,
            description,
            thumbnail,
            price
        )
    }

}