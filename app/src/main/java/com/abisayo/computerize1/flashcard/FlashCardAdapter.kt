package com.abisayo.computerize1.flashcard

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.R
import com.abisayo.computerize1.R.*
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class FlashCardAdapter(private val flashCardList: ArrayList<FlashCard>) :
    RecyclerView.Adapter<FlashCardAdapter.FlashCardViewHolder>() {

    class FlashCardViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

//        val layoutFlashCard: MaterialCardView = itemView.findViewById(id.layoutFlashCard)
//        val tvOverlay: MaterialTextView = itemView.findViewById(id.overlay)
//        val tvDetail: MaterialTextView = itemView.findViewById(id.details)

        val layoutFlashCard: MaterialCardView = itemView.findViewById(id.layoutFlashCard)
        val tvQuestion: MaterialTextView = itemView.findViewById(id.tvQuestion)
        val tvAnswer: MaterialTextView = itemView.findViewById(id.tvAnswer)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashCardViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(layout.flash_card_item_view, parent, false)
        return FlashCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlashCardViewHolder, position: Int) {
        val card = flashCardList[position]
        val layoutFlashCard = holder.layoutFlashCard
        val tvQuestion = holder.tvQuestion
        val tvAnswer = holder.tvAnswer
//        val overlay = holder.tvOverlay
//        val details = holder.tvDetail
        tvQuestion.text = card.question
        tvAnswer.text = card.answer
//        overlay.text = card.question
//        details.text = card.answer
        val scale = layoutFlashCard.context.applicationContext.resources.displayMetrics.density
        tvQuestion.cameraDistance = 8000 * scale
        tvAnswer.cameraDistance = 8000 * scale
        val frontAnim = AnimatorInflater.loadAnimator(
            layoutFlashCard.context.applicationContext,
            R.animator.front_animator
        ) as AnimatorSet
        val backAnim = AnimatorInflater.loadAnimator(
            layoutFlashCard.context.applicationContext,
            R.animator.back_animator
        ) as AnimatorSet
        var answerVisible = false

        layoutFlashCard.setOnClickListener {
            if (answerVisible){
                frontAnim.setTarget(tvAnswer)
                backAnim.setTarget(tvQuestion)
                backAnim.start()
                frontAnim.start()
            } else{
                frontAnim.setTarget(tvQuestion)
                backAnim.setTarget(tvAnswer)
                frontAnim.start()
                backAnim.start()
            }
            answerVisible = !answerVisible
        }

        /*
        layoutFlashCard.apply {
            setOnTouchListener { v, event ->
                if (answerVisible) {
                    details.isVisible = false
                    overlay.isVisible = true
                    layoutFlashCard.setBackgroundColor(ContextCompat.getColor(holder.layoutFlashCard.context,
                        R.color.orange))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ViewAnimationUtils.createCircularReveal(
                            layoutFlashCard,
                            event.x.toInt(),
                            event.y.toInt(),
                            100f,
                            hypot(v.width.toFloat(), v.height.toFloat())
                        )
                            .setDuration(1000)
                            .start()
                    }
                } else {
                    details.isVisible = true
                    overlay.isVisible = false
                    layoutFlashCard.setBackgroundColor(ContextCompat.getColor(holder.layoutFlashCard.context,
                        R.color.grey))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ViewAnimationUtils.createCircularReveal(
                            layoutFlashCard,
                            event.x.toInt(),
                            event.y.toInt(),
                            0f,
                            hypot(v.width.toFloat(), v.height.toFloat())
                        )
                            .setDuration(1000)
                            .start()
                    }
                }

                answerVisible = !answerVisible
                performClick()
                false
            }
        }

         */

    }

    override fun getItemCount(): Int {
        return flashCardList.size
    }
}