package com.fr.djibril.facebookstories

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StoryScreen(user: User) {
    Column(modifier = Modifier.fillMaxSize()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()
                .clipToBounds()
                .clickable(onClick = {
                    //TODO Click to Show next Story Before passed list in Class
                    }),) {
                Image(
                    painter = painterResource(id = user.storyUser),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = null
                )

                Box(
                    modifier = Modifier
                        .wrapContentHeight()
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                ){
                    LineAnimation()
                }
                Surface(
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopStart)
                        .padding(start = 20.dp, top = 20.dp),
                    border = BorderStroke(width = 3.dp, color = Color(0xFF4267B2)),
                    shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = user.profilePicture),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                    )
                }

                Text(
                    text = user.name,
                    modifier = Modifier
                        .wrapContentHeight()
                        .align(Alignment.TopStart)
                        .padding(start = 70.dp, top = 30.dp),
                    color = Color.White,
                )

            }

        }
    }
}

@Composable
fun LineAnimation() {
    val animVal = remember { Animatable(0f) }
        LaunchedEffect(animVal) {
            animVal.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
        }

    Canvas(modifier = Modifier.fillMaxWidth()) {
        drawLine(
            color = Color.White,
            start = Offset(0f, 0f),
            end = Offset(animVal.value * size.width, animVal.value * size.height),
            strokeWidth = 5f
        )
    }
}

@Preview
@Composable
fun ProfilePreview() {
    val user = DataProvider.user
    StoryScreen(user = user)
}
