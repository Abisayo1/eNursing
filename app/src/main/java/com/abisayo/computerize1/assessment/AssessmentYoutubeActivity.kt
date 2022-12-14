package com.abisayo.computerize1.assessment

import android.content.Intent
import android.net.Uri
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
import com.abisayo.computerize1.data.startAssessmentFlashcardActivity
import com.abisayo.computerize1.data.startHistoryFlashcardActivity
import com.abisayo.computerize1.databinding.ActivityAssessmentYoutubeBinding
import com.google.android.material.navigation.NavigationView
import java.util.*

class AssessmentYoutubeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAssessmentYoutubeBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private val youtubeVideo = Vector<YoutubeVideo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssessmentYoutubeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        youtubeVideo.add(YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/gG8kh8MfnGY\" frameborder=\"0\" allowfullscreen></iframe>"))
        youtubeVideo.add(YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/oCMHMmjwLpg\" frameborder=\"0\" allowfullscreen></iframe>"))
        youtubeVideo.add(YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/ZyLCrf44i48\" frameborder=\"0\" allowfullscreen>lt;/iframe>"))
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

                R.id.introduction -> {
                    this.startAssessmentFlashcardActivity(Flashcards.assessmentIntroFlashcard())
                }
                R.id.indications -> {
                    this.startAssessmentFlashcardActivity(Flashcards.assessmentIndicationsFlashcard())
                }
                R.id.types_levels -> {
                    this.startAssessmentFlashcardActivity(Flashcards.assessmentTypesOrLevelsFlashcard())
                }
                R.id.typesData -> {
                    this.startAssessmentFlashcardActivity(Flashcards.assessmentDataTypesFlashcard())
                }
                R.id.resources -> {
                    startActivity(Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://lms.rn.com/getpdf.php/2051.pdf")));
                }
                R.id.videos -> {
                    startActivity(Intent(this,
                        AssessmentYoutubeActivity::class.java))
                }


            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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