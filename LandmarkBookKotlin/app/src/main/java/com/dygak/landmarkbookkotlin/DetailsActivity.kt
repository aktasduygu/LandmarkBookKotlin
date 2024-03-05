package com.dygak.landmarkbookkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dygak.landmarkbookkotlin.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //listelere tıkladığımızda bizi tıkladığımız yerin özelliklerine götürmesi için aşağıdaki kodu yazdık
        val intent = intent
        //casting: (as kullanımı) benim sana gönderdiğim şeyin landmark olduğuna eminim onu al kaydet demek
        val selectedLandmark = intent.getSerializableExtra("landmark") as Landmark

        binding.nameText.text = selectedLandmark.name
        binding.countryText.text = selectedLandmark.country
        binding.imageView.setImageResource(selectedLandmark.image)

    }
}