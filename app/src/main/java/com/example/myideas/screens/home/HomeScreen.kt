package com.example.myideas.screens.home

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myideas.components.PlansButton
import com.example.myideas.components.PlansInputText
import com.example.myideas.components.PlansTopBar
import com.example.myideas.model.Plan
import com.example.myideas.utils.formatDate

@Preview(showBackground = true)
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    viewModel: MainViewModel = hiltViewModel()
){
    Scaffold(topBar = {
        PlansTopBar(
            title = "Add Plan",
            //icon = Icons.Default.ArrowBack,
            isMainScreen = true,
            onButtonClicked = {
                navController.popBackStack()
            }
        )
    }) {
        MainContent(viewModel)
    }
}


@ExperimentalComposeUiApi
@Composable
fun MainContent(viewModel: MainViewModel) {

    //var plans = PlansDataSource().loadPlans()
    var plans = viewModel.planList.collectAsState().value

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(modifier = Modifier.padding(6.dp)) {
        //Content
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            PlansInputText(
                modifier= Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = title,
                label = "Title",
                onTextChanged = {
                    if(it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                })

            PlansInputText(
                modifier= Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = description,
                label = "Plan description",
                onTextChanged = {
                    if(it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                })


            PlansButton(text = "Save",
                onClick = {
                    if(title.isNotEmpty() && description.isNotEmpty()){
                        viewModel.addPlan(Plan(title = title, description = description))
                        title = ""
                        description = ""

                        Toast.makeText(context, "Plan Added", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        Divider(modifier = Modifier.padding(10.dp))

        //dynamic must change "items" if it was hardcored before
        if(viewModel.listState.collectAsState().value){
            LazyColumn{
                items(plans){plan ->
                    PlanItem(plan= plan,
                        onPlanClicked = {
                            viewModel.removePlan(it)
                        })
                }
            }
        }else{
            Text(text = "You don't have any plans")
        }
        
        //hardcoded
        /*LazyColumn{
            items(plans){plan ->
                PlanItem(plan= plan,
                    onPlanClicked = {
                        //TODO
                    })
            }
        }*/
    }
}

@Composable
fun PlanItem(
    modifier: Modifier = Modifier,
    plan: Plan,
    onPlanClicked: (Plan) -> Unit
){
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(23.dp)),
        color = Color.Red.copy(alpha = 0.4f)
    ) {
        Column(modifier = modifier
            .clickable { onPlanClicked(plan) }
            .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = plan.title,
                style = MaterialTheme.typography.subtitle2)

            Text(text = plan.description,
                style = MaterialTheme.typography.subtitle1)

            Text(text = formatDate(plan.entryDate.time),
                style = MaterialTheme.typography.caption)
        }
    }
}



