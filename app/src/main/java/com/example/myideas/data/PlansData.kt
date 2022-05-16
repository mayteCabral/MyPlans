package com.example.myideas.data

import com.example.myideas.model.Plan

class PlansDataSource {
    fun loadPlans(): List<Plan>{
        return listOf(
            Plan(title = "go to the super", description = "we need tomatoes and onions"),
            Plan(title = "petco", description = "there is no more cat food"),
            Plan(title = "garden", description = "today is watering day"),
            Plan(title = "veterinary", description = "Zuly needs his anual vaccines"),
        )
    }
}