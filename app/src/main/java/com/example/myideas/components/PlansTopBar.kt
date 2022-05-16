package com.example.myideas.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Preview
@Composable
fun PlansTopBar(
    title:String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = false,
    elevation: Dp = 0.dp,
    navController: NavController = NavController(LocalContext.current),
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {},

    ) {
    val showDialog = remember{
        mutableStateOf(false)
    }

    val showIt = remember {
        mutableStateOf(false)

    }



    TopAppBar(title = {
        Text(text = title,
            color = Color.White,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
        )
    },

        navigationIcon = {
            if(icon != null){
                Icon(imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        onButtonClicked.invoke()
                    })
            }


        },
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        elevation = elevation)
}