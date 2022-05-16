package com.example.myideas.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myideas.model.Plan
import com.example.myideas.utils.DateConverter
import com.example.myideas.utils.UUIDConverter

@Database(entities = [Plan::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class PlanDatabase : RoomDatabase() {

    abstract fun noteDao() : PlansDatabaseDao




}