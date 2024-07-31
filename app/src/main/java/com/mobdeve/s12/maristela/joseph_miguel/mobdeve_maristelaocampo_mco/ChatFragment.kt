package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.Conversation
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.ConversationsAdapter
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R

class ChatFragment : Fragment() {

    private val conversations = mutableListOf<Conversation>()
    private lateinit var adapter: ConversationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewConversations)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ConversationsAdapter(conversations) { conversation ->
            // Handle conversation click here, e.g., open chat details
        }
        recyclerView.adapter = adapter

        // Load conversations (you might fetch this data from a database or API)
        loadConversations()
    }

    private fun loadConversations() {
        // Dummy data
        conversations.addAll(listOf(
            Conversation("1", "Alice", "Hey, how are you?", System.currentTimeMillis(), R.drawable.pfp),
            Conversation("2", "Bob", "Let's meet up tomorrow.", System.currentTimeMillis(), R.drawable.pfp),
            // Add more conversations
        ))
        adapter.notifyDataSetChanged()
    }
}
