package com.fr.djibril.facebookstories


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fr.djibril.facebookstories.ui.theme.FacebookStoriesTheme

class StoryActivity :  ComponentActivity(){

    private val user: User by lazy {
        intent?.getSerializableExtra(USER_ID) as User
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookStoriesTheme {
                StoryScreen(user)
            }
        }
    }

    companion object {
        private const val USER_ID = "user_id"
        fun newIntent(context: Context, user: User) =
            Intent(context, StoryActivity::class.java).apply {
                putExtra(USER_ID, user)
            }
    }
}
