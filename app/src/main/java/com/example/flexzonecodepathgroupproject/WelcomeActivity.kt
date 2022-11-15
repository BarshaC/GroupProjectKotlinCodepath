package com.example.flexzonecodepathgroupproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class WelcomeActivity : AppCompatActivity() {
    var handler = Handler().postDelayed({
        val i = Intent(this@WelcomeActivity, LoginActivity::class.java)
        startActivity(i)
    }, 1400)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

    }
}