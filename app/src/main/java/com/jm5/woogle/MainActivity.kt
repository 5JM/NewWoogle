package com.jm5.woogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.jm5.woogle.adapter.FragmentAdapter
import com.jm5.woogle.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var backPressedTime : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addFragment = AddFragment()

        val fragmentList = listOf(
            MallFragment(),HomeFragment(), addFragment,MessageFragment(), MypageFragment()
        )

        plusBtn.bringToFront()
        plusBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddProductActivity::class.java))
//            val fragmentTransaction = supportFragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.viewpager, addFragment)
//            fragmentTransaction.commit()
        }

        val adapter = FragmentAdapter(supportFragmentManager,1)
        adapter.fragmentList=fragmentList
        viewpager.adapter=adapter
        viewpager.setPagingEnabled(false)
//        viewpager.setOnTouchListener { p0, p1 -> true }

        bottomnavi.setOnNavigationItemSelectedListener {
            when(it.itemId){
                // itemId에 따라 viewPager 바뀜
                R.id.menu_home -> viewpager.currentItem = 1
                R.id.menu_mall -> viewpager.currentItem = 0
//                R.id.menu_add -> viewpager.currentItem = 2
                R.id.menu_message -> viewpager.currentItem = 3
                R.id.menu_mypage -> viewpager.currentItem = 4
            }

            true
        }

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            var frontFlag = false
            var backFlag = false
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}
            // 네비게이션 메뉴 아이템 체크상태
            override fun onPageSelected(position: Int) {

                if(position==0){
                    backFlag = false
                    frontFlag = false
                    toolbar_title.text="woogle"
                    Log.e("test?>>","${position}  front=${frontFlag}, back = ${backFlag}")
                    bottomnavi.menu.getItem(position).isChecked=true
                }
                if(position==1){
                    toolbar_title.text="굿즈몰"
                    backFlag = false
                    frontFlag = true
                    Log.e("test?>>","${position}  front=${frontFlag}, back = ${backFlag}")
                    bottomnavi.menu.getItem(position).isChecked=true
                }
                if(position==2){
                    bottomnavi.menu.getItem(position).isChecked=false
                    if(frontFlag)  {
                        frontFlag=false
                        viewpager.setCurrentItem(1,true)
                    }
                    if(backFlag)  {
                        backFlag = false
                        viewpager.setCurrentItem(3,true)
                    }
                    Log.e("test?>>","${position}  front=${frontFlag}, back = ${backFlag}")

                }
                if(position==3){
                    toolbar_title.text="message"
                    frontFlag = false
                    backFlag = true
                    Log.e("test?>>","${position}  front=${frontFlag}, back = ${backFlag}")
                    bottomnavi.menu.getItem(position).isChecked=true
                }
                if(position==4){
                    backFlag = false
                    frontFlag = false
                    toolbar_title.text="MY"
                    Log.e("test?>>","${position}  front=${frontFlag}, back = ${backFlag}")
                    bottomnavi.menu.getItem(position).isChecked=true
                }


            }
        })
    }
    //뒤로가기 두번 누를 시 종료
    override fun onBackPressed() {
        if(System.currentTimeMillis()>backPressedTime+2000){
            backPressedTime=System.currentTimeMillis()
            Toast.makeText(this,"뒤로가기 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
            return
        }else{
            moveTaskToBack(true)// 태스크를 백그라운드로 이동
            finishAndRemoveTask()// 액티비티 종료 + 태스크 리스트에서 지우기
            android.os.Process.killProcess(android.os.Process.myPid())// 앱 프로세스 종료
        }
    }
}