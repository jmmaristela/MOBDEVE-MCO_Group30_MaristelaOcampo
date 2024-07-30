package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.adapters.NotificationAdapter
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.models.Notification

class NotificationFragment : Fragment() {

    private lateinit var notificationRecyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var notificationList: MutableList<Notification>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        // Initialize the notification list
        notificationList = mutableListOf(
            Notification("New Message", "You have a new message from John."),
            Notification("Workout Reminder", "It's time for your daily workout!"),
            Notification("Achievement", "You've reached a new milestone!"),
            // Add more notifications here
        )

        // Set up the RecyclerView
        notificationRecyclerView = view.findViewById(R.id.notification_recycler_view)
        notificationRecyclerView.layoutManager = LinearLayoutManager(context)
        notificationAdapter = NotificationAdapter(notificationList)
        notificationRecyclerView.adapter = notificationAdapter

        return view
    }
}