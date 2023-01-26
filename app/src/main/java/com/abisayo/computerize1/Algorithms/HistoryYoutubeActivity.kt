package com.abisayo.computerize1.Algorithms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.abisayo.computerize1.*
import com.abisayo.computerize1.databinding.ActivityHistoryYoutubeBinding
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.YoutubeVideo
import com.abisayo.computerize1.data.startAlgorithmFlashcardActivity
import com.google.android.material.navigation.NavigationView
import java.util.*

class HistoryYoutubeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryYoutubeBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private val youtubeVideo = Vector<YoutubeVideo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryYoutubeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        youtubeVideo.add(YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/fa6x-7viOu0\" frameborder=\"0\" allowfullscreen></iframe>"))
        youtubeVideo.add(YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/Ll2gjuga1yY\" frameborder=\"0\" allowfullscreen></iframe>"))
        youtubeVideo.add(YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/nWvhq-2Gfm8\" frameborder=\"0\" allowfullscreen>lt;/iframe>"))
        youtubeVideo.add(YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/ZfO6ygB6uzk\" frameborder=\"0\" allowfullscreen></iframe>"))
        val videoAdapter = VideoAdapter(youtubeVideo)
        binding.recycler.adapter = videoAdapter

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.nav_home -> {
                    intent = Intent(this, TopicsActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.profile -> {
                    intent = Intent(this, Profile::class.java)
                    startActivity(intent)
                }

                R.id.Introduction -> {
                    this.startAlgorithmFlashcardActivity(Flashcards.womenRoleFlashcard1(), 0)
                }
                R.id.algo_types -> {
                    this.startAlgorithmFlashcardActivity(Flashcards.religionFlashcard(), 1)
                }
                R.id.algo_characteristics -> {
                    this.startAlgorithmFlashcardActivity(Flashcards.warFlashcard(), 2)
                }
                R.id.algo_importance -> {
                    this.startAlgorithmFlashcardActivity(Flashcards.societalAttitudeFlashcard(), 3)
                }
                R.id.algo_steps -> {
                    this.startAlgorithmFlashcardActivity(Flashcards.florenceFlashcard(), 4)
                }
                R.id.algo_examples -> {
                    this.startAlgorithmFlashcardActivity(Flashcards.claraFlashcard(), 5)
                }

                R.id.videos -> {
                    startActivity(Intent(this,
                        HistoryYoutubeActivity::class.java))
                }

            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        if (item.itemId == R.id.action_item_one) {
            val intent = Intent(this, TopicsActivity::class.java)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)


    }
}