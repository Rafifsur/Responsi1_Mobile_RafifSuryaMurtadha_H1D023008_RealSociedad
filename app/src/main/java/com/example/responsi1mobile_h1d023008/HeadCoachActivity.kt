package com.example.responsi1mobile_h1d023008

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobile_h1d023008.databinding.ActivityHeadCoachBinding
import com.example.responsi1mobile_h1d023008.viewmodel.TeamViewModel

class HeadCoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeadCoachBinding
    private val viewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeadCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchCoach()
        // show loading and errors
        viewModel.loading.observe(this) { isLoading ->
            // optional: show a progress indicator
        }

        viewModel.error.observe(this) { err ->
            err?.let { android.widget.Toast.makeText(this, "Coach API error: $it", android.widget.Toast.LENGTH_LONG).show() }
        }

        viewModel.coach.observe(this) { coach ->
            if (coach != null) {
                binding.textCoachName.text = coach.name
                binding.textCoachBornDate.text = coach.dateOfBirth ?: "-"
                binding.textCoachNationality.text = coach.nationality ?: "-"
            } else {
                // show placeholder
                binding.textCoachName.text = "-"
                binding.textCoachBornDate.text = "-"
                binding.textCoachNationality.text = "-"
            }
        }
    }
}
