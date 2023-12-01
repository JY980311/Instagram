package com.example.instagram.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.Navigation
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.instagram.navigation.BottomNavItem
import kotlinx.coroutines.selects.select

@Composable
fun BottomNavigationBar(
    naveController: NavHostController,
) {
    var items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Write,
        BottomNavItem.Notification,
        BottomNavItem.Profile
    )

    var isSelectedTab by remember {
        mutableStateOf("home")
    }

    NavigationBar(
        modifier = Modifier
            .height(54.dp),
        containerColor = Color.Transparent,
        contentColor = Color.Black,
    ) {
        items.forEach { item ->
            NavigationBarItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                selected = item.screenRoute == naveController.currentDestination?.route,
                onClick = {
                    naveController.navigate(item.screenRoute)
                    isSelectedTab = item.screenRoute
                },
                icon = { item.icon( item.screenRoute == isSelectedTab) },
            )
        }
    }
}

