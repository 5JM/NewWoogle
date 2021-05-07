package com.jm5.woogle

import android.view.View
import com.jm5.woogle.adapter.ContentsAdapter
import com.jm5.woogle.adapter.IdolListAdapter
import com.jm5.woogle.adapter.MallCategoryAdapter
import com.jm5.woogle.adapter.MallItemAdapter

interface OnItemClickListener {
    fun onContentsItemClick(holder:ContentsAdapter.ViewHolder, view: View, position:Int)
    fun onCategoryItemClick(holder:MallCategoryAdapter.ViewHolder, view: View, position:Int)
    fun onMallItemClick(holder:MallItemAdapter.ViewHolder, view: View, position:Int)
    fun onIdolClick(holder:IdolListAdapter.ViewHolder, view: View, position:Int)
}