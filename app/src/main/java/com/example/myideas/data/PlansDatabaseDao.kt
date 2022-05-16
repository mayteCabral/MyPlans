package com.example.myideas.data

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.myideas.model.Plan
import kotlinx.coroutines.flow.Flow

@Dao
interface PlansDatabaseDao {

    @Query("SELECT * FROM plans_tbl")
    fun getPlans() : Flow<List<Plan>>

    @Query("SELECT * FROM plans_tbl WHERE id = :id")
    suspend fun getPlanById(id: String): Plan

    @Insert(onConflict = REPLACE)
    suspend fun insert(plan: Plan)

    @Update(onConflict = REPLACE)
    suspend fun update(plan: Plan)

    @Query("DELETE FROM plans_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deletePlan(plan: Plan)

}
