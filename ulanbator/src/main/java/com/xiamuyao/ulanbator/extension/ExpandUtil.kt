package com.xiamuyao.ulanbator.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiamuyao.ulanbator.base.adapter.BaseListAdapter
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.net.BaseResponse
import com.xiamuyao.ulanbator.utlis.LibConstant

/**
 * 通用拓展函数
 */

/**
 * 列表默认 Adapter 和 LayoutManager 设置
 * @receiver RecyclerView
 * @param mAdapter BaseListAdapter<T>
 * @param LayoutManager RecyclerView.LayoutManager?
 */
fun <T> RecyclerView.defaultStyle(
    mAdapter: BaseListAdapter<T>,
    LayoutManager: RecyclerView.LayoutManager? = LinearLayoutManager(context) as RecyclerView.LayoutManager
) {
    this.adapter = mAdapter
    this.layoutManager = LayoutManager
}