package com.abisayo.computerize1

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.customview.widget.ViewDragHelper
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.data.Question
import com.abisayo.computerize1.databinding.ActivityAdmissionFlashcardBinding
import com.abisayo.computerize1.databinding.ActivityMainBinding
import com.abisayo.computerize1.databinding.ActivityPuzzleBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar



class PuzzleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPuzzleBinding
    private lateinit var builder: AlertDialog.Builder
    private var i = 0
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
//        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityPuzzleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var j = intent.getIntExtra("i", 0)
        Toast.makeText(this, "$j", Toast.LENGTH_SHORT).show()

        binding.dragView.setOnClickListener {
            j++
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, PuzzleActivity::class.java)
            intent.putExtra("i", j)
            startActivity(intent)
            finish()
        }


        binding.llTop.setOnDragListener(dragListener)
        binding.llBottom.setOnDragListener(dragListener)
        binding.llRight.setOnDragListener(dragListener)
        binding.tt.setOnDragListener(dragListeners)
        binding.llBottomRight.setOnDragListener(dragListener)
        binding.llBottom.setOnDragListener(dragListener)


        binding.dragView.setOnLongClickListener {
            val clipText = "This is our ClipData text"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true

        }


    }


    override fun onBackPressed() {
        builder.setTitle("Alert!")
            .setMessage("Do you want to leave puzzle?")
            .setCancelable(true)
            .setPositiveButton("Yes") { dialogInterface, it ->
                finish()
            }
            .setNegativeButton("No") { dialogInterface, it ->
                dialogInterface.cancel()
            }

            .show()
    }


    val dragListener = View.OnDragListener { view, event ->
        binding.dragView.visibility = View.INVISIBLE
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                binding.txtBottom.visibility = View.VISIBLE
                binding.txtTop.visibility = View.VISIBLE
                binding.txtBottomRight.visibility = View.VISIBLE
                binding.txtRight.visibility = View.VISIBLE
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)

            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                if (view == binding.llBottom) {
                    binding.txtBottom.visibility = View.GONE
                } else if (view == binding.llTop) {
                    binding.txtTop.visibility = View.GONE
                } else if (view == binding.llRight) {
                    binding.txtRight.visibility = View.GONE
                } else if (view == binding.llBottomRight) {
                    binding.txtBottomRight.visibility = View.GONE
                }

                view.invalidate()

                val v = event.localState as View
                val owner = v.parent as ViewGroup
                owner.removeView(v)
                val destination = view as LinearLayout
                destination.addView(v)
                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }
            else -> false

        }

    }


    val dragListeners = View.OnDragListener { view, event ->
        binding.dragView.visibility = View.VISIBLE
        when (event.action) {

            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {

                false
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {

                false
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                false

            }

            else -> false

        }


    }





}



    


