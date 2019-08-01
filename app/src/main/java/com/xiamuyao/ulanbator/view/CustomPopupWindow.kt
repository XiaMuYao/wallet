package com.xiamuyao.ulanbator.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.model.bean.PairListBean
import com.xiamuyao.ulanbator.utlis.DataBus


class CustomPopupWindow(var context: Context, var pairList: ObservableArrayList<PairListBean>) : PopupWindow(context) {

    private var mPopView: View? = null

    private val cityListAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_pair, pairList, BR.pairListBean)
    }

    init {
        init(context)
        setPopupWindow()
    }

    private fun init(context: Context) {
        val inflater = LayoutInflater.from(context)
        mPopView = inflater.inflate(R.layout.popup_window_detail, null)
        val viewById = mPopView!!.findViewById<RecyclerView>(R.id.popRecyclerView)

        viewById.adapter = cityListAdapter

        viewById.layoutManager = LinearLayoutManager(context.applicationContext)
        cityListAdapter.setOnItemClickListener { _, _, position ->

            DataBus.postData(EventConstant.SELECT_PAIRNAME, pairList[position].pairName)
            DataBus.postData(EventConstant.SELECT_PAIR_PRICE, pairList[position].pairPrice)

            dismiss()
        }
    }

    /**
     * 设置窗口的相关属性
     */
    @SuppressLint("InlinedApi")
    private fun setPopupWindow() {
        this.contentView = mPopView// 设置View
        this.height = ViewGroup.LayoutParams.WRAP_CONTENT
        this.isFocusable = true// 设置弹出窗口可
        this.isOutsideTouchable = true


//        val a = context as Activity
//        val i = a.windowManager.defaultDisplay.width - convertDpToPx(context, 10)
//        this.width =i
        this.width = ViewGroup.LayoutParams.WRAP_CONTENT

        //        mPopView.setOnTouchListener(new View.OnTouchListener() {// 如果触摸位置在窗口外面则销毁
        //            @Override
        //            public boolean onTouch(View v, MotionEvent event) {
        //                int height = mPopView.findViewById(R.id.id_pop_layout).getTop();
        //                int y = (int) event.getY();
        //                if (event.getAction() == MotionEvent.ACTION_UP) {
        //                    if (y < height) {
        //                        dismiss();
        //                    }
        //                }
        //                return true;
        //            }
        //        });

    }

    fun convertDpToPx(context: Context, dp: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

}