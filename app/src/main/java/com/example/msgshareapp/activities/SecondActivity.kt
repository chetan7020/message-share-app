package com.example.msgshareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast

class SecondActivity : AppCompatActivity() {

    companion object{
        val TAG : String = SecondActivity :: class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle : Bundle? = intent.extras

        bundle?.let {
            val msg  = bundle.getString(Constants.USER_MSG_KEY)
            showToast(msg)
            val um = findViewById<TextView>(R.id.user_message)
            um.text = msg
        }


    }
}