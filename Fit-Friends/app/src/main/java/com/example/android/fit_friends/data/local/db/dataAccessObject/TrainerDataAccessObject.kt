package com.example.android.fit_friends.data.local.db.dataAccessObject


import com.example.android.fit_friends.data.local.db.AppDatabase
import com.example.android.fit_friends.data.model.Trainer

class TrainerDataAccessObject(appDatabase: AppDatabase):BaseDataAccessObject<Trainer>(appDatabase) {
    override fun save(entity: Trainer): Boolean {
        TODO("Not yet implemented")
    }

    override fun save(id: String, entity: Trainer): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Trainer> {
        TODO("Not yet implemented")
    }

    override fun find(columnName: String, columnValue: String): List<Trainer> {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }
}