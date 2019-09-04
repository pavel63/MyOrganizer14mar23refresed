package com.pavelwinter.myorganizer.data

import com.pavelwinter.myorganizer.data.db.db_entities.DaoSession

interface IMainRepository {
    fun getSharedPrefsRepository()
    fun getDb():DaoSession
}