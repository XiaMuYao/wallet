package com.xiamuyao.ulanbator.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.databinding.FragmentBigPhotoBinding
import com.xiamuyao.ulanbator.utlis.LL
import com.xiamuyao.ulanbator.viewmodel.BigPhotoViewModel


class BigPhotoFragment : BaseFragment<FragmentBigPhotoBinding, BigPhotoViewModel>() {
    companion object {
        fun newInstance(bundle: Bundle?): BigPhotoFragment {
            val findFragment = BigPhotoFragment()
            findFragment.arguments = bundle
            return findFragment
        }
    }

    override fun initView() {

        arguments?.let {
            viewModel.imageUrl.value = it.getString("imageUrl")
        }

        Glide.with(this)
            .load(viewModel.imageUrl.value)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    // 可替换成进度条
                    Toast.makeText(context, "图片加载失败", Toast.LENGTH_SHORT).show();
                    return false;
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
//                    activity?.startPostponedEnterTransition()
                    LL.d("加载完成")
                    // 图片加载完成，取消进度条
                    Toast.makeText(context, "图片加载成功", Toast.LENGTH_SHORT).show();
                    return false
                }

            })
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(binding.bigShowImage)

    }

    override fun initVVMObserver() {
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_big_photo
    }

    override fun initVariableId(): Int {
        return BR.bigPhotoViewModel
    }

    override fun initViewModel(): Class<BigPhotoViewModel> {
        return BigPhotoViewModel::class.java
    }

}