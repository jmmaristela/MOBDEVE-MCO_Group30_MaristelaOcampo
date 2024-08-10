package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import kotlin.concurrent.timer
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R

class WorkoutFragment : Fragment() {

    private lateinit var timer: Chronometer
    private lateinit var textEstimatedCalories: TextView
    private lateinit var textPedometerStatus: TextView
    private lateinit var buttonStartWorkout: Button
    private var isRunning = false
    private var steps = 0
    private var calories = 0.0
    private lateinit var firestore: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private var workoutType: String = "Running"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_workout, container, false)

        // Initialize Firestore and FirebaseAuth
        firestore = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

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

        // Set spinner background color to white
        spinnerWorkoutType.setBackgroundColor(requireContext().getColor(android.R.color.white))

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

        // Set the workout type
        workoutType = view?.findViewById<Spinner>(R.id.spinner_workout_type)?.selectedItem.toString()

        // Start pedometer if possible
        // Initialize pedometer here if required

        // Periodically update calories and steps
        startTracking()
    }

    private fun stopWorkout() {
        isRunning = false
        buttonStartWorkout.text = getString(R.string.start)
        timer.stop()

        // Stop pedometer if possible
        // Finalize pedometer here if required

        // Calculate estimated calories burned
        textEstimatedCalories.text = "$calories kcal"
        textPedometerStatus.text = "Steps: $steps"

        // Save workout data to Firestore
        saveWorkoutToFirestore()
    }

    private fun startTracking() {
        timer(period = 1000) { // Update every second
            if (isRunning) {
                steps += 1
                calories = steps / 20.0

                // Update UI
                requireActivity().runOnUiThread {
                    textEstimatedCalories.text = "${calories.toInt()} kcal"
                    textPedometerStatus.text = "Steps: $steps"
                }
            }
        }
    }

    private fun saveWorkoutToFirestore() {
        val userId = auth.currentUser?.uid ?: return // Get the user ID
        val elapsedMillis = SystemClock.elapsedRealtime() - timer.base
        val elapsedMinutes = elapsedMillis / 1000 / 60

        // Create a workout data object
        val workoutData = hashMapOf(
            "type" to workoutType,
            "duration" to elapsedMinutes,
            "calories" to calories.toLong(),
            "steps" to steps,
            "timestamp" to System.currentTimeMillis()
        )

        // Save the workout data to the user's Firestore document
        firestore.collection("users").document(userId)
            .collection("recent_activities")
            .add(workoutData)
            .addOnSuccessListener {
                // Successfully saved workout data
                // You can show a Toast or update the UI here if needed
            }
            .addOnFailureListener { e ->
                // Handle any errors that occur
                e.printStackTrace()
            }
    }
}
