package com.xiamuyao.ulanbator.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.previewlibrary.GPreviewBuilder
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.HomeItemImageAdapter
import com.xiamuyao.ulanbator.viewmodel.FollowViewModel
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.model.bean.UserViewInfo


class FollowFragment : BaseFragment<com.xiamuyao.ulanbator.databinding.FragmentFollowBinding, FollowViewModel>(),
    HomeItemImageAdapter.ItemChildClickListener {

    private val homeItemImageAdapter by lazy {
        HomeItemImageAdapter(R.layout.item_home_card_skirt, viewModel.skirtList)
    }

    override fun onChildClick(childIndex: Int, parentIndex: Int, view: View) {
        val recyclerView  = homeItemImageAdapter.getViewByPosition(binding.followRecyclerView,parentIndex,R.id.recyclerView) as RecyclerView

        val layoutManager  =recyclerView.layoutManager as GridLayoutManager

        computeBoundsBackward(layoutManager.findFirstVisibleItemPosition() ,viewModel.skirtList[parentIndex].imageList,layoutManager)

        GPreviewBuilder.from(this@FollowFragment)
            .setData(viewModel.skirtList[parentIndex].imageList)
            .setCurrentIndex(childIndex)
            .setSingleFling(true)
            .setType(GPreviewBuilder.IndicatorType.Number)
            .start()
    }

    override fun initVVMObserver() {

    }

    override fun initView() {
        binding.followRecyclerView.defaultStyle(homeItemImageAdapter)
        homeItemImageAdapter.mItemChildClickListener = this

    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_follow
    }

    override fun initVariableId(): Int {
        return BR.followViewModel
    }

    override fun initViewModel(): Class<FollowViewModel> {
        return FollowViewModel::class.java
    }

    /**
     * 查找信息
     * 从第一个完整可见item逆序遍历，如果初始位置为0，则不执行方法内循环
     */
    private fun computeBoundsBackward(
        firstCompletelyVisiblePos: Int,
        imageList: List<UserViewInfo>,
        layoutManager: LinearLayoutManager
    ) {
        for (i in firstCompletelyVisiblePos until imageList.size) {
            val itemView = layoutManager.findViewByPosition(i)
            val bounds = Rect()
            if (itemView != null) {
                val thumbView = itemView.findViewById(R.id.item_card_image) as ImageView
                thumbView.getGlobalVisibleRect(bounds)
            }
            imageList[i].setBounds(bounds)
        }
    }
}