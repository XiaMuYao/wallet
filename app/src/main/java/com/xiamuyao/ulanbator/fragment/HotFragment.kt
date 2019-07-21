package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.viewmodel.HotViewModel

class HotFragment : BaseFragment<com.xiamuyao.ulanbator.databinding.FragmentHotBinding, HotViewModel>() {

//    private val hotAdapter by lazy {
//        ListFragmentPagerAdapter(
//            fragmentManager!!,
//            viewModel.hotPageFragmentTitle
//        )
//    }

    override fun initVVMObserver() {

    }

    override fun initView() {
//        binding.hotViewPager.adapter = hotAdapter
//        initMagicIndicator()
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_hot
    }

    override fun initVariableId(): Int {
        return BR.hotViewModel
    }

    override fun initViewModel(): Class<HotViewModel> {
        return HotViewModel::class.java
    }

//    private fun initMagicIndicator() {
//        binding.hotIndicator.setBackgroundColor(Color.WHITE)
//        val commonNavigator = CommonNavigator(context)
//
//        commonNavigator.adapter = object : CommonNavigatorAdapter() {
//            override fun getCount(): Int {
//                return viewModel.hotPageFragmentTitle.size
//            }
//
//            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
//                val simplePagerTitleView = ScaleTransitionPagerTitleView(context)
//                simplePagerTitleView.text = viewModel.hotPageFragmentTitle[index]
//                simplePagerTitleView.textSize = 18f
//                simplePagerTitleView.normalColor = Color.GRAY
//                simplePagerTitleView.selectedColor = Color.BLACK
//                simplePagerTitleView.setOnClickListener {
//                    binding.hotViewPager.setCurrentItem(index)
//                }
//                return simplePagerTitleView
//            }
//
//            override fun getIndicator(context: Context): IPagerIndicator {
//                val indicator = BezierPagerIndicator(context)
//                indicator.setColors(
//                    Color.parseColor("#ff4a42"),
//                    Color.parseColor("#fcde64")
//                )
//                return indicator
//            }
//        }
//        binding.hotIndicator.navigator = commonNavigator
//        ViewPagerHelper.bind(binding.hotIndicator, binding.hotViewPager)
//    }


}
