package com.xiamuyao.sample.fragment

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.xiamuyao.sample.R
import com.xiamuyao.sample.viewmodel.ImageShowViewModel
import com.xiamuyao.ulanbator.base.BaseFragment

class ImageShowFragment : BaseFragment<com.xiamuyao.sample.databinding.FragmentImageShowBinding, ImageShowViewModel>() {

    companion object {
        fun newInstance(bundle: Bundle): ImageShowFragment {
            val imageShowFragment = ImageShowFragment()
            imageShowFragment.arguments = bundle
            return imageShowFragment
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
        viewModel.imageUrl.value = arguments?.getString("imageUrl")
//        var tempUrl = arguments?.getString("imageUrl")
        binding.ImageViewImageView.transitionName = viewModel.imageUrl.value

//        Glide.with(this)
//            .load(viewModel.imageUrl.value)
//            .into(binding.ImageViewImageView)

    }

    override fun initVariableId(): Int {
        return BR.imageShowViewModel
    }

    override fun initViewModel(): Class<ImageShowViewModel> {
        return ImageShowViewModel::class.java
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_image_show
    }
}