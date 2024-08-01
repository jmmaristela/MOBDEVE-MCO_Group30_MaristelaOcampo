package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R


class StartActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_startactivity, container, false)

        // Immediately replace with WorkoutFragment
        replaceFragment(WorkoutFragment())

        val startWorkoutButton: ImageButton = view.findViewById(R.id.button_start_workout)
        val foodTrackerButton: ImageButton = view.findViewById(R.id.button_food_tracker)
        val weightTrackerButton: ImageButton = view.findViewById(R.id.button_weight_tracker)

        startWorkoutButton.setOnClickListener {
            replaceFragment(WorkoutFragment())
        }

        // foodTrackerButton.setOnClickListener {
        // Replace with the fragment or activity you want to start
        //    replaceFragment(FoodTrackerFragment())
        //  }

        // weightTrackerButton.setOnClickListener {
        // Replace with the fragment or activity you want to start
        //   replaceFragment(WeightTrackerFragment())
        // }

        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            replace(R.id.tab_container, fragment)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            commit()
        }
    }
}
