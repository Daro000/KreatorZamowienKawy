package com.example.kreatorzamowienkawy

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.rkawy)
        val imageView = findViewById<ImageView>(R.id.my_image_view)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val imageRes = when (checkedId) {
                R.id.kawa1 -> R.drawable.espresso
                R.id.kawa2 -> R.drawable.capuccino
                R.id.kawa3 -> R.drawable.latte
                else -> R.drawable.capuccino
            }
            imageView.setImageResource(imageRes)
        }

        val myTextView = findViewById<TextView>(R.id.ilosc)

        val mySeekBar: SeekBar = findViewById(R.id.seekbar)
        mySeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                myTextView.text = "$p1"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}