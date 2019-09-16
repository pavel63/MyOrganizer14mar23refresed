package com.pavelwinter.myorganizer.data.mocks

import com.pavelwinter.myorganizer.data.db.db_entities.ParentType

object DataTypesGenerator {

    fun generateMockParent() = ParentType(
        RandomTypesGenerator.getRandomLong(),
        RandomTypesGenerator.getRandomString(10),
        RandomTypesGenerator.getRandomInt(3),
        RandomTypesGenerator.getRandomInt(100),
        RandomTypesGenerator.getRandomString(10),
        RandomTypesGenerator.getRandomLong(),
        RandomTypesGenerator.getRandomLong()
    )



    fun generateParentList() : List<ParentType>{
    return arrayListOf<ParentType>().apply {
        repeat(10){
            this.add(generateMockParent())
        }
        }
    }

}