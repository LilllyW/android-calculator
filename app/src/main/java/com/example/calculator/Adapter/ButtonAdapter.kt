package com.example.calculator.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.R

class ButtonAdapter(private val list : ArrayList<String>) : RecyclerView.Adapter<ButtonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_button_list, parent, false)
        return ViewHolder(view)
    }//告訴adapter viewHolder是抓哪個layout

    override fun getItemCount(): Int = list.size
    //複寫  回傳長度

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btnResult.text = list[position]
        holder.btnResult.tag = list[position]
    }//把list的值 丟過去 改變每個viewHolder裡得值 （bind綁定＝>loop）

    class ViewHolder(view: View) :  RecyclerView.ViewHolder(view) {
        val btnResult: Button = view.findViewById<Button>(R.id.btnResult)
    }//宣告view裡面的物件
}