package com.example.myprofile

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id=intent.getStringExtra("signinId")
        val idText=findViewById<TextView>(R.id.homeTxtId)
        idText.text = "id: ${id}"
        val img=findViewById<ImageView>(R.id.homeImg)
        val imgarr= arrayOf(R.drawable.year10, R.drawable.year11, R.drawable.year4, R.drawable.year5, R.drawable.year6)
        img.setImageResource(imgarr.random())

        val btnExit=findViewById<Button>(R.id.homeBtnExit)
        btnExit.setOnClickListener {
            finish()
        }
    }
}