package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.gyf.immersionbar.ImmersionBar
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.fragmentAdapter.ShowPhotoFragmentPagerAdapter
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityShowPhotoBinding
import com.xiamuyao.ulanbator.viewmodel.ShowPhotoViewModel

class ShowPhotoActivity : BaseActivity<ActivityShowPhotoBinding, ShowPhotoViewModel>() {

    private val showPhotoFragmentPagerAdapter by lazy {
        ShowPhotoFragmentPagerAdapter(supportFragmentManager, viewModel.imageList)
    }

    companion object {
        fun start(
            context: Activity,
            imageList: ArrayList<String>,
            imageIndex: Int,
            imageView: ImageView
        ) {
            val starter = Intent(context, ShowPhotoActivity::class.java)
            starter.putStringArrayListExtra("imageList", imageList)
            starter.putExtra("imageIndex", imageIndex)

//            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context, imageView, imageList[imageIndex])
//            context.startActivity(starter, options.toBundle())
            context.startActivity(starter)
        }
    }


    override fun initParam() {
        super.initParam()

//        暂停共享元素
//        postponeEnterTransition()

        intent.let {
            viewModel.imageList = it.getStringArrayListExtra("imageList")
            viewModel.imageIndex.value = it.getIntExtra("imageIndex", -1)
        }
    }


    override fun initView() {
        with(binding.showPhotoViewPager) {
            adapter = showPhotoFragmentPagerAdapter
            currentItem = viewModel.imageIndex.value!!
        }
        binding.showPhotoViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                viewModel.imageIndex.value = position
            }

        })
    }

    override fun initVVMObserver() {
    }

    override fun setImmersionBar() {
        ImmersionBar.with(this)
            .fitsSystemWindows(true)
            .init()
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_show_photo
    }

    override fun initVariableId(): Int {
        return BR.showPhotoViewModel
    }

    override fun initViewModel(): Class<ShowPhotoViewModel> {
        return ShowPhotoViewModel::class.java
    }

}