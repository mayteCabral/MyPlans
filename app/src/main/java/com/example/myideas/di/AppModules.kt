package com.example.myideas.di

import android.content.Context
import androidx.room.Room
import com.example.myideas.data.PlanDatabase
import com.example.myideas.data.PlansDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModules {
    @Singleton
    @Provides
    fun provideNotesDao(planDatabase: PlanDatabase): PlansDatabaseDao = planDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) : PlanDatabase = Room.databaseBuilder(
        context,
        PlanDatabase::class.java,
        "planss_db"
    ).fallbackToDestructiveMigration().build()

}