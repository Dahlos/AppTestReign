package com.dahlosdev.apptestreign.core

import android.content.Context
import androidx.room.Room
import com.dahlosdev.apptestreign.data.database.HackNewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, HackNewsDatabase::class.java, AppConstants.DATABASE_NAME)
            .build()


    @Singleton
    @Provides
    fun provideDaoHackNewsDao(db: HackNewsDatabase) = db.getHackNewsDao()
}