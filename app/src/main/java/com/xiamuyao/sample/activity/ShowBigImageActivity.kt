package com.xiamuyao.sample.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.xiamuyao.sample.BR
import com.xiamuyao.sample.R
import com.xiamuyao.sample.adapter.fragmentAdapter.BigImageListFragmentAdapter
import com.xiamuyao.sample.databinding.ActivityBigImageBinding
import com.xiamuyao.sample.viewmodel.ShowBigImageViewModel
import com.xiamuyao.ulanbator.base.BaseActivity

class ShowBigImageActivity : BaseActivity<ActivityBigImageBinding, ShowBigImageViewModel>() {

    private val bigImageListFragmentAdapter by lazy {
        BigImageListFragmentAdapter(
            supportFragmentManager,
            viewModel.imageList
        )
    }

    companion object {
        fun start(context: Context, view: View, bundle: Bundle) {
            val starter = Intent(context, ShowBigImageActivity::class.java)
            val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context as Activity,
                view,
                ViewCompat.getTransitionName(view)!!
            )
            starter.putExtra("message", bundle)
            context.startActivity(starter, optionsCompat.toBundle())
        }
    }


    override fun initView() {
        val bundle = intent.getBundleExtra("message")
        viewModel.index.value = bundle.getInt("index")
        viewModel.imageList.addAll(bundle.getStringArrayList("imageList")!!)

        binding.bigImageViewPager.adapter = bigImageListFragmentAdapter
        binding.bigImageViewPager.offscreenPageLimit = viewModel.imageList.size
    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_big_image
    }

    override fun initVariableId(): Int {
        return BR.showBigImageViewModel
    }

    override fun initViewModel(): Class<ShowBigImageViewModel> {
        return ShowBigImageViewModel::class.java
    }

}