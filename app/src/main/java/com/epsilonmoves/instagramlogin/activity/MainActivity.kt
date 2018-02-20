package com.epsilonmoves.instagramlogin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.epsilonmoves.instagramlogin.R
import com.epsilonmoves.instagramlogin.activity.fragments.InstagramLoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // to make the keyboard not pop up automatically
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.activity_main_content_frame, InstagramLoginFragment()).commit()
    }
}
