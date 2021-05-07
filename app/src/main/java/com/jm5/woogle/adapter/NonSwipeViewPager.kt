package com.jm5.woogle.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class NonSwipeViewPager: ViewPager{
    private var enabledT : Boolean = false
    constructor(context: Context) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!,
        attrs
    )
    fun setPagingEnabled(enabled: Boolean) {
        this.enabledT = enabled
    }
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (this.enabledT) {
            return super.onTouchEvent(ev);
        }

        return false;
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (this.enabledT) {
            return super.onInterceptTouchEvent(ev);
        }

        return false;
    }
}