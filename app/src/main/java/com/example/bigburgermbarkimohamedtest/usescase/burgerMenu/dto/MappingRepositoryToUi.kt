package com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.dto

import com.example.bigburgermbarkimohamedtest.domaine.Repository.burgerMenu.model.BurgerMenuRepModel
import com.example.bigburgermbarkimohamedtest.base.baseDto.DomainDTOMappingService
import com.example.bigburgermbarkimohamedtest.domaine.local.entitys.BurgerMenuLocalModel
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.model.BurgerMenuUIModel
import javax.inject.Inject

class MappingRepositoryToUi @Inject constructor() :
    DomainDTOMappingService<BurgerMenuRepModel, BurgerMenuUIModel> {

    override fun mapDomainToDTO(domain: BurgerMenuRepModel): BurgerMenuUIModel = domain.run {
        BurgerMenuUIModel(
            ref,
            title,
            description,
            thumbnail,
            price
        )

    }
}