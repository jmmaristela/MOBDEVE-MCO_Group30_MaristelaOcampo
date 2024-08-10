package com.mobdeve.s12.maristela.joseph_miguel.mobdeve.maristelaocampo.mco.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.R
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.Workout
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class WorkoutAdapter(
    private val context: Context,
    private val workouts: List<Workout>
) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_workout, parent, false)
        return WorkoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val workout = workouts[position]
        holder.title.text = workout.title

        // Setting up YouTube Player
        holder.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                // Loading the video
                youTubePlayer.cueVideo(workout.videoUrl, 0f)
            }
        })
    }

    override fun getItemCount(): Int {
        return workouts.size
    }

    class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_workout_title)
        val youtubePlayerView: YouTubePlayerView = itemView.findViewById(R.id.youtube_player_view)
    }
}
