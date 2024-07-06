package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.databinding.FragmentRegisterInfoBinding

class RegisterFragment : AppCompatActivity() {

    private lateinit var binding: FragmentRegisterInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentRegisterInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Add your registration logic here
    }
}