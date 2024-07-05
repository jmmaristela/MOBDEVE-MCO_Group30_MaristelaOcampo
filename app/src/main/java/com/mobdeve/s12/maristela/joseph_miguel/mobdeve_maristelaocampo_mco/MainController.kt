package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.content.Context
import android.content.Intent

class MainController(private val context: Context) {

    fun navigateToLogin() {
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
    }

    // Add other navigation methods as needed
}
