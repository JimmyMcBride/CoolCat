package com.example.coolcat.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coolcat.adapter.CoolCatAdapter
import com.example.coolcat.databinding.ActivityAllBreedsBinding
import com.example.coolcat.repo.remote.CatImage
import com.example.coolcat.repo.remote.CatInfo
import com.example.coolcat.viewmodel.CoolCatViewModel

/**
CatBrowser [https://docs.thecatapi.com/example-by-breed]

BreedActivity [Part 1]

- User can browse through all breeds

- Each breed item will have image and name

- When user selects a breed they will be navigated to BreedDetailActivity



BreedDetailActivity [Part 2] *ONLY START WHEN PART 1 IS DONE*

- Show all details of Breed selected

- For UI mimic what they did here https://thecatapi.com/example-pages/breed-selection.html *Ignore the drop down at the top with list of breed*
 */

class AllBreedsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAllBreedsBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<CoolCatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        viewModel.coolCats.observe(this) {
            // Here is where your will get the result
            Log.d("MainActivity", "onCreate: $it")
            (binding.rvImages.adapter as CoolCatAdapter).updateCatInfo(it)
        }
    }

    private fun initViews() = with(binding) {
        viewModel.getInfo()
        rvImages.adapter = CoolCatAdapter()
    }
}