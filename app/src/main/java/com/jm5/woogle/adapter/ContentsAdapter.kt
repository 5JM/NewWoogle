package com.jm5.woogle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jm5.woogle.OnItemClickListener
import com.jm5.woogle.data.Contents_list
import com.jm5.woogle.R

class ContentsAdapter(val context : Context, var list : ArrayList<Contents_list>) : RecyclerView.Adapter<ContentsAdapter.ViewHolder>(),OnItemClickListener {
    lateinit var listener : OnItemClickListener
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView : ImageView = itemView.findViewById(R.id.content_img)
        var categrory : TextView = itemView.findViewById(R.id.content_category)
        var title : TextView = itemView.findViewById(R.id.content_title)
        var price : TextView = itemView.findViewById(R.id.content_price)
        val view = itemView.setOnClickListener {
            val position = adapterPosition
            listener.onContentsItemClick(this, it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contents_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var result = list[position]
        var url = result.img
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.woogle_logo_02)
            .centerCrop()
            .into(holder.imgView)
        holder.categrory.text = result.category
        holder.title.text = result.title
        holder.price.text = result.price
    }

    fun setItemListener(listener: OnItemClickListener){
        this.listener=listener
    }

    fun getItem(position : Int) : Contents_list{
        return list[position]
    }

    override fun onContentsItemClick(holder: ViewHolder, view: View, position: Int) {
        listener.onContentsItemClick(holder,view, position)
    }

    override fun onCategoryItemClick(
        holder: MallCategoryAdapter.ViewHolder,
        view: View,
        position: Int
    ) {}

    override fun onMallItemClick(holder: MallItemAdapter.ViewHolder, view: View, position: Int) {}
    override fun onIdolClick(holder: IdolListAdapter.ViewHolder, view: View, position: Int) {

    }
}