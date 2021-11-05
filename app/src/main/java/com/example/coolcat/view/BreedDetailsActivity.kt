package com.example.coolcat.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coolcat.constants.Constants
import com.example.coolcat.databinding.ActivityBreedDetailsBinding
import com.example.coolcat.extensions.loadUrl
import com.example.coolcat.repo.remote.CatInfo

class BreedDetailsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityBreedDetailsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val catInfo = intent.getSerializableExtra(Constants.BREED_ID) as CatInfo
        binding.tvCatName.text = catInfo.name
        binding.tvCatDescription.text = catInfo.description
        binding.ivImage.loadUrl(catInfo.image?.url ?: "https://www.clipartkey.com/mpngs/m/152-1520367_user-profile-default-image-png-clipart-png-download.png")
    }
}