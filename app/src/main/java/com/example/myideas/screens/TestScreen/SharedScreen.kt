package com.example.myideas.screens.TestScreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.myideas.screens.SharedViewModel

@Composable
fun SharedScreen(sharedViewModel: SharedViewModel){
    Text(text = sharedViewModel.plan!!.title)

}