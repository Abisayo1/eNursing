package com.abisayo.computerize1.Flowcharts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.abisayo.computerize1.*
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.startFlowChartActivity
import com.abisayo.computerize1.databinding.ActivityFlowchartExampleBinding
import com.google.android.material.navigation.NavigationView

class FlowchartExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlowchartExampleBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowchartExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Examples of FlowChart")


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
                    this.startFlowChartActivity(Flashcards.trendIntroFlashcard(), 0)
                }

                R.id.flow_elements -> {
                    startActivity(
                        Intent(this,
                            FlowchartElementsActivity::class.java)
                    )
                }
                R.id.guidelines -> {
                    this.startFlowChartActivity(Flashcards.trendSpecializationFlashcard(), 1)
                }
                R.id.advantages -> {
                    this.startFlowChartActivity(Flashcards.trendOutpatientFlashcard(), 2)
                }
                R.id.disadvantages -> {
                    this.startFlowChartActivity(Flashcards.trendNavigatorFlashcard(), 3)
                }
                R.id.examples -> {
                    startActivity(
                        Intent(this,
                            FlowchartExampleActivity::class.java)
                    )
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