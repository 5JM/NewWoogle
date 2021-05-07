package com.jm5.woogle.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.aqoong.lib.slidephotoviewer.SlidePhotoViewer
import com.jm5.woogle.*
import com.jm5.woogle.adapter.*
import com.jm5.woogle.main_goods_list.LastestViewFragment
import com.jm5.woogle.main_goods_list.NewGoodsFragment
import com.jm5.woogle.main_goods_list.PopularFragment
import com.jm5.woogle.main_goods_list.RecommandGoodsFragment
import kotlinx.android.synthetic.main.fragment_mall.*

class MallFragment : Fragment() {
    var category_list = ArrayList<MallCategotyitems>()
    val fragmentList = listOf(
        PopularFragment(), RecommandGoodsFragment(), LastestViewFragment(), NewGoodsFragment()
    )
//    val fragmentList = listOf(
//        Content1Fragment(), Content2Fragment(), Content3Fragment(), Content4Fragment()
//        , Content5Fragment()
//    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mall, container, false)
        val context = view.context

        updateCategoryList()

        val mSliderView = view.findViewById<SlidePhotoViewer>(R.id.slideViewer)
        mSliderView.setSidePreview(false)
        mSliderView.addResource(R.drawable.add_1,null)
        mSliderView.addResource(R.drawable.add_2,null)
        mSliderView.addResource(R.drawable.add_3,null)

        val recyclerView = view.findViewById<RecyclerView>(R.id.mall_category_recyclerview)
        val layoutInflater = GridLayoutManager(context,4)
        recyclerView.layoutManager = layoutInflater
        val adapter = MallCategoryAdapter(context,category_list)
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(HorizontalItemDecorator(20))

        adapter.setItemListener(object  : OnItemClickListener{
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
                val item = adapter.getItem(position)
                 Log.e("testTT","${item.tag}")
                val intent = Intent(context, StarGoodsActivity::class.java)
                intent.putExtra("StarImg",item.img)
                intent.putExtra("StarName",item.tag)
                startActivity(intent)
         }

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
            }
    })
        val fradapter = FragmentAdapter(childFragmentManager,1)
        fradapter.fragmentList=fragmentList

        val viewpager = view.findViewById<ViewPager>(R.id.mall_contents_viewpager)
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
                mall_category.setOnNavigationItemSelectedListener {
                    when(it.itemId){
                        R.id.popular -> viewpager.currentItem = 0
                        R.id.recommand -> viewpager.currentItem = 1
                        R.id.lastestView -> viewpager.currentItem = 2
                        R.id.newGoods -> viewpager.currentItem = 3
                    }
                    true
                }
                mall_category.menu.getItem(position).isChecked=true

            }
        })
        return view
    }

    fun updateCategoryList(){
        category_list.clear()
        category_list.add(MallCategotyitems("https://w7.pngwing.com/pngs/988/843/png-transparent-exo-k-pop-s-m-entertainment-the-eve-sm-town-exo-logo-angle-triangle-logo.png", "EXO"))
        category_list.add(MallCategotyitems("https://upload.wikimedia.org/wikipedia/commons/6/60/TWICE_LOGO.png", "TWICE"))
        category_list.add(MallCategotyitems("https://i.pinimg.com/originals/07/e1/e1/07e1e1db708aedc253b02043268604d6.png", "블랙핑크"))
        category_list.add(MallCategotyitems("https://banner2.cleanpng.com/20180810/iko/kisspng-bts-logo-k-pop-design-image-bts-sticker-by-edits-from-bts-5b6db8d63608a8.0043534515339173982213.jpg", "방탄소년단"))
        category_list.add(MallCategotyitems("https://www.flaticon.com/svg/vstatic/svg/175/175613.svg?token=exp=1618141891~hmac=4b7ee413f3c445e6c2945e01b09b5cb8", "스타명"))
        category_list.add(MallCategotyitems("https://www.flaticon.com/svg/vstatic/svg/2357/2357406.svg?token=exp=1618141924~hmac=9743c055552fae25512992466e2181f9", "스타명"))
        category_list.add(MallCategotyitems("https://www.flaticon.com/svg/vstatic/svg/1161/1161469.svg?token=exp=1618141995~hmac=44162924a748dfd5c69ef0822a50980f", "스타명"))
        category_list.add(MallCategotyitems("https://www.flaticon.com/svg/vstatic/svg/633/633684.svg?token=exp=1618142026~hmac=6c0e21b8229691b765868601779255c2", "스타명"))
        }
}