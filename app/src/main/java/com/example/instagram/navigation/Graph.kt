package com.example.instagram.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagram.presentation.view.Instagram
import com.example.instagram.presentation.view.NotificationScreen
import com.example.instagram.presentation.view.ProfileScreen
import com.example.instagram.presentation.view.SearchScreen
import com.example.instagram.presentation.view.WriteScreen

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Instagram()
        }
        composable("search") {
            SearchScreen()
        }
        composable("write") {
            WriteScreen()
        }
        composable("notification") {
            NotificationScreen()
        }
        composable("profile") {
            ProfileScreen()
        }
    }
}

