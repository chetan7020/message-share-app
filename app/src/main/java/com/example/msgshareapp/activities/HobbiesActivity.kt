package com.example.msgshareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.msgshareapp.adapters.HobbiesAdapter
import com.example.msgshareapp.R
import com.example.msgshareapp.Supplier

class HobbiesActivity : AppCompatActivity() {

    companion object{
        val TAG : String = HobbiesActivity :: class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val rv = findViewById<RecyclerView>(R.id.reycle)
        val layoutManger = LinearLayoutManager(this)
        layoutManger.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = layoutManger

        val adapter = HobbiesAdapter(this , Supplier.hobbies)
        rv.adapter = adapter
    }
}
