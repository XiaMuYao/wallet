package com.xiamuyao.ulanbator.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xiamuyao.ulanbator.R


/**
 * 基本增删的Adapter 其他自定义Adapter可继承
 * @param T
 * @constructor
 */
abstract class BaseListAdapter<T>(layout: Int, data: MutableList<T>?) :
    BaseQuickAdapter<T, BaseListAdapter.ListViewHolder>(layout, data) {


    override fun getItemView(layoutResId: Int, parent: ViewGroup): View {
        val binding: ViewDataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, layoutResId, parent, false)
                ?: return super.getItemView(layoutResId, parent)
        val view = binding.root
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding)
        return view
    }

    class ListViewHolder(view: View) : BaseViewHolder(view) {

        val binding: ViewDataBinding
            get() = itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as ViewDataBinding
    }


}