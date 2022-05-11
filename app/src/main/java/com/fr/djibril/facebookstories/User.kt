package com.fr.djibril.facebookstories

import java.io.Serializable

data class User(val id: Int, val name: String, val profilePicture: Int, val storyUser: Int):
    Serializable

object DataProvider {

    val user = User(
        id = 1,
        name = "Djibril",
        profilePicture = R.drawable.image1,
        storyUser = R.drawable.image1
    )

    val userList = listOf(
        User(
            id = 1,
            name = "Sarr",
            profilePicture = R.drawable.image1,
            storyUser = R.drawable.image1
        ),
        User(
            id = 2,
            name = "Cisko",
            profilePicture = R.drawable.image2,
            storyUser = R.drawable.image2
        ),
        User(
            id = 3,
            name = "Alioune",
            profilePicture = R.drawable.image3,
            storyUser = R.drawable.image3
        ),
        User(
            id = 4,
            name = "Ramcess",
            profilePicture = R.drawable.image4,
            storyUser = R.drawable.image4
        ),
        User(
            id = 9,
            name = "Sono",
            profilePicture = R.drawable.image9,
            storyUser = R.drawable.image9
        ),
        User(
            id = 5,
            name = "Kebetu",
            profilePicture = R.drawable.image5,
            storyUser = R.drawable.image5
        ),
        User(
            id = 6,
            name = "Nazim",
            profilePicture = R.drawable.image6,
            storyUser = R.drawable.image6
        ),
        User(
            id = 7,
            name = "Luqman",
            profilePicture = R.drawable.image7,
            storyUser = R.drawable.image7
        ),
        User(
            id = 8,
            name = "Elimane",
            profilePicture = R.drawable.image8,
            storyUser = R.drawable.image8
        ),

        User(
            id = 10,
            name = "Team 1",
            profilePicture = R.drawable.image10,
            storyUser = R.drawable.image10
        )
    )
}