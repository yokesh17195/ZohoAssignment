package com.sample.zoho.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sample.zoho.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Yokesh.K.P
 * Activity for setting up splash screen and hosting fragment
 * */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // For implementing Splash Screen using Splash Screen API
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}