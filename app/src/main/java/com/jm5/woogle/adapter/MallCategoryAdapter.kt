package com.jm5.woogle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jm5.woogle.MallCategotyitems
import com.jm5.woogle.OnItemClickListener
import com.jm5.woogle.R
import com.jm5.woogle.data.MallItemList

class MallCategoryAdapter(val context : Context, val list : ArrayList<MallCategotyitems>) : RecyclerView.Adapter<MallCategoryAdapter.ViewHolder>(), OnItemClickListener {
    lateinit var listener: OnItemClickListener
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val mall_cate_img : ImageView = itemView.findViewById(R.id.mall_category_img)
       val mall_cate_text : TextView = itemView.findViewById(R.id.mall_category_text)
        val view = itemView.setOnClickListener {
            val position = adapterPosition
            listener.onCategoryItemClick(this, it, position)
        }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mall_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = list[position]
        val url = result.img
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.woogle_logo_02)
//            .centerCrop()
            .circleCrop()
            .into(holder.mall_cate_img)
        holder.mall_cate_text.text = result.tag
    }
    fun setItemListener(listener: OnItemClickListener){
        this.listener=listener
    }

    fun getItem(position : Int) : MallCategotyitems {
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
    ) {
        listener.onCategoryItemClick(holder,view, position)
    }
    override fun onMallItemClick(holder: MallItemAdapter.ViewHolder, view: View, position: Int) {}
    override fun onIdolClick(holder: IdolListAdapter.ViewHolder, view: View, position: Int) {

    }
}