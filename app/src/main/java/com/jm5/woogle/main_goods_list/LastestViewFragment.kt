package com.jm5.woogle.main_goods_list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jm5.woogle.DetailItemActivity
import com.jm5.woogle.OnItemClickListener
import com.jm5.woogle.R
import com.jm5.woogle.adapter.ContentsAdapter
import com.jm5.woogle.adapter.IdolListAdapter
import com.jm5.woogle.adapter.MallCategoryAdapter
import com.jm5.woogle.adapter.MallItemAdapter
import com.jm5.woogle.data.MallItemList

class LastestViewFragment : Fragment() {
    var items_list = ArrayList<MallItemList>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lastest_view, container, false)
        val context = view.context

        updateItemList()

        val recyclerView = view.findViewById<RecyclerView>(R.id.lastestview_recyclerview)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        val adapter = MallItemAdapter(context, items_list)
        recyclerView.adapter = adapter



        adapter.setItemListener(object : OnItemClickListener {
            override fun onContentsItemClick(
                holder: ContentsAdapter.ViewHolder,
                view: View,
                position: Int
            ) {}
            override fun onIdolClick(
                holder: IdolListAdapter.ViewHolder,
                view: View,
                position: Int
            ) {
            }
            override fun onCategoryItemClick(
                holder: MallCategoryAdapter.ViewHolder,
                view: View,
                position: Int
            ) {}

            override fun onMallItemClick(
                holder: MallItemAdapter.ViewHolder,
                view: View,
                position: Int
            ) {
                val item = adapter.getItem(position)

                val intent = Intent(context, DetailItemActivity::class.java)
                intent.putExtra("itemImg",item.itemImg)
                intent.putExtra("itemCategory",item.tag)
                intent.putExtra("itemTitle",item.title)
                intent.putExtra("itemPrice",item.price)
                startActivity(intent)
            }
        })
        return view
    }
    fun updateItemList(){
        items_list.clear()
        items_list.add(
            MallItemList(
                "https://pbs.twimg.com/media/Eg0xf96UwAA6odd.jpg",
                "Twice",
                "트와이스 (TWICE) 2018 시즌 그리팅",
                "10,000"
            )
        )
        items_list.add(
            MallItemList(
                "https://pbs.twimg.com/media/Eg0xf96UwAA6odd.jpg",
                "Twice",
                "트와이스 (TWICE) 2018 시즌 그리팅",
                "10,000"
            )
        )
        items_list.add(
            MallItemList(
                "https://akamai.poxo.com/ygnext/ygnext.cafe24.com/web/product/big/202102/d2789bf916ad16516ffc355cb2dc17d1.jpg",
                "Twice",
                "트와이스 (TWICE) 2018 시즌 그리팅",
                "12,000"
            )
        )
        items_list.add(
            MallItemList(
                "https://akamai.poxo.com/ygnext/ygnext.cafe24.com/web/product/big/202102/d2789bf916ad16516ffc355cb2dc17d1.jpg",
                "Twice",
                "트와이스 (TWICE) 2018 시즌 그리팅",
                "12,000"
            )
        )
        items_list.add(
            MallItemList(
                "https://akamai.poxo.com/ygnext/ygnext.cafe24.com/web/product/big/202102/d2789bf916ad16516ffc355cb2dc17d1.jpg",
                "Twice",
                "트와이스 (TWICE) 2018 시즌 그리팅",
                "12,000"
            )
        )
        items_list.add(
            MallItemList(
                "https://withdrama.co.kr/web/product/big/201808/329f22f9d45a74a02962b20ae8d8039c.jpg",
                "Twice",
                "트와이스 (TWICE) 2018 시즌 그리팅",
                "7,000"
            )
        )
        items_list.add(
            MallItemList(
                "https://withdrama.co.kr/web/product/big/201808/329f22f9d45a74a02962b20ae8d8039c.jpg",
                "Twice",
                "트와이스 (TWICE) 2018 시즌 그리팅",
                "7,000"
            )
        )
        items_list.add(
            MallItemList(
                "https://withdrama.co.kr/web/product/big/201808/329f22f9d45a74a02962b20ae8d8039c.jpg",
                "Twice",
                "트와이스 (TWICE) 2018 시즌 그리팅",
                "7,000"
            )
        )
    }
}