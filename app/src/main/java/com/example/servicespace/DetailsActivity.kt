package com.example.servicespace

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.servicespace.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName=intent.getStringExtra("MenuItemName")
        val foodImage=intent.getIntExtra("MenuItemImage",0)
        binding.detailServiceName.text=foodName
        binding.DetailFoodImage.setImageResource(foodImage)

        binding.ImageButton.setOnClickListener{
            finish()
        }
    }
}