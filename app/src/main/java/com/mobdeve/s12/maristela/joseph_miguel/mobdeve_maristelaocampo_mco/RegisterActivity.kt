package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.databinding.ActivityRegisterInfoBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Add your registration logic here
    }
}
