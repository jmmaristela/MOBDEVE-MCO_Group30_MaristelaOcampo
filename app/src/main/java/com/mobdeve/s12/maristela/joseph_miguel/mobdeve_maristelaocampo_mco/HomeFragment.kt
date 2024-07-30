package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val communityFeedButton: ImageButton = view.findViewById(R.id.tab_community_feed)
        val chatButton: ImageButton = view.findViewById(R.id.tab_chat)
        val discoverButton: ImageButton = view.findViewById(R.id.tab_discover)


        communityFeedButton.setOnClickListener {
            replaceFragment(CommunityFeedFragment())
        }

        chatButton.setOnClickListener {
            replaceFragment(ChatFragment())
        }

        discoverButton.setOnClickListener {
            replaceFragment(DiscoverFragment())
        }

        // Load the initial tab
        replaceFragment(CommunityFeedFragment())

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
