package com.example.myideas.screens.TestScreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.myideas.model.Plan

@Composable
fun ParceScreen(plan: Plan){
    Text(plan.title)
}