package com.example.android.fit_friends.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.fit_friends.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        Toast.makeText(this, "شما با موفقیت وارد حساب کاربری خود شدید", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "به سامانه مدیریت باشگاه بدنسازی خوش آمدید", Toast.LENGTH_SHORT).show()

    }
}