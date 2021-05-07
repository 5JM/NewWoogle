package com.jm5.woogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_item.*
import java.text.DecimalFormat

class DetailItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_item)

//        intent.putExtra("itemImg",item.img)
//        intent.putExtra("itemCategory",item.category)
//        intent.putExtra("itemTitle",item.title)
//        intent.putExtra("itemPrice",item.price)

        val category : String? = intent.getStringExtra("itemCategory")
        val title : String? = intent.getStringExtra("itemTitle")
        val img : String? = intent.getStringExtra("itemImg")
        val prePrice : String? = intent.getStringExtra("itemPrice")
        val arr = prePrice?.split(',')
        var test = ""
        if (arr != null) {
            for( i in arr) test = test.plus(i)
        }
        Log.e("textTest?>?", test)
        val price = test

        var total_count:Int =1
        var whole_price:Int

        initInfo(category,title, img, prePrice)

        var isUp = false
        val translateup: Animation =
            AnimationUtils.loadAnimation(applicationContext, R.anim.translate_up)
        val translatedown: Animation =
            AnimationUtils.loadAnimation(applicationContext, R.anim.translate_down)

        //슬라이딩 메뉴의 장바구니 버튼
        content_cart.setOnClickListener {

        }
        //슬라이딩 메뉴의 주문하기 버튼
//        content_order.setOnClickListener {
//            startActivity(Intent(this@ContentActivity,OrderActivity::class.java))
//        }

        //slidingPage 이 외의 영역 터치시 slidingpage 내림
        whole_view.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                if (isUp == true){
                    sliding_page.startAnimation(translatedown)
                    sliding_page.visibility= View.GONE
                    bot_button.visibility= View.VISIBLE
                    bot_button.startAnimation(translateup)
                    isUp = false
                }
                return false
            }
        })
        scrollview.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                if(p1?.action== MotionEvent.ACTION_DOWN) {
                    if (isUp == true){
                        sliding_page.startAnimation(translatedown)
                        sliding_page.visibility= View.GONE
                        bot_button.visibility= View.VISIBLE
                        bot_button.startAnimation(translateup)
                        isUp = false
                    }
                }
                return false
            }
        })

//        back_bot.setOnClickListener {
//            onBackPressed()
//        }
//        back_top.setOnClickListener {
//            onBackPressed()
//        }

        up_order.setOnClickListener {
            isUp = true
            bot_button.startAnimation(translatedown)
            bot_button.visibility= View.GONE
            sliding_page.visibility= View.VISIBLE
            //뒷 레이아웃 터치를 막음
            sliding_page.isClickable=true
            sliding_page.startAnimation(translateup)
        }
        plus_button.setOnClickListener {
            count_product.text=(++total_count).toString()
            val dec = DecimalFormat("#,###")
            whole_price=total_count*price.toInt()
            total_price.text= dec.format(whole_price)
        }
        min_button.setOnClickListener {
            if(total_count<=0) whole_price=0
            else{
                count_product.text=(--total_count).toString()
                val dec = DecimalFormat("#,###")
                whole_price=total_count*price!!.toInt()
                total_price.text=dec.format(whole_price)
            }
        }

    }
    fun initInfo(category : String?, title:String?,img:String?, price:String?){

        content_category.text = category
        content_title.text = title
        content_price.text=price
        total_name.text=title
        total_price.text=price
        count_product.text= 1.toString()

//        content_info.setImageResource(R.drawable.annishida)

        val url = img
        Glide.with(this)
            .load(url)
            .centerCrop()
            .error(R.drawable.woogle_logo_02)
            .fallback(R.drawable.woogle_logo_02)
            .into(content_img)

    }
}