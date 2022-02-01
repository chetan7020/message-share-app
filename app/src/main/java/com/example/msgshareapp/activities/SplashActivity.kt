package com.example.msgshareapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.msgshareapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val si = findViewById<ImageView>(R.id.splash_icon)
        si.alpha = 0f
        si.animate().setDuration(3000).alpha(1f).withEndAction{
            val intent = Intent(this , MainActivity :: class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in , android.R.anim.fade_out)
            finish()
        }

    }
}