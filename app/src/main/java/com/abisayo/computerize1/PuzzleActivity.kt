package com.abisayo.computerize1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.customview.widget.ViewDragHelper
import com.abisayo.computerize1.databinding.ActivityAdmissionFlashcardBinding
import com.abisayo.computerize1.databinding.ActivityPuzzleBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar



class PuzzleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPuzzleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPuzzleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.parentCoordinatorLayout.addDraggableChild(binding.draggableCard1)
        binding.parentCoordinatorLayout.addDraggableChild(binding.draggableCard2)
        binding.parentCoordinatorLayout.addDraggableChild(binding.draggableCard3)
        binding.parentCoordinatorLayout.addDraggableChild(binding.draggableCard4)

        binding.parentCoordinatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, i: Int) {

                when (view.id) {
                    R.id.draggableCard1 -> binding.draggableCard1.isDragged = true
                    R.id.draggableCard2 -> binding.draggableCard2.isDragged = true
                    R.id.draggableCard3 -> binding.draggableCard3.isDragged = true
                    R.id.draggableCard4 -> binding.draggableCard4.isDragged = true
                }
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {

                when (view.id) {
                    R.id.draggableCard1 -> binding.draggableCard1.isDragged = false
                    R.id.draggableCard2 -> binding.draggableCard2.isDragged = false
                    R.id.draggableCard3 -> binding.draggableCard3.isDragged = false
                    R.id.draggableCard4 -> binding.draggableCard4.isDragged = false
                }
            }
        })
    }
}

