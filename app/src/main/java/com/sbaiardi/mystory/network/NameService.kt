package com.sbaiardi.mystory.network

import com.sbaiardi.mystory.data.Character
import com.sbaiardi.mystory.data.Result
import com.sbaiardi.mystory.utils.adapter.TYPE_RESULT
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
            val tmpList = characterList.filter { !it.is_chosen && !it.is_used }
            return if (tmpList.isNotEmpty()){
                val randomIndex = Random.nextInt(tmpList.size)
                val randomElement = tmpList[randomIndex]
                characterList.find { it.name == randomElement.name }!!.is_chosen = true
                randomElement
            }else
                Character("Hebri", is_chosen = true, is_used = false)
        }
        fun killCharacter(): String {
            val oldCharacter = characterList.find { it.is_chosen && !it.is_used }
            if (oldCharacter != null) {
                oldCharacter.is_used = true
                oldCharacter.is_chosen = false
                val newCharacter = randomChoose()

                if (oldCharacter.name == Result.result_first_character.name){
                    Result.result_first_character = newCharacter
                }else if (oldCharacter.name == Result.result_second_character.name){
                    Result.result_second_character = newCharacter
                }
                Result.resultList.add(Result("E' morto ${oldCharacter.name}!",TYPE_RESULT.IMPREVISTO))
                Result.resultList.add(Result("Il nuovo personaggio è ${newCharacter.name}", TYPE_RESULT.IMPREVISTO))
                return "E' morto ${oldCharacter.name}! \n Il nuovo personaggio è ${newCharacter.name}"
            }
            return "fine"
        }
    }
}