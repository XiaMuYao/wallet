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
abstract class BaseObservableListAdapter<T>(layout: Int, data: ObservableArrayList<T>?): BaseQuickAdapter<T, BaseObservableListAdapter.ListViewHolder>(layout,data) {


    override fun getItemView(layoutResId: Int, parent: ViewGroup): View {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, layoutResId, parent, false)
            ?: return super.getItemView(layoutResId, parent)
        val view = binding.root
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding)
        return view
    }

    class ListViewHolder(view: View) : BaseViewHolder(view) {

        val binding: ViewDataBinding
            get() = itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as ViewDataBinding
    }

    init {
        data?.addOnListChangedCallback(object :
            ObservableList.OnListChangedCallback<ObservableList<String>>() {
            override fun onChanged(sender: ObservableList<String>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeRemoved(
                sender: ObservableList<String>?,
                positionStart: Int,
                itemCount: Int
            ) {
                if (sender!!.isEmpty()) {
                    notifyDataSetChanged()
                } else {
                    notifyItemRangeRemoved(positionStart, itemCount)
                }
            }

            override fun onItemRangeMoved(
                sender: ObservableList<String>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onItemRangeInserted(
                sender: ObservableList<String>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onItemRangeChanged(
                sender: ObservableList<String>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemRangeChanged(positionStart, itemCount)
            }

        })
    }
}