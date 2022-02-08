package com.dahlosdev.apptestreign.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dahlosdev.apptestreign.data.database.dao.HackNewsDao
import com.dahlosdev.apptestreign.data.database.entities.HackNewsEntity

@Database(entities = [HackNewsEntity::class], version = 1)
abstract class HackNewsDatabase : RoomDatabase() {

    abstract fun getHackNewsDao(): HackNewsDao
}