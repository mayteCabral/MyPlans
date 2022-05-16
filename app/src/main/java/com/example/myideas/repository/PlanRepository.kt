package com.example.myideas.repository

import com.example.myideas.data.PlansDatabaseDao
import com.example.myideas.model.Plan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlanRepository @Inject constructor(private val plansDao : PlansDatabaseDao) {

    suspend fun addPlan(plan: Plan) = plansDao.insert(plan = plan)
    suspend fun updatePlan(plan: Plan) = plansDao.update(plan)
    suspend fun deletePlan(plan: Plan) = plansDao.deletePlan(plan)
    suspend fun deleteAll() = plansDao.deleteAll()

    fun getAllPlan(): Flow<List<Plan>> = plansDao.getPlans().flowOn(Dispatchers.IO).conflate()
}