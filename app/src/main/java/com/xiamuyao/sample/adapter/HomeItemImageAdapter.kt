package com.xiamuyao.sample.adapter

import android.view.View
import androidx.databinding.ObservableArrayList
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiamuyao.sample.App
import com.xiamuyao.sample.R
import com.xiamuyao.sample.model.bean.SkirtListBean
import com.xiamuyao.ulanbator.base.adapter.BaseListAdapter
import com.xiamuyao.ulanbator.base.adapter.BaseNoChildClickAdapter
import com.xiamuyao.ulanbator.extension.defaultStyle


/**
 * 首页item
 */
class HomeItemImageAdapter(layout: Int, data: ObservableArrayList<SkirtListBean>) :
    BaseListAdapter<SkirtListBean>(layout, data) {

    interface ItemChildClickListener {
        fun onChildClick(childIndex: Int, parentIndex: Int, view: View)
    }

    var mItemChildClickListener: ItemChildClickListener? = null

    override fun convert(helper: ListViewHolder?, item: SkirtListBean) {
        helper?.let {


            val nineImageAdapter = BaseNoChildClickAdapter(
                R.layout.item_card_item_image,
                item.imageList as ObservableArrayList<String>,
                BR.itemImageUrl
            )

            val itemNineRv = it.itemView.findViewById<RecyclerView>(R.id.recyclerView)

            itemNineRv.defaultStyle(nineImageAdapter, GridLayoutManager(App.CONTEXT, 3))

            nineImageAdapter.setOnItemClickListener { _, view, childIndex ->
                mItemChildClickListener?.onChildClick(
                    childIndex,
                    it.layoutPosition,
                    view.findViewById(R.id.item_card_image)
                )
            }

            it.addOnClickListener(R.id.imageView)
            it.addOnClickListener(R.id.imageView2)
            it.addOnClickListener(R.id.TextView)
            it.addOnClickListener(R.id.imageView3)
            it.addOnClickListener(R.id.TextView2)

            it.addOnClickListener(R.id.itemSkirtHeadView)


            it.binding.setVariable(BR.itemSkirtListBean, item)
            it.binding.executePendingBindings()

        }
    }

}