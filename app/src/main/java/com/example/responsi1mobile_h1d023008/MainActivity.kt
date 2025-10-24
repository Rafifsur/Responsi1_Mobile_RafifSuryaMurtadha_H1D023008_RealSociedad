package com.example.responsi1mobile_h1d023008

import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // apply window insets padding to root
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // wire up the three included menu rows: club history, head coach, team squad
        setupMenuRow(R.id.layout_club_history,
            "Club History",
            R.drawable.ic_logo_history,
            "Founded in 1909, Real Sociedad started as a small local club in San Sebastián. Over the decades it grew into a top-flight Spanish team. The club enjoyed two LaLiga titles in the early 1980s and has built a reputation for promoting youth players from its academy.")

        setupMenuRow(R.id.layout_head_coach,
            "Head Coach",
            R.drawable.ic_logo_headcoach,
            "Imanol Alguacil (head coach): A manager known for tactical flexibility and for promoting academy players into the first team. He emphasizes possession-based football and a compact defensive shape.")

        setupMenuRow(R.id.layout_team_squad,
            "Team Squad",
            R.drawable.ic_logo_team,
            "Squad highlights: a balanced squad with homegrown talents and experienced players across all positions. Typical lineup includes goalkeeper, fullbacks, center-backs, midfield creators, wingers, and strikers.\n\nFor a full roster, integrate a team API or add a dedicated squad screen.")
    }

    private fun setupMenuRow(includeId: Int, title: String, iconRes: Int, detailText: String) {
        val root: View? = findViewById(includeId)
        root?.let { r ->
            val titleView = r.findViewById<TextView>(R.id.menu_title)
            val iconView = r.findViewById<ImageView>(R.id.menu_icon)
            titleView?.text = title
            iconView?.setImageResource(iconRes)
            r.setOnClickListener {
                when (includeId) {
                    R.id.layout_club_history -> {
                        // static local page
                        val intent = Intent(this, ClubHistoryActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.layout_head_coach -> {
                        val intent = Intent(this, HeadCoachActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.layout_team_squad -> {
                        val intent = Intent(this, TeamSquadActivity::class.java)
                        startActivity(intent)
                    }
                    else -> {
                        // fallback: show dialog
                        showDetailDialog(title, detailText)
                    }
                }
            }
        }
    }

    private fun showDetailDialog(title: String, content: String) {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(content)
            .setPositiveButton("OK", null)
            .show()
    }
}