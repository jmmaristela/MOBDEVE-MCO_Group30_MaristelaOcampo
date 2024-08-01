package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.fragments

import android.os.Bundle
import android.os.SystemClock
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Chronometer
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R


class WorkoutFragment : Fragment() {

    private lateinit var timer: Chronometer
    private lateinit var textEstimatedCalories: TextView
    private lateinit var textPedometerStatus: TextView
    private lateinit var buttonStartWorkout: Button
    private var isRunning = false
    private var steps = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_workout, container, false)

        val spinnerWorkoutType: Spinner = view.findViewById(R.id.spinner_workout_type)
        timer = view.findViewById(R.id.text_timer)
        textEstimatedCalories = view.findViewById(R.id.text_estimated_calories)
        textPedometerStatus = view.findViewById(R.id.text_pedometer_status)
        buttonStartWorkout = view.findViewById(R.id.button_start_workout)

        // Set up spinner with workout types
        val workoutTypes = arrayOf("Running", "Walking", "Cycling")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, workoutTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerWorkoutType.adapter = adapter

        // Set up button click listener
        buttonStartWorkout.setOnClickListener {
            if (isRunning) {
                stopWorkout()
            } else {
                startWorkout()
            }
        }

        return view
    }

    private fun startWorkout() {
        isRunning = true
        buttonStartWorkout.text = getString(R.string.stop)
        timer.base = SystemClock.elapsedRealtime()
        timer.start()

        // Start pedometer if possible
        // Initialize pedometer here if required
    }

    private fun stopWorkout() {
        isRunning = false
        buttonStartWorkout.text = getString(R.string.start)
        timer.stop()

        // Stop pedometer if possible
        // Finalize pedometer here if required

        // Calculate estimated calories burned (example logic)
        val elapsedMillis = SystemClock.elapsedRealtime() - timer.base
        val elapsedMinutes = elapsedMillis / 1000 / 60
        val estimatedCalories = elapsedMinutes * (if (steps > 0) steps else 1) // Simplified calculation
        textEstimatedCalories.text = "$estimatedCalories kcal"
    }
}
