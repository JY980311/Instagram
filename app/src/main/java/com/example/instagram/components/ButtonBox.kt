package com.example.Instagram.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instagram.R

@Composable
fun CircleBoxButton(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(25.dp)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(50)
            )
            .clip(shape = RoundedCornerShape(50)),
    )
}

@Composable
fun WriteBox() {
    Box(modifier = Modifier
        .size(25.dp)
        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(15))
        .clickable { }) {
        IconButton(modifier = Modifier.size(25.dp), onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "+")
        }
    }
}

@Composable
fun ImageIndicator(modifier: Modifier = Modifier,currentIndex:Int , itemCount:Int) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ){
        repeat(itemCount){
            Spacer(modifier = Modifier.size(8.dp))
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(shape = CircleShape)
                    .background(
                        color = if (it == currentIndex) Color.Blue else Color.Gray
                    )
            )
        }
    }
}