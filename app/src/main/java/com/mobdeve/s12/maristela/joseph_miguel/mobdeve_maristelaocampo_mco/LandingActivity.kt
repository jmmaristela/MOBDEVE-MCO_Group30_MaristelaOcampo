package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class LandingActivity : AppCompatActivity() {
    private lateinit var mainController: MainController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        Toast.makeText(this, "Welcome to the Fitness Pro App", Toast.LENGTH_SHORT).show()

        mainController = MainController(this)

        // Navigate to LoginActivity after 2 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            mainController.navigateToLogin()
            finish() // Finish this activity so the user cannot return to it
        }, 2000)
    }
}