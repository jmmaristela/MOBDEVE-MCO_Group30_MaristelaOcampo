package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        // Delay for 2 seconds before moving to the next activity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, UserOptionActivity::class.java))
            finish() // Close the splash activity so the user can't return to it
        }, 2000) // 2000 milliseconds = 2 seconds
    }
}
