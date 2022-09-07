package com.example.bigburgermbarkimohamedtest.domaine.local.dao.burgerMenu

import androidx.room.Dao
import androidx.room.Query
import com.example.bigburgermbarkimohamedtest.domaine.local.dao.baseDAO.BaseDao
import com.example.bigburgermbarkimohamedtest.domaine.local.entitys.BurgerMenuLocalModel

@Dao
interface burgerMenuDao:BaseDao<BurgerMenuLocalModel> {

    @Query("SELECT * FROM BurgerMenuLocalModel")
    fun getAllBurgerMenu():List<BurgerMenuLocalModel>
}