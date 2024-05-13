package com.larkes.healthapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.larkes.healthapp.R

@Composable
fun BottomBar(modifier: Modifier, navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // observe current route to change the icon
    // color,label color when navigated
    val currentRoute = navBackStackEntry?.destination?.route

    Box(modifier) {

        Box(modifier = Modifier
          ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 40.dp, vertical = 8.dp)
                .padding(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                BottomNavItem(
                    title = "Главная",
                    icon = R.drawable.baseline_home_24,
                    active = currentRoute == "main"
                ){
                    navController.navigate("main")
                }
                BottomNavItem(
                    title = "Aналитика",
                    icon = R.drawable.baseline_bar_chart_24,
                    active = currentRoute == "charts"
                ){
                    navController.navigate("charts")
                }
                BottomNavItem(
                    title = "Настройки",
                    icon = R.drawable.baseline_settings_24,
                    active = currentRoute == "settings"
                ){
                    navController.navigate("settings")
                }

            }
        }
        Box(modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.04f))) {

        }
    }


}

@Composable
fun BottomNavItem(
    title:String,
    active:Boolean,
    icon:Int,
    onClick:() -> Unit
) {
    Button(
        onClick = { onClick() },
        contentPadding = PaddingValues(0.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier
                    .size(28.dp)
            )
            if(active) Text(text = title)
        }

    }
}