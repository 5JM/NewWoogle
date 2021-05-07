package com.jm5.woogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.jm5.woogle.adapter.FragmentAdapter
import com.jm5.woogle.goodsCategory.*
import kotlinx.android.synthetic.main.activity_star_goods.*

class StarGoodsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_goods)

        val starName : String? = intent.getStringExtra("StarName")
        val starImg : String? = intent.getStringExtra("StarImg")

        initInfo(starName,starImg)

        val fragmentList = listOf(
            WholeFragment(), WearFragment(), FigureFragment(), StationeryFragment(), EtcFragment()
        )

        val adapter = FragmentAdapter(supportFragmentManager,1)
        adapter.fragmentList=fragmentList
        goods_viewpager.adapter=adapter

//        viewpager.setOnTouchListener { p0, p1 -> true }

        goods_category.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.whole -> goods_viewpager.currentItem = 0
                R.id.wear -> goods_viewpager.currentItem = 1
                R.id.figure -> goods_viewpager.currentItem = 2
                R.id.stationery -> goods_viewpager.currentItem = 3
                R.id.etc -> goods_viewpager.currentItem = 4
            }
            true
        }

        goods_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}
            // 네비게이션 메뉴 아이템 체크상태
            override fun onPageSelected(position: Int) {
                goods_category.menu.getItem(position).isChecked=true
            }
        })
    }
    private fun initInfo(name : String?, img:String?){
        star_name.text = name

//        content_category.text = category
//        content_title.text = title
//        content_price.text=price
//        total_name.text=title
//        total_price.text=price
//        count_product.text= 1.toString()
//
////        content_info.setImageResource(R.drawable.annishida)

        Glide.with(this)
            .load(img)
            .centerCrop()
            .error(R.drawable.woogle_logo_02)
            .fallback(R.drawable.woogle_logo_02)
            .into(star_img)

    }

}