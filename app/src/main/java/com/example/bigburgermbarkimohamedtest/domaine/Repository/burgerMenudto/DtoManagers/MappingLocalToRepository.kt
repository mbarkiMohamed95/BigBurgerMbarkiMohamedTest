package com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenudto.DtoManagers

import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.model.BurgerMenuRepModel
import com.example.bigburgermbarkimohamedtest.base.baseDto.DomainDTOMappingService
import com.example.bigburgermbarkimohamedtest.domaine.local.entitys.BurgerMenuLocalModel
import javax.inject.Inject

class MappingLocalToRepository @Inject constructor() :
    DomainDTOMappingService<BurgerMenuLocalModel, BurgerMenuRepModel> {
    override fun mapDomainToDTO(domain: BurgerMenuLocalModel): BurgerMenuRepModel = domain.run {
        BurgerMenuRepModel(
            ref,
            title,
            description,
            thumbnail,
            price
        )
    }

}