package com.abisayo.computerize1.historyOfNursing

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.*
import com.abisayo.computerize1.Constants.EXTRA_FLASH_CARD
import com.abisayo.computerize1.databinding.ActivityHistoryFlashcardBinding
import com.abisayo.computerize1.flashcard.FlashCard
import com.abisayo.computerize1.flashcard.FlashCardAdapter
import com.abisayo.computerize1.flashcard.Flashcards
import com.google.android.material.navigation.NavigationView

class HistoryFlashcardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryFlashcardBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var flashCardAdapter: FlashCardAdapter
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryFlashcardBinding.inflate(layoutInflater)
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

                R.id.women_role -> {
                    this.startHistoryFlashcardActivity(Flashcards.womenRoleFlashcard1())
                }
                R.id.religion -> {
                    this.startHistoryFlashcardActivity(Flashcards.religionFlashcard())
                }
                R.id.war -> {
                    this.startHistoryFlashcardActivity(Flashcards.warFlashcard())
                }
                R.id.societal_att -> {
                    this.startHistoryFlashcardActivity(Flashcards.societalAttitudeFlashcard())
                }
                R.id.florence -> {
                    this.startHistoryFlashcardActivity(Flashcards.florenceFlashcard())
                }
                R.id.clara -> {
                    this.startHistoryFlashcardActivity(Flashcards.claraFlashcard())
                }
                R.id.linda -> {
                    this.startHistoryFlashcardActivity(Flashcards.lindaFlashcard())
                }
                R.id.mary -> {
                    this.startHistoryFlashcardActivity(Flashcards.maryFlashcard())
                }
                R.id.lilian -> {
                    this.startHistoryFlashcardActivity(Flashcards.lilianFlashcard())
                }
                R.id.lavinia -> {
                    this.startHistoryFlashcardActivity(Flashcards.laviniaFlashcard())
                }
                R.id.margaret -> {
                    this.startHistoryFlashcardActivity(Flashcards.margaretFlashcard())
                }
                R.id.mary2 -> {
                    this.startHistoryFlashcardActivity(Flashcards.mary2Flashcard())
                }
                R.id.men -> {
                    this.startHistoryFlashcardActivity(Flashcards.menFlashcard())
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