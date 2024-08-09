package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.databinding.ActivityRegisterAccountBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterAccountBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Disable the create button initially
        binding.createBtn.isEnabled = false

        // Add TextWatcher to monitor changes in the input fields
        binding.email.addTextChangedListener(inputWatcher)
        binding.username.addTextChangedListener(inputWatcher)
        binding.password.addTextChangedListener(inputWatcher)
        binding.passwordConfirm.addTextChangedListener(inputWatcher)

        binding.createBtn.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()
            val passwordConfirm = binding.passwordConfirm.text.toString().trim()

            // Validate email format
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if password and confirm password match
            if (password != passwordConfirm) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Proceed with Firebase registration
            registerUser(email, password)
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registration successful
                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()

                    // Navigate to LoginActivity
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    // Registration failed
                    Toast.makeText(this, "Registration failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private val inputWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Check if all fields are filled
            val email = binding.email.text.toString().trim()
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()
            val passwordConfirm = binding.passwordConfirm.text.toString().trim()

            binding.createBtn.isEnabled = email.isNotEmpty() &&
                    username.isNotEmpty() &&
                    password.isNotEmpty() &&
                    passwordConfirm.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {}
    }
}
