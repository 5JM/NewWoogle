package com.jm5.woogle.addProduct

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jm5.woogle.OnItemClickListener
import com.jm5.woogle.R
import com.jm5.woogle.adapter.ContentsAdapter
import com.jm5.woogle.adapter.IdolListAdapter
import com.jm5.woogle.adapter.MallCategoryAdapter
import com.jm5.woogle.adapter.MallItemAdapter
import com.jm5.woogle.data.IdolList
import kotlinx.android.synthetic.main.idol_lists.*

class Add1Fragment : Fragment() {
    var idolList = ArrayList<IdolList>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add1, container, false)
        val context = view.context

        updateIdolList()

        val recyclerView = view.findViewById<RecyclerView>(R.id.add_idol_recyclerview)
        val layoutInflater = LinearLayoutManager(context)
        recyclerView.layoutManager=layoutInflater
        val adapter = IdolListAdapter(context,idolList)
        recyclerView.adapter = adapter

        adapter.setItemListener(object  : OnItemClickListener {
            var times = true
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
            override fun onMallItemClick(
                holder: MallItemAdapter.ViewHolder,
                view: View,
                position: Int
            ) {}

            override fun onIdolClick(
                holder: IdolListAdapter.ViewHolder,
                view: View,
                position: Int
            ) {
                val item = adapter.getItem(position)
                Log.e("test1234>>","${position}")
                if(times) {
                    holder.itemView.setBackgroundResource(R.drawable.round_selector_true)
                    times = false
                }

//                idol_whole_round_selected.setBackgroundResource(R.drawable.round_selector_true)
//                idol_selected.setBackgroundResource(R.drawable.round_selector_true)

//                val bundle = Bundle()
//                bundle.putString("sendData", sendData)
                //bundle.putSerializable() : 객체를 보낼때 사용함
//                bundle.putSerializable("selected_idol", item)

            }
        })
        return view
    }
    fun updateIdolList(){
        idolList.clear()
        idolList.add(IdolList("http://www.nbnnews.co.kr/news/photo/202101/457577_500713_359.png","갓세븐") )
        idolList.add(IdolList("https://platum.kr/wp-content/uploads/2019/06/big-hit-entertainment-bts.png","방탄소년단") )
        idolList.add(IdolList("https://www.vhv.rs/dpng/d/451-4512697_-hd-png-download.png","트와이스") )
        idolList.add(IdolList("https://w7.pngwing.com/pngs/912/977/png-transparent-red-velvet-russian-roulette-bad-boy-the-red-perfect-velvet-red-velvet-kpop-tshirt-friendship-team.png","레드벨벳") )
    }
}