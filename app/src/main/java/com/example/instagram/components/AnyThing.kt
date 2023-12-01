package com.example.Instagram.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.instagram.R

@Composable
fun CircleBoxButton(
    modifier: Modifier = Modifier,
    isSelect: Boolean = false,
) {
    Box(
        modifier = modifier
            .size(25.dp)
            .border(
                width = 2.dp,
                color = if (isSelect) Color.Red else Color.Black,
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
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "+"
            )
        }
    }
}

@Composable
fun ImageIndicator(modifier: Modifier = Modifier, currentIndex: Int, itemCount: Int) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(itemCount) {
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

@Composable
fun Doubletap(
    imageResource: String,
    iconResource: Int,
    size: Dp = 200.dp,
    onDoubleTap: () -> Unit
) {
    var isLike by remember { mutableStateOf(false) }
    val animatedSize by animateDpAsState(
        targetValue = if (isLike) size else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = 500f
        ), label = ""
    )
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .size(500.dp)
                .border(width = 1.dp, color = Color.Black)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            isLike = true
                            onDoubleTap()
                        }
                    )
                },
            painter = rememberImagePainter(data = imageResource),
            contentDescription = "이미지 넣는 곳",
        )

        if (isLike) {
            Icon(
                painterResource(id = iconResource),
                tint = Color.White,
                modifier = Modifier
                    .size(animatedSize)
                    .align(alignment = androidx.compose.ui.Alignment.Center),
                contentDescription = ""
            )
            if (animatedSize == size) {
                isLike = false
            }
        }
    }
}