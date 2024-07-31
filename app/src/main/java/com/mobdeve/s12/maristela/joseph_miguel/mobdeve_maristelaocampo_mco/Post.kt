package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.models

data class Post(
    val profileImageResId: Int,
    val profileName: String,
    val postTime: String,
    val postDescription: String,
    val activityType: String,
    val photoUri: Int? = null
)
