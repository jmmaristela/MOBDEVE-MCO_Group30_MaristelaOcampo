package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.databinding.ActivityRegisterAccountBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Add your registration logic here
    }
}