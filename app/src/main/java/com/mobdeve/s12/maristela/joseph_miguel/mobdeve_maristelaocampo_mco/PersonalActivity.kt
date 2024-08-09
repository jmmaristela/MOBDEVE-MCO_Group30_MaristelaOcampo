package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.databinding.ActivityRegisterInfoBinding

class PersonalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continueBtn.setOnClickListener {
            val fullName = binding.fullName.text.toString().trim()
            val address = binding.address.text.toString().trim()
            val gender = binding.gender.text.toString().trim()
            val weight = binding.approxWeight.text.toString().trim()
            val height = binding.approxHeight.text.toString().trim()

            if (fullName.isNotEmpty() && address.isNotEmpty() && gender.isNotEmpty() &&
                weight.isNotEmpty() && height.isNotEmpty()) {

                // Pass the data to RegisterActivity
                val intent = Intent(this, RegisterActivity::class.java)
                intent.putExtra("fullName", fullName)
                intent.putExtra("address", address)
                intent.putExtra("gender", gender)
                intent.putExtra("weight", weight)
                intent.putExtra("height", height)
                startActivity(intent)

                finish()
            } else {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
