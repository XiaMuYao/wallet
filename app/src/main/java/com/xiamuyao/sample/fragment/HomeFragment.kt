package com.xiamuyao.sample.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.sample.BR
import com.xiamuyao.sample.databinding.FragmentHomeBinding
import com.xiamuyao.sample.viewmodel.HomeViewModel
import com.xiamuyao.ulanbator.base.BaseFragment
import androidx.databinding.ViewDataBinding
import com.xiamuyao.sample.adapter.fragmentAdapter.SectionsPagerAdapter
import com.xiamuyao.sample.view.ScaleTransitionPagerTitleView
import com.xiamuyao.ulanbator.base.BaseViewModel
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator
import org.jetbrains.anko.custom.style


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    companion object {
        fun newInstance(bundle: Bundle?): HomeFragment {
            val homeFragment = HomeFragment()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    private val mFragmentList: Array<BaseFragment<out ViewDataBinding, out BaseViewModel>> by lazy {
        arrayOf(FollowFragment(), HotFragment())
    }

    private val homeAdapter by lazy {
        SectionsPagerAdapter(fragmentManager!!, mFragmentList)
    }


    override fun initView() {
        binding.homeViewPager.adapter = homeAdapter
        initMagicIndicator()
    }


    override fun initVVMObserver() {

    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return com.xiamuyao.sample.R.layout.fragment_home
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
    }

}