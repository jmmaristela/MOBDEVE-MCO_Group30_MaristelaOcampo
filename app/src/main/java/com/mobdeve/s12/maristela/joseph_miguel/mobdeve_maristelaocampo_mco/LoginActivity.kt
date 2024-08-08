package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            if (binding.username.text.toString() == "user" && binding.password.text.toString() == "1234") {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                // Navigate to the home screen or another activity
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        // Style the "Sign Up" text
        val signUpText = "Don't have an account? Sign Up"
        val spannableString = SpannableString(signUpText)
        val signUpStart = signUpText.indexOf("Sign Up")
        val signUpEnd = signUpStart + "Sign Up".length

        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#1000ff")), // Light blue color
            signUpStart,
            signUpEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            UnderlineSpan(),
            signUpStart,
            signUpEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.signUpLink.text = spannableString
        binding.signUpLink.movementMethod = LinkMovementMethod.getInstance()

        binding.signUpLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}