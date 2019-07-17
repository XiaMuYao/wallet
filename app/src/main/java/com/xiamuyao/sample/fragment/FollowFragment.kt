package com.xiamuyao.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xiamuyao.sample.BR
import com.xiamuyao.sample.adapter.HomeItemImageAdapter
import com.xiamuyao.sample.viewmodel.FollowViewModel
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.utlis.LL
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.fragment.app.commit
import com.xiamuyao.sample.R


class FollowFragment : BaseFragment<com.xiamuyao.sample.databinding.FragmentFollowBinding, FollowViewModel>(),
    HomeItemImageAdapter.ItemChildClickListener {

    private val homeItemImageAdapter by lazy {
        HomeItemImageAdapter(R.layout.item_home_card_skirt, viewModel.skirtList)
    }

    override fun onChildClick(childIndex: Int, parentIndex: Int, view: View) {

//        fragmentManager!!.beginTransaction()
//
//            .addSharedElement(
//                view,
//                ViewCompat.getTransitionName(view)!!
//            )
//
//            .addToBackStack(ViewCompat.getTransitionName(view)!!)
//
//            .replace(
//                R.id.mainParentCl,FragmentB.newInstance()
//            )
//
//            .commit();


//         Fragment
        fragmentManager?.commit {
            replace(
                R.id.mainParentCl,
                ImageShowFragment.newInstance(bundleOf("imageUrl" to ViewCompat.getTransitionName(view))),
                ImageShowFragment.javaClass.simpleName + parentIndex
            )
            addSharedElement(view, ViewCompat.getTransitionName(view)!!)
            addToBackStack(ImageShowFragment.javaClass.simpleName + parentIndex)
        }

        // Activity
//        ShowBigImageActivity.start(
//            activity!!, view,
//            bundleOf(
//                "index" to childIndex,
//                "imageList" to viewModel.skirtList[parentIndex].imageList
//            )
//        )


    }

    override fun initVVMObserver() {

    }

    override fun initView() {
        binding.followRecyclerView.defaultStyle(homeItemImageAdapter)
        homeItemImageAdapter.setOnItemChildClickListener { _, view, position ->
            when (view.id) {
                R.id.imageView -> {
                    LL.d("position 转发::$position")
                }
                R.id.imageView2 -> {
                    LL.d("position 评论::$position")
                }
                R.id.TextView -> {
                    LL.d("position 评论数量::$position")
                }
                R.id.imageView3 -> {
                    LL.d("position 点赞::$position")
                }
                R.id.TextView2 -> {
                    LL.d("position 点赞数量::$position")
                }
                R.id.itemSkirtHeadView -> {
                    LL.d("position 头像::$position")
                }
            }
        }
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