package com.xiamuyao.ulanbator.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xiamuyao.ulanbator.App

class SpaceItemDecoration : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
//        var space = 30
//        var column = 3
        val position = parent.getChildAdapterPosition(view)
        when (position) {
            0 -> {
                outRect.right = dpToPx(5)
            }
            1 -> {
                outRect.left = dpToPx(5)
                outRect.right = dpToPx(5)
            }
            2 -> {
                outRect.left = dpToPx(5)
            }

            3 -> {
                outRect.right = dpToPx(5)
            }
            4 -> {
                outRect.left = dpToPx(5)
                outRect.right = dpToPx(5)
            }
            5 -> {
                outRect.left = dpToPx(5)
            }
        }
        // 每个span分配的间隔大小
//        val spanSpace = space * (column + 1) / column
//        // 列索引
//        val colIndex = position % column
//        // 列左、右间隙
//        outRect.left = space * (colIndex + 1) - spanSpace * colIndex
//        outRect.right = spanSpace * (colIndex + 1) - space * (colIndex + 1)
//        // 行间距
//        if (position >= column) {
//            outRect.top = space
//        }
    }

    private fun dpToPx(dp: Int): Int {
        val density = App.CONTEXT.resources.displayMetrics.density
        return (dp * density + 0.5f * if (dp >= 0) 1 else -1).toInt()
    }

}