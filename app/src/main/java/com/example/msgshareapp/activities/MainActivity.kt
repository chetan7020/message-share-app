package com.example.msgshareapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG : String = MainActivity :: class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val st = findViewById<Button>(R.id.show_toast)
        st.setOnClickListener{
            Log.i(TAG, "Button was clicked")
            showToast("Button was clicked")
        }

        val sm = findViewById<Button>(R.id.send_message)
        val ut = findViewById<EditText>(R.id.user_text)
        sm.setOnClickListener{
            val msg : String = ut.text.toString()
            val intent = Intent(this , SecondActivity :: class.java)
            intent.putExtra(Constants.USER_MSG_KEY , msg)
            startActivity(intent)
        }

        val so = findViewById<Button>(R.id.share_other)
        so.setOnClickListener{
            val msg : String = ut.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT , msg)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent , "Share to : "))
        }

        val rv = findViewById<Button>(R.id.recycler_view)
        rv.setOnClickListener{
            val intent = Intent(this , HobbiesActivity :: class.java)
            startActivity(intent)
        }
    }
}
