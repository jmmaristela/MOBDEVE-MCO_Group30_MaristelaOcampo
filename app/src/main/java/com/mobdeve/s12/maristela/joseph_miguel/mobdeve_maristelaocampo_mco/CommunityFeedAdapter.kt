package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.models.Post

class CommunityFeedAdapter(private val posts: List<Post>) : RecyclerView.Adapter<CommunityFeedAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImageView: ImageView = itemView.findViewById(R.id.profileImageView)
        val profileNameTextView: TextView = itemView.findViewById(R.id.profileNameTextView)
        val postTimeTextView: TextView = itemView.findViewById(R.id.postTimeTextView)
        val postDescriptionTextView: TextView = itemView.findViewById(R.id.postDescriptionTextView)
        val activityTypeTextView: TextView = itemView.findViewById(R.id.activityTypeTextView)
        val postImageView: ImageView = itemView.findViewById(R.id.postImageView)
        val likeButton: ImageButton = itemView.findViewById(R.id.likeButton)
        val commentButton: ImageButton = itemView.findViewById(R.id.commentButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.profileImageView.setImageResource(post.profileImageResId)
        holder.profileNameTextView.text = post.profileName
        holder.postTimeTextView.text = post.postTime
        holder.postDescriptionTextView.text = post.postDescription
        holder.activityTypeTextView.text = post.activityType

        // Set the photo if it exists, else hide the ImageView
        if (post.photoUri != null) {
            holder.postImageView.visibility = View.VISIBLE
            holder.postImageView.setImageResource(post.photoUri)
        } else {
            holder.postImageView.visibility = View.GONE
        }

        // Set up click listeners for like and comment buttons if needed
    }

    override fun getItemCount() = posts.size
}

