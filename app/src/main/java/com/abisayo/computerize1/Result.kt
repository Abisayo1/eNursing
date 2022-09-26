package com.abisayo.computerize1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import com.abisayo.computerize1.databinding.ActivityResultBinding
import com.abisayo.computerize1.databinding.ActivityTopics1Binding

class Result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    var handler: Handler? = null
    private lateinit var progressText : TextView
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Handler.Callback {
            if (i==0) {
                i++
            }
            binding.progressBar.progress = i
            binding.progressText.text = "${i}/${binding.progressBar.max}"
            handler?.sendEmptyMessageDelayed(0, 100)

            true
        })

        handler?.sendEmptyMessage(0)
}
}