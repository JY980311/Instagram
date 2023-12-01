package com.example.instagram.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.Instagram.components.CircleBoxButton
import com.example.instagram.R

sealed class BottomNavItem(
    val title: String, val icon:@Composable (Boolean) -> Unit, val screenRoute: String
    /*여기서 ()은 함수가 매개변수를 받지 않음을 나타내고, Unit은 함수가 아무런 값을 반환하지 않음을 나타냄.
        즉, () -> Unit 타입의 함수는 매개변수를 받지 않고 아무런 값을 반환하지 않는 함수를 나타냄*/
) {
    object Home : BottomNavItem(
        title = "",
        icon = { isSelect ->
            Image(
                painter = painterResource(id = R.drawable.baseline_home_24),
                contentDescription = null,
                colorFilter = if (isSelect) ColorFilter.tint(Color.Red) else ColorFilter.tint(Color.Black)
            )
        },
        screenRoute = HOME_ROUTE
    )

    object Search : BottomNavItem(
        title = "",
        icon = {
            Image(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = null,
            )
        },
        screenRoute = SEARCH_ROUTE
    )

    object Write : BottomNavItem(
        title = "",
        icon = { Image(painter = painterResource(id = R.drawable.wriitebox), contentDescription = null) },
        screenRoute = WRITE_ROUTE
    )

    object Notification : BottomNavItem(
        title = "",
        icon = { Image(painter = painterResource(id = R.drawable.baseline_turned_in_not_24), contentDescription = null) },
        screenRoute = NOTIFICATION_ROUTE
    )

    object Profile : BottomNavItem(
        title = "",
        icon = {CircleBoxButton()},
        screenRoute = PROFILE_ROUTE
    )
}