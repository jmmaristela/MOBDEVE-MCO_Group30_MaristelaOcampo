package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.Message
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R

class MessagesAdapter(private val messages: List<Message>) : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message)
    }

    override fun getItemCount() = messages.size

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewMessage: TextView = itemView.findViewById(R.id.textViewMessage)
        private val textViewTimestamp: TextView = itemView.findViewById(R.id.textViewTimestamp)

        fun bind(message: Message) {
            textViewMessage.text = message.content
            textViewTimestamp.text = android.text.format.DateFormat.format("hh:mm a", message.timestamp)
        }
    }
}
