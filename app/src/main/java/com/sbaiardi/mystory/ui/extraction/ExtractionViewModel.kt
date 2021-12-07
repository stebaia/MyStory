package com.sbaiardi.mystory.ui.extraction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sbaiardi.mystory.network.NameService

class ExtractionViewModel  : ViewModel() {

    private val _name = MutableLiveData<String>().apply {
        value = NameService.randomChoose().name
    }
    val name: LiveData<String> = _name
}