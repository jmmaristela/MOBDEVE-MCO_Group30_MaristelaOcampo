package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat

class ConversationsAdapter(
    private val conversations: List<Conversation>,
    private val clickListener: (Conversation) -> Unit
) : RecyclerView.Adapter<ConversationsAdapter.ConversationViewHolder>() {

    class ConversationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.textViewName)
        val lastMessageTextView: TextView = view.findViewById(R.id.textViewLastMessage)
        val timestampTextView: TextView = view.findViewById(R.id.textViewTimestamp)
        val profileImageView: ImageView = view.findViewById(R.id.imageViewProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_conversation, parent, false)
        return ConversationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        val conversation = conversations[position]
        holder.nameTextView.text = conversation.name
        holder.lastMessageTextView.text = conversation.lastMessage
        holder.timestampTextView.text =
            DateFormat.getTimeInstance().format(conversation.timestamp)
        holder.profileImageView.setImageResource(conversation.profileImage)

        holder.itemView.setOnClickListener { clickListener(conversation) }
    }

    override fun getItemCount(): Int = conversations.size
}
