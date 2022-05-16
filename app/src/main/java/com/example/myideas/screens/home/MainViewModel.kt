package com.example.myideas.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myideas.model.Plan
import com.example.myideas.repository.PlanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PlanRepository) : ViewModel() {
    //private var planList = mutableStateListOf<Plan>()
    private var _planList = MutableStateFlow<List<Plan>>(emptyList())
    val planList = _planList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllPlan().distinctUntilChanged().collect { listPlan->

                if(!listPlan.isNullOrEmpty()){
                    _planList.value = listPlan
                }else{
                    Log.d("Empty", "There are not plans")
                }

            }
        }
        //planList.addAll(PlansDataSource().loadPlans())
    }

    fun addPlan(plan: Plan) = viewModelScope.launch{
        repository.addPlan(plan)
    }

    fun updatePlan(plan: Plan) = viewModelScope.launch{
        repository.updatePlan(plan)
    }

    fun removePlan(plan: Plan) = viewModelScope.launch{
        repository.deletePlan(plan)
    }

    fun getAllPlans(): List<Plan>{
        return planList.value
    }
}