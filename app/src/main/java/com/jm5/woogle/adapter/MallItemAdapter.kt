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
import com.jm5.woogle.data.MallItemList
import com.jm5.woogle.R
import com.jm5.woogle.data.Contents_list

class MallItemAdapter(val context : Context, val list : ArrayList<MallItemList>):RecyclerView.Adapter<MallItemAdapter.ViewHolder>(), OnItemClickListener {
    lateinit var listener : OnItemClickListener
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemImg : ImageView = itemView.findViewById(R.id.mall_detail_items_img)
        val itemTag : TextView = itemView.findViewById(R.id.mall_detail_items_tag)
        val itemTitle : TextView = itemView.findViewById(R.id.mall_detail_items_title)
        val itemPrice : TextView = itemView.findViewById(R.id.mall_detail_items_price)

        val view = itemView.setOnClickListener {
            val position = adapterPosition
            listener.onMallItemClick(this, it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mall_detail_items,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = list[position]
        val url = result.itemImg
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.woogle_logo_02)
            .centerCrop()
            .into(holder.itemImg)
        holder.itemTag.text = result.tag
        holder.itemTitle.text = result.title
        holder.itemPrice.text = result.price
    }

    fun setItemListener(listener: OnItemClickListener){
        this.listener=listener
    }

    fun getItem(position : Int) : MallItemList {
        return list[position]
    }

    override fun onContentsItemClick(
        holder: ContentsAdapter.ViewHolder,
        view: View,
        position: Int
    ) {}

    override fun onCategoryItemClick(
        holder: MallCategoryAdapter.ViewHolder,
        view: View,
        position: Int
    ) {}

    override fun onMallItemClick(holder: ViewHolder, view: View, position: Int) {
        listener.onMallItemClick(holder,view, position)
    }

    override fun onIdolClick(holder: IdolListAdapter.ViewHolder, view: View, position: Int) {

    }
}