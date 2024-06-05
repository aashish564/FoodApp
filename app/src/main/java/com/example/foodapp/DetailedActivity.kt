package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodapp.databinding.ActivityDetailedBinding
import com.example.foodapp.databinding.NotificationItemBinding

class DetailedActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage",0)
        binding.detailFoodName.text = foodName
        binding.detailFoodImage.setImageResource(foodImage)

        binding.imageButton.setOnClickListener {
            finish()
        }
    }
}