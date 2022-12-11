package com.abisayo.computerize1.trendsInNursing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.*
import com.abisayo.computerize1.data.Constants.EXTRA_FLASH_CARD
import com.abisayo.computerize1.databinding.ActivityTrendsFlashcardBinding
import com.abisayo.computerize1.flashcard.FlashCard
import com.abisayo.computerize1.flashcard.FlashCardAdapter
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.startHistoryFlashcardActivity
import com.abisayo.computerize1.data.startTrendsFlashcardActivity
import com.google.android.material.navigation.NavigationView

class TrendsFlashcardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrendsFlashcardBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var flashCardAdapter: FlashCardAdapter
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrendsFlashcardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recycler

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val flashCardList = intent.getSerializableExtra(EXTRA_FLASH_CARD) as? ArrayList<FlashCard>
        if (flashCardList.isNullOrEmpty()) {
            Toast.makeText(this, "No flashcard on this topic", Toast.LENGTH_SHORT).show()
            finish()
        }

        flashCardAdapter = FlashCardAdapter(flashCardList!!)
        recyclerView.adapter = flashCardAdapter

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
                    this.startHistoryFlashcardActivity(Flashcards.trendIntroFlashcard())
                }

                R.id.telehealth -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendTeleHealthFlashcard())
                }
                R.id.specialization -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendSpecializationFlashcard())
                }
                R.id.outpatient -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendOutpatientFlashcard())
                }
                R.id.navigator -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendNavigatorFlashcard())
                }
                R.id.ent -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendENTFlashcard())
                }
                R.id.doctoral -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendDoctoralFlashcard())
                }
                R.id.eduOnline -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendEduOnlineFlashcard())
                }
                R.id.shortage -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendShortageFlashcard())
                }
                R.id.advocacy -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendAdvocacyFlashcard())
                }
                R.id.selfCare -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendSelfCareFlashcard())
                }
                R.id.salaries -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendSalariesFlashcard())
                }
                R.id.bilingual -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendBiLingualFlashcard())
                }
                R.id.males -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendMalesFlashcard())
                }
                R.id.holistic -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendHolisticFlashcard())
                }
                R.id.patients -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendPatientsFlashcard())
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