package com.sbaiardi.mystory.data

import com.sbaiardi.mystory.utils.adapter.TYPE_RESULT

data class Result(val name: String, val type: TYPE_RESULT) {
    companion object{
        lateinit var result_first_character: Character
        lateinit var result_second_character: Character
        lateinit var result_place: Place
        val resultList = mutableListOf<Result>()
    }
}