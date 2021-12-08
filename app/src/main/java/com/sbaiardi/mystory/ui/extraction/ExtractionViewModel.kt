package com.sbaiardi.mystory.ui.extraction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sbaiardi.mystory.data.Character
import com.sbaiardi.mystory.data.Place
import com.sbaiardi.mystory.data.Result
import com.sbaiardi.mystory.network.NameService
import com.sbaiardi.mystory.network.PlaceService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExtractionViewModel  : ViewModel() {

    private val _name = MutableLiveData<Character>()
    val name: LiveData<Character> = _name

    fun getRandomName(){
        CoroutineScope(Dispatchers.Main).launch(Dispatchers.IO) {
            _name.postValue(NameService.randomChoose())
        }
    }

    private val _place = MutableLiveData<Place>()
    val place: LiveData<Place> = _place

    fun getRandomPlace(){
        CoroutineScope(Dispatchers.Main).launch(Dispatchers.IO) {
            _place.postValue(PlaceService.randomChoose())
        }
    }

}