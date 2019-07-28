package com.xiamuyao.ulanbator.view

import android.content.Context
import android.util.AttributeSet
import android.widget.VideoView


class CustomVideoView : VideoView {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    protected override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //我们重新计算高度(这样就可以匹配不同手机的尺寸)
        val width = getDefaultSize(0, widthMeasureSpec)
        val height = getDefaultSize(0, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
}