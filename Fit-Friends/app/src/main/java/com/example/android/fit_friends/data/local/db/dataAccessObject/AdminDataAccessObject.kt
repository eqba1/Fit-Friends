package com.example.android.fit_friends.data.local.db.dataAccessObject

import com.example.android.fit_friends.data.local.db.AppDatabase
import com.example.android.fit_friends.data.model.Admin

class AdminDataAccessObject(appDatabase: AppDatabase):BaseDataAccessObject<Admin>(appDatabase) {
    override fun save(entity: Admin): Boolean {
        TODO("Not yet implemented")
    }

    override fun save(id: String, entity: Admin): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Admin> {
        TODO("Not yet implemented")
    }

    override fun find(columnName: String, columnValue: String): List<Admin> {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }
}