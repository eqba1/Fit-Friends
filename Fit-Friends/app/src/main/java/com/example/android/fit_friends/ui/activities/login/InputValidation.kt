package com.example.android.fit_friends.ui.activities.login

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class InputValidation(private val context: Context) {

    fun inputEditTextFilled(inputEditText: EditText):Boolean{

        val value = inputEditText.text.toString().trim()

        if (value.isEmpty()){
            hideKeyBoardFrom(inputEditText)
            Toast.makeText(context, "لطفا نام کاربری و رمز عبور را وارد کنید", Toast.LENGTH_SHORT) .show()
            return false
        }
        return true
    }

    private fun hideKeyBoardFrom(view: View) {

        val inputMethodManager=context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }



}