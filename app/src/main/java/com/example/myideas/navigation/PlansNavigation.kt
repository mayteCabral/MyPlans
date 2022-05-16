package com.example.myideas.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myideas.screens.home.HomeScreen
import com.example.myideas.screens.home.MainViewModel
import com.example.myideas.screens.splash.SplashScreen

@ExperimentalComposeUiApi
@Composable
fun PlansNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = PlansScreens.SplashScreen.name){
        composable(PlansScreens.SplashScreen.name){
            SplashScreen(navController= navController)
        }

        composable(PlansScreens.HomeScreen.name){
            val mainViewModel = hiltViewModel<MainViewModel>()
            HomeScreen(navController = navController, viewModel = mainViewModel)
        }
    }
}