package com.example.android.fit_friends.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.fit_friends.R
import java.util.*

// class splashActivity to show a splash screen for 4 seconds
class SplashActivity : AppCompatActivity() {

    // time delay for the splash screen in ms
    private val SPLASH_TIME_OUT: Long = 4000

    // method to set timer for the delay of the splash activity
    private fun launchDelay(delay: Long) {
        val launchDelay = object : TimerTask() {
            override fun run() {
                // calls this method to launch main activity after the delay
                launchSplashActivity()
            }
        }

        val timer = Timer("SplashScreenTimer")
        timer.schedule(launchDelay, delay)
    }

    // method to launch main activity after splash activity
    private fun launchSplashActivity() {
        // launch another activity
        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
        startActivity(intent)
        finish() // necessary because we do not want user to come back to this activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        // call launchDelay method to launch the splash activity
        launchDelay(SPLASH_TIME_OUT)
    }
}