package com.fr.djibril.facebookstories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import com.fr.djibril.facebookstories.ui.theme.FacebookStoriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookStoriesTheme {
                val context = LocalContext.current
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(contentAlignment = Alignment.TopCenter) {
                        MyApp {
                            startActivity(StoryActivity.newIntent(context, it))
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMotionApi::class)
@Composable
private fun MyApp(navigateToStory: (User) -> Unit) {

    val listState = rememberLazyListState()

    val motionProgress by animateFloatAsState(targetValue = listState.firstVisibleItemIndex.toFloat()) {
        (it + 1) / listState.layoutInfo.totalItemsCount
    }

    LazyRow(
        state = listState,
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentHeight(),

        content = {
            stickyHeader {
                HeadStoryItem(progress = motionProgress.coerceIn(0f, 1f))
            }
            items(DataProvider.userList) {
                UserListItem(user = it, navigateToStory = navigateToStory)
            }
        })
}
