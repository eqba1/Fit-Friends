package com.example.android.fit_friends.data.local.db.dataAccessObject

import android.content.ContentValues
import com.example.android.fit_friends.data.local.db.AppDatabase

// this abstract class holds all the common methods that we use in each class
// because we don't know the type of inputs, we declare class Generic
abstract class BaseDataAccessObject<T>(val appDatabase: AppDatabase) {

    // it's like hashmap, with key/value structure
    val contentValues = ContentValues()

    // this method do the create part of CRUD
    abstract fun save(entity: T): Boolean

    // this method do the update part of CRUD, we overload save method here
    abstract fun save(id: String, entity: T): Boolean

    // this method returns the data about all of th entities saved in db
    abstract fun findAll(): List<T>

    // this method the data about entities according to our clause
    // columnValue --> the value of the column
    abstract fun find(columnName: String, columnValue: String): List<T>

    // this method do the delete part of CRUD
    abstract fun delete(id: String): Boolean

}