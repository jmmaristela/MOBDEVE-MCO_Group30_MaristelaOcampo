package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R

class ProfileFragment : Fragment() {

    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val settingsButton: ImageButton = view.findViewById(R.id.settingsButton)
        settingsButton.setOnClickListener {
            // Replace current fragment with SettingsFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SettingsFragment())
                .addToBackStack(null) // Add this transaction to the back stack
                .commit()
        }

        val recentActivitiesLayout: LinearLayout = view.findViewById(R.id.recent_activities_layout)

        fetchRecentActivities(recentActivitiesLayout)

        return view
    }

    private fun fetchRecentActivities(layout: LinearLayout) {
        val userId = auth.currentUser?.uid ?: return
        val recentActivitiesRef = firestore.collection("users").document(userId).collection("recent_activities")

        recentActivitiesRef.orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                layout.removeAllViews() // Clear previous views
                for (document in documents) {
                    val workoutType = document.getString("type") ?: "Unknown"
                    val caloriesBurned = document.getLong("calories") ?: 0L

                    addActivityToLayout(layout, workoutType, caloriesBurned)
                }
            }
    }

    private fun addActivityToLayout(layout: LinearLayout, workoutType: String, caloriesBurned: Long) {
        val activityView = LayoutInflater.from(requireContext()).inflate(R.layout.item_recent_activity, layout, false)

        val workoutTypeTextView: TextView = activityView.findViewById(R.id.text_workout_type)
        val caloriesBurnedTextView: TextView = activityView.findViewById(R.id.text_calories_burned)

        workoutTypeTextView.text = workoutType
        caloriesBurnedTextView.text = "$caloriesBurned kcal"

        layout.addView(activityView)
    }
}
