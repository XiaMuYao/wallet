package com.xiamuyao.sample.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.sample.R
import com.xiamuyao.ulanbator.base.BaseViewModel

class MainViewModel(application: Application) : BaseViewModel(application) {

    //底部点击菜单控件List
    var bottomClickIdList = arrayListOf(
        R.id.mainBottomTabOne,
        R.id.mainBottomTabTwo,
        R.id.mainBottomTabThere,
        R.id.mainBottomTabFour
    )

    //底部菜单ImageView控件List
    var bottomClickImageIdList = arrayListOf(
        R.id.bottom_tab_iv_one,
        R.id.bottom_tab_iv_two,
        R.id.bottom_tab_iv_there,
        R.id.bottom_tab_iv_four
    )

    var fragmentIndex = MutableLiveData<Int>()

    init {
        fragmentIndex.value = 0
    }

    override  fun initData() {

    }

    /**
     * 更改ViewPager下标
     * @param index Int
     */
    fun setViewPagerIndex(index: Int) {
        fragmentIndex.value = index
    }


}