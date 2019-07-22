package com.xiamuyao.ulanbator.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.fragmentAdapter.SectionsPagerAdapter
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.databinding.FragmentHomeBinding
import com.xiamuyao.ulanbator.view.ScaleTransitionPagerTitleView
import com.xiamuyao.ulanbator.viewmodel.HomeViewModel
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    companion object {
        fun newInstance(bundle: Bundle?): HomeFragment {
            val homeFragment = HomeFragment()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    private val mFragmentList: Array<BaseFragment<out ViewDataBinding, out BaseViewModel>> by lazy {
        arrayOf(FollowFragment(), RecommendFragment(), TopFragment())
    }

    private val homeAdapter by lazy {
        SectionsPagerAdapter(fragmentManager!!, mFragmentList)
    }


    override fun initView() {
        binding.homeViewPager.adapter = homeAdapter
        binding.homeViewPager.setSlide(true)

        initMagicIndicator()
    }


    override fun initVVMObserver() {

    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_home
    }

    override fun initVariableId(): Int {
        return BR.homeViewModel
    }

    override fun initViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    private fun initMagicIndicator() {
        binding.homeIndicator.setBackgroundColor(Color.WHITE)
        val commonNavigator = CommonNavigator(context)

        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return viewModel.titleList.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val simplePagerTitleView = ScaleTransitionPagerTitleView(context)
                simplePagerTitleView.text = viewModel.titleList[index]
                simplePagerTitleView.textSize = 18f
                simplePagerTitleView.normalColor = Color.GRAY
                simplePagerTitleView.selectedColor = Color.BLACK
                simplePagerTitleView.setOnClickListener {
                    binding.homeViewPager.currentItem = index
                }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = BezierPagerIndicator(context)
                indicator.setColors(
                    Color.parseColor("#ff4a42"),
                    Color.parseColor("#fcde64")
                )
                return indicator
            }
        }
        binding.homeIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(binding.homeIndicator, binding.homeViewPager)
        binding.homeViewPager.currentItem = 1

    }

}