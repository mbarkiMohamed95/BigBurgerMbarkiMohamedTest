package com.example.bigburgermbarkimohamedtest.domaine.local.DBManager

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bigburgermbarkimohamedtest.domaine.local.dao.burgerMenu.burgerMenuDao
import com.example.bigburgermbarkimohamedtest.domaine.local.entitys.BurgerMenuLocalModel

@Database(
    entities = [BurgerMenuLocalModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
  abstract fun burgerMenuDao(): burgerMenuDao
    companion object {
        val DATABASE_NAME: String = "BurgerDatabase"
    }
}