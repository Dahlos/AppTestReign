package com.dahlosdev.apptestreign.data.database.dao

import androidx.room.*
import com.dahlosdev.apptestreign.data.database.entities.HackNewsEntity
import com.dahlosdev.apptestreign.data.model.HackNewsModel

@Dao
interface HackNewsDao {

    @Query("SELECT * FROM hack_news_table")
    suspend fun getHackNews(): List<HackNewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(hackNews: List<HackNewsEntity>)

    @Query("DELETE FROM hack_news_table")
    suspend fun deleteAllHackNews()
}