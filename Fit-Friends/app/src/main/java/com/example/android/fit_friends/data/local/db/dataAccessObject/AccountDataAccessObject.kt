package com.example.android.fit_friends.data.local.db.dataAccessObject

import android.content.ContentValues
import com.example.android.fit_friends.data.local.db.AppDatabase
import com.example.android.fit_friends.data.model.Account
import java.util.ArrayList

// we need one dataAccessObject class for each data model class
// this classes show the access of each data model to the methods
// data access object package accesses data directly
class AccountDataAccessObject(appDatabase: AppDatabase) :
    BaseDataAccessObject<Account>(appDatabase) {

    // for each method we must do three things:
    // 1. open data base
    // 2. implement method
    // 3. close data base

    override fun save(entity: Account): Boolean {

        // we want to insert an entity, so it's writable
        val db = appDatabase.writableDatabase

        // it clears contentValues, so we can add new data
        contentValues.clear()

        contentValues.put(AppDatabase.ACCOUNT_USERNAME, entity.username)
        contentValues.put(AppDatabase.ACCOUNT_PASSWORD, entity.password)
        contentValues.put(AppDatabase.ACCOUNT_REGISTER_DATE, entity.registerDate)

        // nullColumnHack --> what to do if the content value is null(if not initialized)
        val result = db.insert(AppDatabase.ACCOUNT_TABLE, null, contentValues)
        db.close()

        if (result > 0) return true
        return false
    }

    override fun save(id: String, entity: Account): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Account> {

        // we want to get data, so it's readable
        val db = appDatabase.readableDatabase

        query = "SELECT * FROM " + AppDatabase.ACCOUNT_TABLE

        // this helps us write "select" command as SQL query
        val cursor = db.rawQuery(query, null)

        data.clear()

        // if there is at least one row in the table
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex(AppDatabase.ACCOUNT_ID))
                val userName = cursor.getString(cursor.getColumnIndex(AppDatabase.ACCOUNT_USERNAME))
                val password = cursor.getString(cursor.getColumnIndex(AppDatabase.ACCOUNT_PASSWORD))
                val registerDate =
                    cursor.getString(cursor.getColumnIndex(AppDatabase.ACCOUNT_REGISTER_DATE))

                data.add(Account(id.toLong(), userName, password, registerDate))

            } while (cursor.moveToNext()) // if the next row exists
        }

        cursor.close()
        db.close()

        return data
    }

    override fun find(columnName: String, columnValue: String): List<Account> {

        // we want to get data, so it's readable
        val db = appDatabase.readableDatabase

        query = "SELECT * FROM " + AppDatabase.ACCOUNT_TABLE + " WHERE $columnName = ?"

        // this helps us write "select" command as SQL query
        val cursor = db.rawQuery(query, arrayOf(columnValue))

        data.clear()

        // if there is at least one row in the table
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex(AppDatabase.ACCOUNT_ID))
                val userName = cursor.getString(cursor.getColumnIndex(AppDatabase.ACCOUNT_USERNAME))
                val password = cursor.getString(cursor.getColumnIndex(AppDatabase.ACCOUNT_PASSWORD))
                val registerDate =
                    cursor.getString(cursor.getColumnIndex(AppDatabase.ACCOUNT_REGISTER_DATE))

                data.add(Account(id.toLong(), userName, password, registerDate))

            } while (cursor.moveToNext()) // if the next row exists
        }

        cursor.close()
        db.close()

        return data
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }


}