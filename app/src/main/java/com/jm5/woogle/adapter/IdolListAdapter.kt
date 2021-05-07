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
import com.jm5.woogle.R
import com.jm5.woogle.data.Contents_list
import com.jm5.woogle.data.IdolList

class IdolListAdapter(val context : Context, var list : ArrayList<IdolList>) : RecyclerView.Adapter<IdolListAdapter.ViewHolder>(),OnItemClickListener {
    lateinit var listener : OnItemClickListener
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        var idolImg = itemView.findViewById<ImageView>(R.id.idol_img)
        var idolTeamName = itemView.findViewById<TextView>(R.id.idol_team_name)
//        var idolSelected = itemView.findViewById<TextView>(R.id.idol_selected)
        val view = itemView.setOnClickListener {
            val position = adapterPosition
            listener.onIdolClick(this, it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.idol_lists,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = list[position]
        val url = result.idolImg
//        Glide.with(context)
//            .load(url)
//            .placeholder(R.drawable.woogle_logo_02)
//            .circleCrop()
//            .into(holder.idolImg)

        holder.idolTeamName.text = result.idolTeamName
//        if(result.selected==true) holder.idolSelected.setBackgroundResource(R.drawable.round_selector_true)
//        else holder.idolSelected.setBackgroundResource(R.drawable.round_selector_false)
    }

    fun setItemListener(listener: OnItemClickListener){
        this.listener=listener
    }

    fun getItem(position : Int) : IdolList {
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

    override fun onMallItemClick(holder: MallItemAdapter.ViewHolder, view: View, position: Int) {}

    override fun onIdolClick(holder: ViewHolder, view: View, position: Int) {
        listener.onIdolClick(holder,view, position)
    }
}