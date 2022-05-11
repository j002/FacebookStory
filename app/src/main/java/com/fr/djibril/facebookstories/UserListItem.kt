package com.fr.djibril.facebookstories

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserListItem(user: User, navigateToStory: (User) -> Unit) {
    Card(
        modifier = Modifier.size(height = 200.dp, width = 120.dp),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Row(Modifier.clickable { navigateToStory(user)}) {
            UserItem(user)

        }
    }
}

@Composable
private fun UserItem(user: User) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = user.storyUser),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )
        Surface(
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.TopStart)
                .padding(8.dp),
            border = BorderStroke(width = 3.dp, color = Color(0xFF4267B2)),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = user.profilePicture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Card(
            backgroundColor = Color.Black.copy(alpha = 0.3f),
            shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp),
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomStart)
        ){
            Text(
                text = user.name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp),
                style = MaterialTheme.typography.subtitle2.copy(
                    fontSize = 14.sp,
                    color = Color.White,
                )
            )
        }

    }

}

@Preview
@Composable
fun PreviewUserItem() {
    val user = DataProvider.user
    UserListItem(user = user, navigateToStory = {})
}
