package com.xiamuyao.ulanbator.base.adapter

/**
 * 不需要子控件点击使用这个
 * @param T
 * @property brId Int
 * @constructor
 */
class BaseNormalNoChildClickListAdapter<T>(layout: Int, data: MutableList<T>?, var brId: Int) :
    BaseNormalListAdapter<T>(layout, data) {
    override fun convert(helper: ListViewHolder?, item: T?) {
        helper?.let {
            with(it) {
                binding.setVariable(brId, item)
                binding.executePendingBindings()
            }
        }
    }
}