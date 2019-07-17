package com.xiamuyao.ulanbator.base.adapter

import androidx.databinding.ObservableArrayList

/**
 * 不需要子控件点击使用这个
 * @param T
 * @property brId Int
 * @constructor
 */
class BaseNoChildClickAdapter<T>(layout: Int, data: ObservableArrayList<T>, var brId: Int) :
    BaseListAdapter<T>(layout, data) {
    override fun convert(helper: ListViewHolder?, item: T) {
        helper?.let {
            with(it) {
                binding.setVariable(brId, item)
                binding.executePendingBindings()
            }
        }
    }
}