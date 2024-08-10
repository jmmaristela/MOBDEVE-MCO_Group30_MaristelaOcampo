package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.adapters.WorkoutAdapter
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.Workout

class DiscoverFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var workoutAdapter: WorkoutAdapter
    private val workouts = listOf(
        Workout("Full Body Workout", "cbKkB3POqaY"),
        Workout("Upper Body Strength", "MDcnGfznHV8"),
        Workout("Lower Body Strength", "X0xt0fYTZv8"),
        Workout("Shoulder", "jBPdbt0Fxb4"),
        Workout("Chest", "zoKu5Bw9rLU"),
        Workout("Arms", "JBJIhBl--pc"),
        Workout("Leg Day", "q7rCeOa_m58"),

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_discover, container, false)

        recyclerView = view.findViewById(R.id.recycler_view_discover)
        workoutAdapter = WorkoutAdapter(requireContext(), workouts)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = workoutAdapter
        }

        return view
    }
}
