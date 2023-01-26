package com.abisayo.computerize1.assessment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.Profile
import com.abisayo.computerize1.R
import com.abisayo.computerize1.TopicsActivity
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.startAssessmentFlashcardActivity
import com.abisayo.computerize1.databinding.ActivityAssessmentFlashCardBinding
import com.abisayo.computerize1.flashcard.FlashCard
import com.abisayo.computerize1.flashcard.FlashCardAdapter
import com.google.android.material.navigation.NavigationView

class AssessmentFlashCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAssessmentFlashCardBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var flashCardAdapter: FlashCardAdapter
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssessmentFlashCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recycler

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val flashCardList = intent.getSerializableExtra(Constants.EXTRA_FLASH_CARD) as? ArrayList<FlashCard>
        if (flashCardList.isNullOrEmpty()){
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
                R.id.nav_home ->  {intent = Intent(this, TopicsActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.profile ->  {intent = Intent(this, Profile::class.java)
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