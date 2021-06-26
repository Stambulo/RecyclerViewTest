package com.stambulo.testrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = "Element - $position"
        holder.textView.text = pos
    }

    override fun getItemCount(): Int {
        return 50
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var textView: TextView = view.findViewById(R.id.text_item)
    }
}
