package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R

class StartActivityFragment : Fragment(R.layout.fragment_startactivity) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_startactivity, container, false)

        val startWorkoutButton = view.findViewById<Button>(R.id.button_start_workout)
        val foodTrackerButton = view.findViewById<Button>(R.id.button_food_tracker)
        val weightTrackerButton = view.findViewById<Button>(R.id.button_weight_tracker)

        startWorkoutButton.setOnClickListener {
            Toast.makeText(activity, "Start Workout Clicked", Toast.LENGTH_SHORT).show()
            // Implement functionality to start workout
        }

        foodTrackerButton.setOnClickListener {
            Toast.makeText(activity, "Food Tracker Clicked", Toast.LENGTH_SHORT).show()
            // Implement functionality to open food tracker
        }

        weightTrackerButton.setOnClickListener {
            Toast.makeText(activity, "Weight Tracker Clicked", Toast.LENGTH_SHORT).show()
            // Implement functionality to open weight tracker
        }

        return view
    }
}
