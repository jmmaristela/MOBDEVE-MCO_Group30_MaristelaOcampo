package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.adapters.CommunityFeedAdapter
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.models.Post

class CommunityFeedFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CommunityFeedAdapter
    private lateinit var posts: List<Post>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_community_feed, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Sample data
        posts = listOf(
            Post(
                profileImageResId = R.drawable.pfp,
                profileName = "John Doe",
                postTime = "1 hour ago",
                postDescription = "Went for a morning run",
                activityType = "Running",
                photoUri = R.drawable.morning_run
            ),
            Post(
                profileImageResId = R.drawable.pfp,
                profileName = "Jane Smith",
                postTime = "2 hours ago",
                postDescription = "Did a great workout!",
                activityType = "Workout"
            )
        )

        adapter = CommunityFeedAdapter(posts)
        recyclerView.adapter = adapter

        return view
    }
}
