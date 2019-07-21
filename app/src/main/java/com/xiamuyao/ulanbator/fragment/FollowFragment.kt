package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.ShowPhotoActivity
import com.xiamuyao.ulanbator.adapter.HomeItemImageAdapter
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.FollowViewModel


class FollowFragment : BaseFragment<com.xiamuyao.ulanbator.databinding.FragmentFollowBinding, FollowViewModel>(),
    HomeItemImageAdapter.ItemChildClickListener {

    private var itemImageView:View? = null

    private val homeItemImageAdapter by lazy {
        HomeItemImageAdapter(R.layout.item_home_card_skirt, viewModel.skirtList)
    }

    override fun onChildClick(childIndex: Int, parentIndex: Int, view: View) {
        viewModel.parentIndex = parentIndex

        itemImageView = view

//        val strArray = viewModel.skirtList[parentIndex].imageList.toTypedArray()

//        val constraintLayout = binding.followRecyclerView.layoutManager?.findViewByPosition(viewModel.parentIndex) as ConstraintLayout
//        val recyclerView = constraintLayout.findViewById<RecyclerView>(R.id.recyclerView)

//        Diooto(context)
//            .urls(strArray)
//            .type(DiootoConfig.PHOTO)
//            .immersive(true)
//            .position(childIndex)
//            .views(recyclerView, R.id.item_card_image)
//            .start()

        ShowPhotoActivity.start(
            activity!!,
            viewModel.skirtList[parentIndex].imageList as ArrayList<String>,
            childIndex,
            view as ImageView
        )

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

}