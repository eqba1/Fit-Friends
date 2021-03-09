package com.example.android.fit_friends.ui.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.android.fit_friends.R
import com.example.android.fit_friends.data.local.db.AppDatabase
import com.example.android.fit_friends.data.local.db.dataAccessObject.AccountDataAccessObject
import com.example.android.fit_friends.data.model.Account
import com.example.android.fit_friends.data.repository.AppRepository
import com.example.android.fit_friends.ui.activities.DashboardActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val activity = this@LoginActivity

    private lateinit var appDatabase: AppDatabase
    private lateinit var inputValidation: InputValidation
    private lateinit var accountDataAccessObject: AccountDataAccessObject
    private lateinit var appRepository: AppRepository

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    private lateinit var loginButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // creates an account for admin in database
//        val adminAccount = Account("admin", "admin", null)

         appDatabase = AppDatabase(activity)
        accountDataAccessObject = AccountDataAccessObject(appDatabase)

         appRepository = AppRepository(accountDataAccessObject, null, null, null)
//        appRepository.saveAccount(adminAccount)

        // it shows the rows of the table in Logcat, named "TESSST"
        // it --> refers to Account class
//        appRepository.findAllAccounts().forEach { Log.i("TESSST", it.toString()) }



        // initializing the views
        initViews()

        // initializing the listeners
        initListeners()

        // initializing the objects
        initObjects()

    }

    private fun initViews() {
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
    }

    private fun initListeners() {
        loginButton!!.setOnClickListener(activity)
    }


    private fun initObjects() {

        appDatabase = AppDatabase(activity)
        inputValidation = InputValidation(activity)
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.loginButton -> verifyFromSQLite()
        }
    }

    private fun verifyFromSQLite() {
        if (!inputValidation!!.inputEditTextFilled(usernameEditText!!)) {
            return
        }

        if (!inputValidation!!.inputEditTextFilled(passwordEditText!!)) {
            return
        }

        if (appRepository.findAccountById("1").username.equals(usernameEditText!!.text.toString()) &&
            appRepository.findAccountById("1").password.equals(passwordEditText!!.text.toString()) ) {


            val dashboardIntent = Intent(activity, DashboardActivity::class.java)
            startActivity(dashboardIntent)


        } else {

            // Snack Bar to show success message that record is wrong
            Toast.makeText(this, "نام کاربری و یا رمز عبور وارد شده صحیح نمی باشد!", Toast.LENGTH_SHORT).show()
        }

    }


}