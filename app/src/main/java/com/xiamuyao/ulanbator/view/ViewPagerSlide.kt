package com.xiamuyao.ulanbator.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class ViewPagerSlide : ViewPager {
    //是否可以进行滑动
    private var isSlide = false

    fun setSlide(slide: Boolean) {
        isSlide = slide
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (!isSlide) {
            false
        } else {
            super.onTouchEvent(ev)
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return if (!isSlide) {
            false
        } else {
            super.onInterceptTouchEvent(ev)
        }
    }
}