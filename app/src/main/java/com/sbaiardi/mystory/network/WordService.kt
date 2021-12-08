package com.sbaiardi.mystory.network

import com.sbaiardi.mystory.data.Character
import com.sbaiardi.mystory.data.Result
import com.sbaiardi.mystory.data.Word
import com.sbaiardi.mystory.utils.adapter.TYPE_RESULT
import kotlin.random.Random

class WordService {
    companion object{
        var wordList = mutableListOf(
            Word("Cane",false),
            Word("Gelato",false),
            Word("Neve",false),
            Word("Tampone",false),
            Word("Organo",false),
            Word("Palline",false),
            Word("Polline",false),
            Word("Pallone",false),
            Word("Tesi",false),
            Word("Calamaro",false),
            Word("Bolze",false),
            Word("Ringo",false),
            Word("Amore",false),
            Word("Visita",false),
            Word("Vidia",false),
            Word("Nuoto",false),
            Word("BulgariaCammina",false),
            Word("Kiwii",false),
            Word("Sigaretta elettronica",false),
            Word("Tommaso zanzi",false),
            Word("Patate fritte",false),
            Word("Tombola",false),
            Word("Odori e sapori",false),
            Word("Berlusconi",false),
            Word("Faccia",false),
            Word("Caccia al cinghiale",false),
            Word("Maradona",false),
            Word("Maraffa",false),
            Word("Renna",false),
            Word("Gnomo",false),
            Word("Babbo Natale",false),
            Word("Estetista",false),
            Word("Assignista",false),
            Word("Campo scuola",false),
            Word("Frati",false),
            Word("Queen",false),
            Word("LGBT",false),
            Word("Navetta",false),
            Word("Pistola",false),
            Word("Cerbottana",false),
            Word("Mitragliatrice",false),
            Word("Vanga",false),
            Word("Badile",false),
            Word("Monopoli",false),
        )

        fun randomChoose(): Word {
            val tmpList = wordList.filter { !it.is_used }
            return if (tmpList.isNotEmpty()){
                val randomIndex = Random.nextInt(tmpList.size)
                val randomElement = tmpList[randomIndex]
                wordList.find { it.name == randomElement.name }!!.is_used = true
                Result.resultList.add(Result(randomElement.name, TYPE_RESULT.SUGGERIMENTO))
                randomElement
            }else
                Word("Ops! Finiti i suggerimenti!",false)
        }

    }

}