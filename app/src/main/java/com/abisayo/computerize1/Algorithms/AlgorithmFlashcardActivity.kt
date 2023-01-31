package com.abisayo.computerize1.Algorithms

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
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.data.Constants.EXTRA_FLASH_CARD
import com.abisayo.computerize1.databinding.ActivityHistoryFlashcardBinding
import com.abisayo.computerize1.flashcard.FlashCard
import com.abisayo.computerize1.flashcard.FlashCardAdapter
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.startAlgorithmFlashcardActivity
import com.google.android.material.navigation.NavigationView

class AlgorithmFlashcardActivity : AppCompatActivity() {

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

        val item = intent.getIntExtra("item", 999)
        if (item == 0) {
            supportActionBar?.setTitle("Introduction to Flowchart")
            binding.textView10.text = getString(R.string.algo_def)
        } else if (item == 1) {
            supportActionBar?.setTitle("Types of Algorithms")
            binding.textView10.text = getString(R.string.types_algo)
        } else if (item == 2) {
            supportActionBar?.setTitle("Algorithm Characteristics")
            binding.textView10.text = getString(R.string.characteristic_algo)
        } else if (item == 3) {
            supportActionBar?.setTitle("Importances of Algorithms")
            binding.textView10.text = getString(R.string.characteristic_algo)
        } else if (item ==4) {
            supportActionBar?.setTitle("Steps in Writing Algorithms")
            binding.textView10.text = getString(R.string.algo_how_write)
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

                R.id.Introduction -> {
                    this.startAlgorithmFlashcardActivity(Flashcards.womenRoleFlashcard1(), 0)
                    supportActionBar?.setTitle("Introduction to Flowchart")
                }
                R.id.algo_types -> {
                    this.startAlgorithmFlashcardActivity(Flashcards.religionFlashcard(), 1)
                    supportActionBar?.setTitle("Types of Algorithms")
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
                    startActivity(Intent(this,
                        AlgorithmExampleActivity::class.java))
                }

                R.id.quiz -> {
                    val intent = Intent(this, EnterNameQuizActivity::class.java)
                    intent.putExtra(Constants.TOPIC, "Algorithms")
                    startActivity(intent)
                    finish()
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