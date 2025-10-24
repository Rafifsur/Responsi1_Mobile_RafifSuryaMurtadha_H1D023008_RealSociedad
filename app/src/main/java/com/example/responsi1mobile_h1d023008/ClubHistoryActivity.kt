package com.example.responsi1mobile_h1d023008

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobile_h1d023008.databinding.ActivityClubHistoryBinding

class ClubHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClubHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Simple static content; you can replace it or fetch from network later
        binding.imageClub.setImageResource(com.example.responsi1mobile_h1d023008.R.drawable.rea_sociedad_history)
        val html = getString(com.example.responsi1mobile_h1d023008.R.string.club_history_real_sociedad)
        binding.textHistory.text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    }
}
