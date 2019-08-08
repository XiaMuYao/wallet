package com.xiamuyao.ulanbator.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.base.adapter.BaseObservableListAdapter
import com.xiamuyao.ulanbator.net.BaseResponse
import com.xiamuyao.ulanbator.net.Status.SUCCESS
import com.xiamuyao.ulanbator.net.Status.SignatureError
import com.xiamuyao.ulanbator.utlis.To

/**
 * 通用拓展函数
 */

/**
 * 列表默认 Adapter 和 LayoutManager 设置
 * @receiver RecyclerView
 * @param mAdapter BaseObservableListAdapter<T>
 * @param LayoutManager RecyclerView.LayoutManager?
 */
fun <T> RecyclerView.defaultStyle(
    mAdapter: BaseObservableListAdapter<T>,
    LayoutManager: RecyclerView.LayoutManager? = LinearLayoutManager(context.applicationContext) as RecyclerView.LayoutManager
) {
    this.adapter = mAdapter
    this.layoutManager = LayoutManager
}


/**
 * 默认下拉刷新和加载更多的方法
 * @receiver SmartRefreshLayout
 * @param LoadMoreBlock Function0<Unit>
 * @param refreshBlock Function0<Unit>
 */
fun SmartRefreshLayout.defaultRefreshLoadMoreFun(
    LoadMoreBlock: (() -> Unit)?,
    refreshBlock: (() -> Unit?)?
) {
    val thatView = this
    //设置是否在没有更多数据之后 Footer 跟随内容
    thatView.setEnableFooterFollowWhenNoMoreData(true)

    if (LoadMoreBlock == null) {
        thatView.setEnableLoadMore(false)
    }
    if (refreshBlock == null) {
        thatView.setEnableRefresh(false)
    }
    thatView.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
        override fun onLoadMore(refreshLayout: RefreshLayout) {
            LoadMoreBlock!!()
        }

        override fun onRefresh(refreshLayout: RefreshLayout) {
            refreshBlock!!()
        }

    })

}


