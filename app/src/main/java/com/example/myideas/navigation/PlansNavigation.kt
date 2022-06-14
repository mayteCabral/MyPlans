package com.example.myideas.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myideas.model.Plan
import com.example.myideas.screens.SharedViewModel
import com.example.myideas.screens.TestScreen.ParceScreen
import com.example.myideas.screens.TestScreen.SharedScreen
import com.example.myideas.screens.home.HomeScreen
import com.example.myideas.screens.home.MainViewModel
import com.example.myideas.screens.splash.SplashScreen

@ExperimentalComposeUiApi
@Composable
fun PlansNavigation() {
    val navController = rememberNavController()
    val sharedViewModel : SharedViewModel = viewModel()
    NavHost(navController, startDestination = PlansScreens.SplashScreen.name){

        composable(PlansScreens.SplashScreen.name){
            SplashScreen(navController= navController, sharedViewModel = sharedViewModel)
        }

        /*composable(PlansScreens.HomeScreen.name){
            val mainViewModel = hiltViewModel<MainViewModel>()
            HomeScreen(navController = navController, viewModel = mainViewModel)
        }*/

        composable("${PlansScreens.HomeScreen.name}/{testText1}/{testText2}",
            arguments = listOf(
                navArgument("testText1"){
                    type = NavType.StringType
                },
                navArgument("testText2"){
                    type = NavType.StringType
                }
            )){ navBack->

                val text1 = navBack.arguments?.getString("testText1")
                val text2 = navBack.arguments?.getString("testText2")

                val mainViewModel = hiltViewModel<MainViewModel>()
                HomeScreen(navController = navController, viewModel = mainViewModel, testText = text1.toString(), testText2 = text2.toString())


        }

        composable("${PlansScreens.ParceScreen.name}"){
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Plan>("plan")

            ParceScreen(plan = result!!)
        }

        composable("${PlansScreens.SharedScreen.name}"){
            SharedScreen(sharedViewModel = sharedViewModel)
        }
    }
}