package com.abisayo.computerize1.Flowcharts

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
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.data.Constants.EXTRA_FLASH_CARD
import com.abisayo.computerize1.databinding.ActivityTrendsFlashcardBinding
import com.abisayo.computerize1.flashcard.FlashCard
import com.abisayo.computerize1.flashcard.FlashCardAdapter
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.startAlgorithmFlashcardActivity
import com.abisayo.computerize1.data.startFlowChartActivity
import com.google.android.material.navigation.NavigationView

class FlowchartsFlashcardActivity : AppCompatActivity() {

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

        binding.readMore.setOnClickListener {
            intent = Intent(this, ReadMoreActivity::class.java)
            startActivity(intent)
        }

        val item = intent.getIntExtra("item", 999)
        if (item == 0) {
            supportActionBar?.setTitle("Introduction to Flowchart")
            binding.textView10.text = getString(R.string.definition)
        } else if (item == 1) {
            supportActionBar?.setTitle("Flowchart Guidelines")
            binding.textView10.text = getString(R.string.rules_flow)
        } else if (item == 2) {
            supportActionBar?.setTitle("Flowchart Advantages")
            binding.textView10.text = getString(R.string.advantages_flow)
        } else if (item == 3) {
            supportActionBar?.setTitle("Flowchart Disadvantages")
            binding.textView10.text = getString(R.string.disadvantages_flow)
        }

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
                    this.startFlowChartActivity(Flashcards.trendIntroFlashcard(), 0)
                    supportActionBar?.setTitle("Introduction to Flowcharts")
                }

                R.id.flow_elements -> {
                    startActivity(Intent(this,
                        FlowchartElementsActivity::class.java))

                }
                R.id.guidelines -> {
                    this.startFlowChartActivity(Flashcards.trendSpecializationFlashcard(), 1)
                    supportActionBar?.setTitle("Flowchart Guidelines")
                }
                R.id.advantages -> {
                    this.startFlowChartActivity(Flashcards.trendOutpatientFlashcard(), 2)
                    supportActionBar?.setTitle("Advantages of Flowcharts")
                }
                R.id.disadvantages -> {
                    this.startFlowChartActivity(Flashcards.trendNavigatorFlashcard(), 3)
                    supportActionBar?.setTitle("Disadvantages of Flowchart")
                }
                R.id.examples -> {
                    startActivity(Intent(this,
                        FlowchartExampleActivity::class.java))
                }

                R.id.read_more -> {
                    val intent = Intent(this, WebViewActivity::class.java)
                    intent.putExtra(Constants.TOPIC, "Flowcharts")
                    startActivity(intent)
                    finish()
                }

                R.id.quiz -> {
                    val intent = Intent(this, EnterNameQuizActivity::class.java)
                    intent.putExtra(Constants.TOPIC, "Flowcharts")
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