package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.databinding.ActivityRegisterAccountBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterAccountBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var fullName: String
    private lateinit var address: String
    private lateinit var gender: String
    private lateinit var weight: String
    private lateinit var height: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth and Firestore
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Get personal information from PersonalActivity
        fullName = intent.getStringExtra("fullName").toString()
        address = intent.getStringExtra("address").toString()
        gender = intent.getStringExtra("gender").toString()
        weight = intent.getStringExtra("weight").toString()
        height = intent.getStringExtra("height").toString()


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

            // Check for duplicate username
            checkUsernameExists(username, email, password)
        }
    }

    private fun checkUsernameExists(username: String, email: String, password: String) {
        db.collection("users")
            .whereEqualTo("username", username)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    // Username is unique, proceed with registration
                    registerUser(email, username, password)
                } else {
                    Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error checking username: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun registerUser(email: String, username: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Save the user information in Firestore
                    val user = hashMapOf(
                        "email" to email,
                        "username" to username,
                        "fullName" to fullName,
                        "address" to address,
                        "gender" to gender,
                        "weight" to weight,
                        "height" to height
                    )

                    db.collection("users").document(auth.currentUser!!.uid)
                        .set(user)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()

                            // Navigate to LoginActivity
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error saving user: ${e.message}", Toast.LENGTH_SHORT).show()
                        }

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
