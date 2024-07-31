package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

data class Conversation(
    val id: String,
    val name: String,
    val lastMessage: String,
    val timestamp: Long,
    val profileImage: Int // resource ID for the profile image
)

