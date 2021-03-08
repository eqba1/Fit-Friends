package com.example.android.fit_friends.data.local.db.dataAccessObject


import com.example.android.fit_friends.data.local.db.AppDatabase
import com.example.android.fit_friends.data.model.Manager

class ManagerDataAccessObject(appDatabase: AppDatabase):BaseDataAccessObject<Manager>(appDatabase) {
    override fun save(entity: Manager): Boolean {
        TODO("Not yet implemented")
    }

    override fun save(id: String, entity: Manager): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Manager> {
        TODO("Not yet implemented")
    }

    override fun find(columnName: String, columnValue: String): List<Manager> {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }
}