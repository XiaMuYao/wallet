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
import com.xiamuyao.ulanbator.databinding.FragmentFindBinding
import com.xiamuyao.ulanbator.viewmodel.FindViewModel
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.databinding.FragmentManagingMoneyBinding
import com.xiamuyao.ulanbator.view.ScaleTransitionPagerTitleView
import com.xiamuyao.ulanbator.viewmodel.ManagingMoneyViewModel
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator


class ManagingMoneyFragment : BaseFragment<FragmentManagingMoneyBinding, ManagingMoneyViewModel>() {
    companion object {
        fun newInstance(bundle: Bundle?): ManagingMoneyFragment {
            val findFragment = ManagingMoneyFragment()
            findFragment.arguments = bundle
            return findFragment
        }
    }


    override fun initView() {
        initMagicIndicator()
        binding.managingViewPager.setSlide(true)
    }

    override fun initVVMObserver() {
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_managing_money
    }

    override fun initVariableId(): Int {
        return BR.managingMoneyViewModel
    }

    override fun initViewModel(): Class<ManagingMoneyViewModel> {
        return ManagingMoneyViewModel::class.java
    }

    private fun initMagicIndicator() {
        binding.managingIndicator.setBackgroundColor(Color.WHITE)
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
                    binding.managingViewPager.currentItem = index
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
        binding.managingIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(binding.managingIndicator, binding.managingViewPager)
        binding.managingViewPager.currentItem = 1

    }


}