package com.example.coolcat.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coolcat.adapter.CoolCatAdapter
import com.example.coolcat.constants.Constants
import com.example.coolcat.databinding.ActivityBreedDetailsBinding
import com.example.coolcat.extensions.loadUrl
import com.example.coolcat.repo.remote.CatInfo
import android.content.Intent

import android.net.Uri




class BreedDetailsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityBreedDetailsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }
    private fun initViews() = with(binding) {
        val catInfo = intent.getSerializableExtra(Constants.BREED_INFO) as CatInfo
        ivImage.loadUrl(catInfo.image?.url ?: Constants.DEFAULT_IMG)
        tvCatName.text = catInfo.name
        tvCatDescription.text = catInfo.description
        tvCatTemperament.text = catInfo.temperament
        rbAffection.rating = catInfo.adaptability.toFloat()
        rbAdaptability.rating = catInfo.adaptability.toFloat()
        rbChildFriendly.rating = catInfo.childFriendly.toFloat()
        rbDogFriendly.rating = catInfo.dogFriendly.toFloat()
        rbEnergy.rating = catInfo.energyLevel.toFloat()
        rbGrooming.rating = catInfo.grooming.toFloat()
        rbHealth.rating = catInfo.healthIssues.toFloat()
        rbIntelligence.rating = catInfo.intelligence.toFloat()
        rbShedding.rating = catInfo.sheddingLevel.toFloat()
        rbSocialNeeds.rating = catInfo.socialNeeds.toFloat()
        rbStrangerFriendly.rating = catInfo.strangerFriendly.toFloat()
        rbVocalization.rating = catInfo.vocalisation.toFloat()
        btnWikiLink.text = "Wikipedia"
        btnWikiLink.setOnClickListener {
            val uri = Uri.parse(catInfo.wikipediaUrl)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}