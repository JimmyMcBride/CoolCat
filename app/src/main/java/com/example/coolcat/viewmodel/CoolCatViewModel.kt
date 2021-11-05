package com.example.coolcat.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coolcat.repo.CoolCatRepo
import com.example.coolcat.repo.remote.CatInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoolCatViewModel : ViewModel() {
    private val _coolCats = MutableLiveData<List<CatInfo>>()
    val coolCats: LiveData<List<CatInfo>> get() = _coolCats

    fun getInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = CoolCatRepo.getCatBreedsInfo()

            val list = response.body() ?: null

            list?.let { info -> _coolCats.postValue(info) }
        }
    }
}