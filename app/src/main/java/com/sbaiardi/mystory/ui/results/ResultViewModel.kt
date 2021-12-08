package com.sbaiardi.mystory.ui.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sbaiardi.mystory.data.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ResultViewModel: ViewModel() {

    private val _results = MutableLiveData<MutableList<Result>>()
    val results: LiveData<MutableList<Result>> = _results



    fun getListResult() {
        CoroutineScope(Main).launch(Dispatchers.IO) {
            val resultsList = Result.resultList
            _results.postValue(resultsList)
        }
    }

}