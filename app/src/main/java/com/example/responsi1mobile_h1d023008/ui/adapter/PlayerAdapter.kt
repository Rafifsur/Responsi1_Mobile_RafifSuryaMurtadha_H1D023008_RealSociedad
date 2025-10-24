package com.example.responsi1mobile_h1d023008.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobile_h1d023008.R
import com.example.responsi1mobile_h1d023008.data.model.Player
import com.example.responsi1mobile_h1d023008.databinding.ListPemainBinding

class PlayerAdapter(
    private var players: List<Player>,
    private val onPlayerClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ListPemainBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ListPemainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        val context = holder.binding.root.context

        holder.binding.tvPlayerName.text = player.name
        holder.binding.tvPlayerNationality.text = player.nationality ?: "-"

        val positionText = player.position?.lowercase() ?: ""

        val backgroundColor = when {
            positionText.contains("goalkeeper") -> ContextCompat.getColor(context, R.color.yellow)
            positionText.contains("defence") ||
                    positionText.contains("defender") ||
                    positionText.contains("back") -> ContextCompat.getColor(context, R.color.blue_dark)
            positionText.contains("midfield") -> ContextCompat.getColor(context, R.color.green)
            positionText.contains("forward") ||
                    positionText.contains("offence") ||
                    positionText.contains("wing") -> ContextCompat.getColor(context, R.color.red)
            else -> ContextCompat.getColor(context, android.R.color.darker_gray)
        }

        holder.binding.root.setCardBackgroundColor(backgroundColor)

        holder.binding.root.setOnClickListener { onPlayerClick(player) }
    }

    override fun getItemCount(): Int = players.size

    fun setData(newPlayers: List<Player>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}
