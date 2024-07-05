package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landing)

    }
}