package com.example.responsi1mobile_h1d023008

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobile_h1d023008.databinding.ActivityTeamSquadBinding
import com.example.responsi1mobile_h1d023008.ui.adapter.PlayerAdapter
import com.example.responsi1mobile_h1d023008.ui.fragment.DetailPemainFragment
import com.example.responsi1mobile_h1d023008.viewmodel.TeamViewModel

class TeamSquadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamSquadBinding
    private val viewModel: TeamViewModel by viewModels()
    private lateinit var adapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamSquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PlayerAdapter(emptyList()) { player ->
            val fragment = DetailPemainFragment(player)
            fragment.show(supportFragmentManager, "PlayerDetail")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.players.observe(this) { players ->
            adapter.setData(players)
        }

        viewModel.error.observe(this) { err ->
            err?.let { android.widget.Toast.makeText(this, "Team API error: $it", android.widget.Toast.LENGTH_LONG).show() }
        }

        viewModel.loading.observe(this) { isLoading ->
            // optional: show/hide loading indicator
        }

        viewModel.fetchTeam()
    }
}
