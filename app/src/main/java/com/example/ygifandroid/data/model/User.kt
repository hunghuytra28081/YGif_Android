package com.example.ygifandroid.data.model

data class User(
    val name: String = "",
    val avatarUrl: String = ""
)

object UserEntity{
    const val USER ="user"
    const val USERNAME = "username"
    const val AVATAR_URL = "avatar_url"
}