package com.abisayo.computerize1.Flowcharts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.abisayo.computerize1.Profile
import com.abisayo.computerize1.R
import com.abisayo.computerize1.TopicsActivity
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.startAlgorithmFlashcardActivity
import com.abisayo.computerize1.data.startTrendsFlashcardActivity
import com.abisayo.computerize1.databinding.ActivityFlowchartElementsBinding
import com.google.android.material.navigation.NavigationView

class FlowchartElementsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlowchartElementsBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowchartElementsBinding.inflate(layoutInflater)
        setContentView(binding.root)



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
                    this.startTrendsFlashcardActivity(Flashcards.trendIntroFlashcard())
                }

                R.id.flow_elements -> {
                    startActivity(
                        Intent(this,
                        FlowchartElementsActivity::class.java)
                    )
                }
                R.id.guidelines -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendSpecializationFlashcard())
                }
                R.id.advantages -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendOutpatientFlashcard())
                }
                R.id.disadvantages -> {
                    this.startTrendsFlashcardActivity(Flashcards.trendNavigatorFlashcard())
                }
                R.id.examples -> {
                    startActivity(
                        Intent(this,
                        FlowchartExampleActivity::class.java)
                    )
                }

                R.id.quiz -> {
                    startActivity(
                        Intent(this,
                            FlowChartQuizActivity::class.java)
                    )
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