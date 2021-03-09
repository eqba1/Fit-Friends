package com.example.android.fit_friends.data.repository

import com.example.android.fit_friends.data.local.db.AppDatabase
import com.example.android.fit_friends.data.model.Account
import com.example.android.fit_friends.data.local.db.dataAccessObject.AccountDataAccessObject
import com.example.android.fit_friends.data.local.db.dataAccessObject.AdminDataAccessObject
import com.example.android.fit_friends.data.local.db.dataAccessObject.ManagerDataAccessObject
import com.example.android.fit_friends.data.local.db.dataAccessObject.TrainerDataAccessObject

class AppRepository(
    val accountDataAccessObject: AccountDataAccessObject,
    val adminDataAccessObject: AdminDataAccessObject?,
    val managerDataAccessObject: ManagerDataAccessObject?,
    val trainerDataAccessObject: TrainerDataAccessObject?
) {

    fun saveAccount(account: Account): Boolean {
        return accountDataAccessObject.save(account)
    }


    fun findAllAccounts(): List<Account> {
        return accountDataAccessObject.findAll()
    }

    fun findAccountById(id: String): Account {
        return accountDataAccessObject.find(AppDatabase.ACCOUNT_ID, id)[0]
    }

    fun findAccountsByUserName(userName: String): List<Account> {
        return accountDataAccessObject.find(AppDatabase.ACCOUNT_USERNAME, userName)
    }

}