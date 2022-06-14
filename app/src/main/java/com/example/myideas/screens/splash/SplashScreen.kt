package com.example.myideas.screens.splash

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myideas.R
import com.example.myideas.data.PlansDataSource
import com.example.myideas.navigation.PlansScreens
import com.example.myideas.screens.SharedViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (navController: NavController, sharedViewModel: SharedViewModel){
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            ))

        delay(2000L)

        val text1 = "holi"
        val text2 = "crayoli"
        val plan = PlansDataSource().loadPlans()[0]

        //normal
        //navController.navigate(PlansScreens.HomeScreen.name )

        //navigate with variables
        //navController.navigate(PlansScreens.HomeScreen.name + "/$text1/$text2")

        //navigate with parcelable
        /*
        val plan = PlansDataSource().loadPlans()[0]
        navController.currentBackStackEntry?.savedStateHandle?.set("plan", plan)
        navController.navigate(PlansScreens.ParceScreen.name)*/

        //navigate with Shared Viewmodel
        //sharedViewModel.addPlan(plan)
        //navController.navigate(PlansScreens.SharedScreen.name)
    })

    Surface(modifier = Modifier
    .padding(15.dp)
    .size(330.dp)
    .scale(scale.value),
    shape = CircleShape,
    color = Color.White,
    border = BorderStroke(width = 2.dp, color = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.ic_baseline_note_alt),
                contentDescription = "plan splash",
                modifier = Modifier.size(95.dp),
                contentScale = ContentScale.Fit)
            Text(text = "Super Planner App!!",
                style = MaterialTheme.typography.h5)
        }
    }
}