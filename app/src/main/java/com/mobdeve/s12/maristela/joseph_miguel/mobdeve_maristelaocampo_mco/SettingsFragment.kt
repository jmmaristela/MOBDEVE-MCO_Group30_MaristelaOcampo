package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.LoginActivity
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R

class SettingsFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        auth = FirebaseAuth.getInstance()

        val signOutButton: Button = view.findViewById(R.id.btn_sign_out)
        signOutButton.setOnClickListener {
            signOut()
        }

        return view
    }

    private fun signOut() {
        auth.signOut()

        // Redirect to LoginActivity
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Close current activity
    }
}
