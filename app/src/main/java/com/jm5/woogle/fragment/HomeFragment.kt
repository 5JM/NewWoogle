package com.jm5.woogle.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.aqoong.lib.slidephotoviewer.SlidePhotoViewer
import com.jm5.woogle.data.Ad_lists
import com.jm5.woogle.data.Contents_list
import com.jm5.woogle.R
import com.jm5.woogle.adapter.AdAdapter
import com.jm5.woogle.adapter.FragmentAdapter
import com.jm5.woogle.contentsFragment.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    var list = ArrayList<Ad_lists>()
    var contents_list = ArrayList<Contents_list>()
    val fragmentList = listOf(
       Content1Fragment(), Content2Fragment(), Content3Fragment(), Content4Fragment()
     , Content5Fragment()
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val context = view.context

        updateList()

        val mSliderView = view.findViewById<SlidePhotoViewer>(R.id.slideViewer)
        mSliderView.setSidePreview(false)
        mSliderView.addResource(R.drawable.add_1,null)
        mSliderView.addResource(R.drawable.add_2,null)
        mSliderView.addResource(R.drawable.add_3,null)

//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
//        val layoutManager = LinearLayoutManager(context)
//        recyclerView.layoutManager = layoutManager.also { it.orientation = LinearLayoutManager.HORIZONTAL }
//        val adapter = AdAdapter(context, list)
//        recyclerView.adapter = adapter

        val fradapter = FragmentAdapter(childFragmentManager,1)
        fradapter.fragmentList=fragmentList

        val viewpager = view.findViewById<ViewPager>(R.id.contents_viewpager)
        viewpager.adapter=fradapter

        //스무스하게 스크롤되는게 아닌 한페이지씩 스크롤이 가능하게 만들어줌
//        val snapHelper = PagerSnapHelper()
//        snapHelper.attachToRecyclerView(recyclerView)


        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                category.menu.getItem(position).isChecked=true
                category.setOnNavigationItemSelectedListener {
                    when(it.itemId){
                        R.id.category_all -> viewpager.currentItem = 0
                        R.id.category_bts -> viewpager.currentItem = 1
                        R.id.category_exo -> viewpager.currentItem = 2
                        R.id.category_blackpink -> viewpager.currentItem = 3
                        R.id.category_twice -> viewpager.currentItem = 4
                    }
                    true
                }

            }
        })

        return view
    }

    fun updateList(){
        list.clear()
        list.add(Ad_lists("https://pbs.twimg.com/media/DcLynh4VMAILaTU.jpg"))
        list.add(Ad_lists("https://images.unsplash.com/photo-1542488246-1390a9a99a30?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"))
        list.add(Ad_lists("https://images.unsplash.com/photo-1513639776629-7b61b0ac49cb?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1047&q=80"))

        contents_list.clear()
        contents_list.add(
            Contents_list(
                "https://sgimage.netmarble.com/mobile/game/btsw/brand/common/img/og-home.jpg",
                "방탄소년단", "방탄소년단 정국 핸드메이드", "1,200,900"
            )
        )

        contents_list.add(
            Contents_list(
                "https://sgimage.netmarble.com/mobile/game/btsw/brand/common/img/og-home.jpg",
                "방탄소년단", "방탄소년단 정국 핸드메이드", "1,200,900"
            )
        )

        contents_list.add(
            Contents_list(
                "https://sgimage.netmarble.com/mobile/game/btsw/brand/common/img/og-home.jpg",
                "방탄소년단", "방탄소년단 정국 핸드메이드", "1,200,900"
            )
        )
        contents_list.add(
            Contents_list(
                "https://sgimage.netmarble.com/mobile/game/btsw/brand/common/img/og-home.jpg",
                "방탄소년단", "방탄소년단 정국 핸드메이드", "1,200,900"
            )
        )
        contents_list.add(
            Contents_list(
                "https://sgimage.netmarble.com/mobile/game/btsw/brand/common/img/og-home.jpg",
                "방탄소년단", "방탄소년단 정국 핸드메이드", "1,200,900"
            )
        )
        contents_list.add(
            Contents_list(
                "https://sgimage.netmarble.com/mobile/game/btsw/brand/common/img/og-home.jpg",
                "방탄소년단", "방탄소년단 정국 핸드메이드", "1,200,900"
            )
        )
    }
}