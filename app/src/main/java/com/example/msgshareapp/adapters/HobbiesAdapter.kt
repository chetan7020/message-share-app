package com.example.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.msgshareapp.Hobby
import com.example.msgshareapp.R
import com.example.msgshareapp.activities.MainActivity
import com.example.msgshareapp.showToast

class HobbiesAdapter(val context : Context ,private val hobbies : List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){

    companion object{
        val TAG : String = HobbiesAdapter :: class.java.simpleName
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var currentHobby : Hobby? = null
        var currentPosition : Int = 0
        init {
            itemView.setOnClickListener{
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " Clicked !")
                }
            }
            itemView.findViewById<ImageView>(R.id.imgShare).setOnClickListener{
                currentHobby?.let {
                    val msg : String = "My hobby is : " + currentHobby!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT , msg)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent , "Share to : "))
                }
            }
        }
        fun setData(hobby: Hobby?, pos : Int){
            hobby?.let {
                itemView.findViewById<TextView>(R.id.txvTitle).text = hobby.title
            }
            this.currentHobby = hobby
            this.currentPosition = pos
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, p0 , false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val hobby = hobbies[p1]
        p0.setData(hobby , p1)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }
}