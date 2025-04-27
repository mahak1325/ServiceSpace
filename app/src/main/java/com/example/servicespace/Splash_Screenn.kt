package com.example.servicespace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("DEPRECATION")
class Splash_Screenn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screenn)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(  this,StartActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}