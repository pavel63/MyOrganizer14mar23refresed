package com.pavelwinter.myorganizer.data.mocks

import kotlin.random.Random
import kotlin.random.nextLong

object RandomTypesGenerator {


    fun getRandomString(length: Int): String {
        val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }


    fun getRandomInt(rangeTo : Int) = Random.nextInt(0, rangeTo)


    fun getRandomLong() = Random.nextLong(0,100)
}

