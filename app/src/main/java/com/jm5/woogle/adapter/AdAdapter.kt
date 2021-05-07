package com.jm5.woogle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jm5.woogle.data.Ad_lists
import com.jm5.woogle.R

class AdAdapter(val context : Context, var list : ArrayList<Ad_lists>) : RecyclerView.Adapter<AdAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView : ImageView = itemView.findViewById(R.id.ad_img)
//        var pageText : TextView = itemView.findViewById(R.id.ad_text_page)
//        var imgView : CardView = itemView.findViewById(R.id.ad_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ad_items,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
//        return Int.MAX_VALUE
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        var index = position % list.size
        var result = list[position]
        var url = result.img
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.woogle_logo_02)
            .centerCrop()
            .into(holder.imgView)
//        holder.pageText.text = "${position+1}"
    }
}