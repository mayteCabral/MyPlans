package com.example.myideas.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myideas.model.Plan

class SharedViewModel: ViewModel() {
    var plan by mutableStateOf<Plan?>(null)

    fun addPlan(newPlan: Plan){
        plan = newPlan
    }
}