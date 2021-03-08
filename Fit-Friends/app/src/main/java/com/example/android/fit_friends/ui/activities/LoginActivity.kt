package com.example.android.fit_friends.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.fit_friends.R
import com.example.android.fit_friends.data.local.db.AppDatabase
import com.example.android.fit_friends.data.local.db.dataAccessObject.AccountDataAccessObject
import com.example.android.fit_friends.data.model.Account
import com.example.android.fit_friends.data.repository.AppRepository

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // creates an account for admin in database
        val adminAccount = Account("admin", "admin", null)

        val appDatabase = AppDatabase(this)
        val accountDataAccessObject = AccountDataAccessObject(appDatabase)

        val appRepository = AppRepository(accountDataAccessObject, null, null, null)
        appRepository.saveAccount(adminAccount)



    }
}