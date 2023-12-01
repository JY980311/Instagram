package com.example.instagram.presentation.view

import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.Instagram.components.Doubletap
import com.example.Instagram.components.ImageIndicator
import com.example.instagram.ui.theme.InstagramGradient
import com.example.instagram.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Instagram(
    modifier: Modifier = Modifier
) {
    val isClickedFavorite = remember { mutableStateOf(false)}

    val mainImages = listOf(
        "https://picsum.photos/200/300?random=1",
        "https://picsum.photos/200/300?random=2",
        "https://picsum.photos/200/300?random=3",
        "https://picsum.photos/200/300?random=4",
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
    ) {
        mainImages.size
    }


    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(width = 100.dp, height = 50.dp),
                painter = painterResource(id = R.drawable.instagram_logo),
                contentDescription = "인스타로고"
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                IconButton(
                    modifier = Modifier.size(25.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.wriitebox),
                        contentDescription = "플러스모양"
                    )
                }

                IconButton(modifier = Modifier.size(25.dp), onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                        contentDescription = "하트"
                    )
                }

                IconButton(
                    modifier = Modifier
                        .size(25.dp)
                        .offset(y = -3.dp)
                        .graphicsLayer { rotationZ = -45f },
                    onClick = { /*TODO*/ }
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_send_24),
                        contentDescription = "비행기 모양"
                    )
                }
            }
        }

        LazyRow(
            content = {
                items(10) { index ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .padding(8.dp)
                                .background(
                                    brush = InstagramGradient,
                                    shape = RoundedCornerShape(50)
                                )
                                .padding(3.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = RoundedCornerShape(50)
                                )
                                .background(Color.White, shape = RoundedCornerShape(50))
                                .padding(2.dp)
                                .clip(shape = RoundedCornerShape(50))
                                .clickable { }
                        ) {
                            if (index == 0) {

                            } else {
                                Image(
                                    painter = rememberImagePainter(data = "https://picsum.photos/200/300?random=$index"),
                                    contentDescription = "Random Image",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                        if (index == 0){
                            Text(
                                text = "내 스토리",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        } else {
                            Text(
                                text = "박준용 $index",
                            )
                        }
                    }
                }
            })

        Divider(
            modifier = Modifier
                .padding(top = 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )

        LazyColumn() {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(50)
                            )
                            .clip(shape = RoundedCornerShape(50)),
                    ) {

                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Text(
                        modifier = Modifier.weight(1f),
                        text = "박준용_준용",
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(25.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.MoreVert,
                            contentDescription = "더보기"
                        )
                    }
                }
                /*val pagerState = remembverPagerState(0, 0f)*/

                HorizontalPager(state = pagerState) { page ->
                    Doubletap(
                        imageResource = mainImages[page],
                        iconResource = R.drawable.baseline_favorite_red_25
                    ) {
                        Log.d("pick","liked")
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        IconButton(
                            modifier = Modifier.size(25.dp),
                            onClick = {
                                isClickedFavorite.value = !isClickedFavorite.value
                            }
                        ) {
                            if (isClickedFavorite.value) {
                                Image(
                                    painter = painterResource(id =  R.drawable.baseline_favorite_red_25),
                                    contentDescription = "빨간 하트"
                                )
                            } else {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                                    contentDescription = "하트"
                                )
                            }
                        }

                        IconButton(
                            modifier = Modifier.size(25.dp),
                            onClick = { /*TODO*/ }
                        ) {
                            Image(
                                modifier = Modifier
                                    .scale(-1f, 1f),
                                painter = painterResource(id = R.drawable.baseline_chat_bubble_outline_24),
                                contentDescription = "메세지"
                            )
                        }

                        IconButton(
                            modifier = Modifier
                                .size(25.dp)
                                .offset(y = -3.dp)
                                .graphicsLayer { rotationZ = -45f },
                            onClick = { /*TODO*/ }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_send_24),
                                contentDescription = "비행기"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(0.2f))

                    ImageIndicator(
                        modifier = Modifier,
                        currentIndex = pagerState.currentPage,
                        itemCount = mainImages.size
                    )

                    Spacer(modifier = Modifier.weight(0.5f))

                    IconButton(
                        modifier = Modifier.size(25.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_turned_in_not_24),
                            contentDescription = "기록모양"
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    text = "2022 views"
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    text = "안녕하세요"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramPreview() {
    Instagram()
}