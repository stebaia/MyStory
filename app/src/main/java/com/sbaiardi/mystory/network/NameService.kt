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
        val actionList = mutableListOf(
            "è morto!",
            "è fuggito in messico!",
            "vuole uscire da questa storia",
            "si è andato a fare un panino",
            "ha scoreggiato troppo forte e è esploso",
            "è andato a cagare",
            "è andato a studiare per gli esami del sangue",
            "deve sostituire un suo collega spazzino",
            "è andato a pulire lo sbocco della festeggiata della scorsa laurea",
            "è andato a pulire la nuova casa di Simo",
            "starnutendo ha fatto il richiamo per i piccioni e ora è coperto di guano",
            "deve allacciare le scarpe al suo nuovo millepiedi"

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
                val action = randomExit(oldCharacter.name)
                Result.resultList.add(Result(action,TYPE_RESULT.IMPREVISTO))
                Result.resultList.add(Result("Il nuovo personaggio è ${newCharacter.name}", TYPE_RESULT.IMPREVISTO))
                return "$action \n Il nuovo personaggio è ${newCharacter.name}"
            }
            return "fine"
        }

        private fun randomExit(name: String): String{
            val randomIndex = Random.nextInt(actionList.size)
            val randomElement = actionList[randomIndex]
            return "$name $randomElement"
        }
    }
}