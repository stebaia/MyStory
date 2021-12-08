package com.sbaiardi.mystory.network

import com.sbaiardi.mystory.data.Place
import kotlin.random.Random

class PlaceService {
    companion object{
        val placeList = mutableListOf(
            Place("Campino di Bulgaria"),
            Place("Lampedusa"),
            Place("Marte"),
            Place("Scampia"),
            Place("Hogwarts"),
            Place("Grande Fratello"),
            Place("Prigione"),
        )
        fun randomChoose(): Place {
            val randomIndex = Random.nextInt(placeList.size)
            return placeList[randomIndex]
        }
    }
}