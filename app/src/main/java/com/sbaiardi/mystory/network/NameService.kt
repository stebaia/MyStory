package com.sbaiardi.mystory.network

import com.sbaiardi.mystory.data.Character
import kotlin.random.Random

class NameService {

    companion object{
        var characterList = mutableListOf(
            Character("Hebri", is_chosen = false, is_used = false),
            Character("Filo", is_chosen = false, is_used = false),
            Character("Mura", is_chosen = false, is_used = false),
            Character("Fari", is_chosen = false, is_used = false),
            Character("Stewie", is_chosen = false, is_used = false),
            Character("Peru", is_chosen = false, is_used = false),
            Character("Eli", is_chosen = false, is_used = false),
        )
        fun randomChoose(): Character{
            val tmpList = characterList.filter { !it.is_chosen }
            return if (tmpList.isNotEmpty()){
                val randomIndex = Random.nextInt(tmpList.size)
                val randomElement = tmpList[randomIndex]
                characterList.find { it.name == randomElement.name }!!.is_chosen = true
                randomElement
            }else
                Character("Hebri", is_chosen = true, is_used = false)
        }
    }
}