package com.xiamuyao.sample.fragment

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.xiamuyao.sample.R
import com.xiamuyao.sample.viewmodel.BigImageViewModel
import com.xiamuyao.ulanbator.base.BaseFragment

class BigImageFragment : BaseFragment<com.xiamuyao.sample.databinding.FragmentBigImageBinding, BigImageViewModel>() {

    companion object {
        fun newInstance(bundle: Bundle?): BigImageFragment {
            val bigImageFragment = BigImageFragment()
            bigImageFragment.arguments = bundle
            return bigImageFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        }
    }

    override fun initVVMObserver() {

    }

    override fun initView() {

        var tempUrl = arguments?.getString("imageUrl")
        Glide.with(activity!!).load(tempUrl).into(binding.ImageViewImageView)
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_big_image
    }

    override fun initVariableId(): Int {
        return BR.bigImageViewModel
    }

    override fun initViewModel(): Class<BigImageViewModel> {
        return BigImageViewModel::class.java
    }

}
