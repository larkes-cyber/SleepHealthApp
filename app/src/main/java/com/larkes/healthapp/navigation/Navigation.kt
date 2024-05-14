package com.larkes.healthapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.larkes.healthapp.ChartsScreen
import com.larkes.healthapp.MainScreen
import com.larkes.healthapp.SettingsScreen

@Composable
fun Navigation(navController: NavHostController) {



    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(navController = navController,
            startDestination = "main"
        ){

            composable("main"){
                MainScreen()
            }
            composable("charts"){
                ChartsScreen()
            }
            composable("settings"){
                SettingsScreen()
            }

        }
        BottomBar(modifier = Modifier.align(Alignment.BottomCenter),navController = navController)
    }

}