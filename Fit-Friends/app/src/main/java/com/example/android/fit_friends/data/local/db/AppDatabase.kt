package com.example.android.fit_friends.data.local.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// defines database tables, columns of tablas, database name,
// database version, etc.
// extends SQLiteOpenHelper to use it methods for create database
class AppDatabase(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // defines final static properties
    companion object {

        private const val DATABASE_NAME = "sqLiteDB.db"

        // if the structure of tables change, this version number changes
        private const val DATABASE_VERSION = 1

        // defines account table and it's columns
        const val ACCOUNT_TABLE = "account"
        const val ACCOUNT_ID = "id"
        const val ACCOUNT_USERNAME = "username"
        const val ACCOUNT_PASSWORD = "password"
        const val ACCOUNT_REGISTER_DATE = "register_date"

        // defines person table
        const val PERSON_TABLE = "person"
        const val PERSON_ID = "id"
        const val PERSON_FIRSTNAME = "firstname"
        const val PERSON_LASTNAME = "lastname"
        const val PERSON_BIRTHDATE = "birth_date"
        const val PERSON_PHONENUMBER = "phone_number"
        const val PERSON_EMAIL = "email"
        const val PERSON_ADDRESS = "address"
        const val PERSON_NCN = "national_card_number"

        // defines admin table
        const val ADMIN_TABLE = "admin"
        const val ADMIN_ID = "id"
        const val ADMIN_ACCOUNT_ID = "account_id"
        const val ADMIN_PERSON_ID = "person_id"

        // defines manager table
        const val MANAGER_TABLE = "manager"
        const val MANAGER_ID = "id"
        const val MANAGER_ACCOUNT_ID = "account_id"
        const val MANAGER_PERSON_ID = "person_id"

        // defines trainer table
        const val TRAINER_TABLE = "trainer"
        const val TRAINER_ID = "id"
        const val TRAINER_FIELD = "field"
        const val TRAINER_ACCOUNT_ID = "account_id"
        const val TRAINER_PERSON_ID = "person_id"
    }

    //    we create tables here, if not exist
    override fun onCreate(sqLite: SQLiteDatabase?) {

        // creates account table if not exist
        // executes SQL commands
        // we put "!!" because sqLite it's nullable
        sqLite!!.execSQL("CREATE TABLE IF NOT EXISTS $ACCOUNT_TABLE (" +
                "$ACCOUNT_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$ACCOUNT_USERNAME VARCHAR(20) NOT NULL, " +
                "$ACCOUNT_PASSWORD TEXT NOT NULL, " +
                "$ACCOUNT_REGISTER_DATE VARCHAR(10))")

        // creates person table
        sqLite!!.execSQL("CREATE TABLE IF NOT EXISTS $PERSON_TABLE (" +
                "$PERSON_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$PERSON_FIRSTNAME VARCHAR(20) ," +
                "$PERSON_LASTNAME VARCHAR(30) ," +
                "$PERSON_BIRTHDATE VARCHAR(10) ," +
                "$PERSON_PHONENUMBER VARCHAR(11) ," +
                "$PERSON_EMAIL VARCHAR(40) ," +
                "$PERSON_ADDRESS TEXT ," +
                "$PERSON_NCN VARCHAR(10))")

        // creates admin table
        sqLite!!.execSQL("CREATE TABLE IF NOT EXISTS $ADMIN_TABLE (" +
                "$ADMIN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FOREIGN KEY($ADMIN_ACCOUNT_ID) REFERENCES $ACCOUNT_TABLE($ACCOUNT_ID), " +
                "FOREIGN KEY($ADMIN_PERSON_ID) REFERENCES $PERSON_TABLE($PERSON_ID))")

        // creates manager table
        sqLite!!.execSQL("CREATE TABLE IF NOT EXISTS $MANAGER_TABLE (" +
                "$MANAGER_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FOREIGN KEY($MANAGER_ACCOUNT_ID) REFERENCES $ACCOUNT_TABLE($ACCOUNT_ID), " +
                "FOREIGN KEY($MANAGER_PERSON_ID) REFERENCES $PERSON_TABLE($PERSON_ID))")

        // creates trainer table
        sqLite!!.execSQL("CREATE TABLE IF NOT EXISTS $TRAINER_TABLE (" +
                "$TRAINER_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$TRAINER_FIELD VARCHAR(30), " +
                "FOREIGN KEY($TRAINER_ACCOUNT_ID) REFERENCES $ACCOUNT_TABLE($ACCOUNT_ID), " +
                "FOREIGN KEY($TRAINER_PERSON_ID) REFERENCES $PERSON_TABLE($PERSON_ID))")
    }

    //    when we change table columns this method executes
    override fun onUpgrade(sqLite: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        // first we drop table, then rebuild it (if exists)
        sqLite!!.execSQL("DROP TABLE IF EXISTS $ACCOUNT_TABLE")
        onCreate(sqLite)

        // upgrade changes in person's table
        sqLite!!.execSQL("DROP TABLE IF EXISTS $PERSON_TABLE")
        onCreate(sqLite)

        // upgrade changes in admin's table
        sqLite!!.execSQL("DROP TABLE IF EXISTS $ADMIN_TABLE")
        onCreate(sqLite)

        // upgrade changes in manager's table
        sqLite!!.execSQL("DROP TABLE IF EXISTS $MANAGER_TABLE")
        onCreate(sqLite)

        // upgrade changes in trainer's table
        sqLite!!.execSQL("DROP TABLE IF EXISTS $TRAINER_TABLE")
        onCreate(sqLite)
    }


}