package com.dicoding.anilist

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val profileImage: ImageView = findViewById(R.id.profile_image)
        val profileName = findViewById<TextView>(R.id.profile_name)
        val profileEmail = findViewById<TextView>(R.id.profile_email)

        profileName.text = "Fitri Sagita"
        profileEmail.text = "fitristarius@gmail.com"

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.gita)
        val roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
            resources, bitmap
        )
        roundedBitmapDrawable.isCircular = true
        profileImage.setImageDrawable(roundedBitmapDrawable)
    }
}