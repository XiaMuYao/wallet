package com.xiamuyao.ulanbator.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.fragmentAdapter.FindPagerAdapter
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.databinding.FragmentFindBinding
import com.xiamuyao.ulanbator.viewmodel.FindViewModel
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView


class FindFragment : BaseFragment<FragmentFindBinding, FindViewModel>() {

    private val findMessageAdapter by lazy {
        FindPagerAdapter(fragmentManager!!, viewModel.titleList)
    }

    override fun initView() {

        with(binding.homeViewPager) {
            adapter = findMessageAdapter
            offscreenPageLimit = viewModel.titleList.size
            setSlide(true)
        }

        initMagicIndicator()

    }

    override fun initVVMObserver() {
    }

    override fun onResume() {
        super.onResume()
    }
    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_find
    }

    override fun initVariableId(): Int {
        return BR.findViewModel
    }

    override fun initViewModel(): Class<FindViewModel> {
        return FindViewModel::class.java
    }

    private fun initMagicIndicator() {
        val commonNavigator = CommonNavigator(context)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return viewModel.titleList.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val badgePagerTitleView = BadgePagerTitleView(context)

                val simplePagerTitleView = ColorTransitionPagerTitleView(context)
                simplePagerTitleView.setPadding(32, 0, 32, 0)
                simplePagerTitleView.normalColor = Color.parseColor("#FFFFFF")
                simplePagerTitleView.selectedColor = Color.parseColor("#878DA8")
                simplePagerTitleView.text = viewModel.titleList[index]
                simplePagerTitleView.textSize = resources.getDimension(R.dimen.text_size)
                simplePagerTitleView.setOnClickListener { binding.homeViewPager.currentItem = index }
                badgePagerTitleView.innerPagerTitleView = simplePagerTitleView

                return badgePagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val linePagerIndicator = LinePagerIndicator(context)
                linePagerIndicator.setColors(Color.parseColor("#534af5"))
                return linePagerIndicator
            }
        }
        binding.homeIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(binding.homeIndicator, binding.homeViewPager)

    }

    companion object {
        fun newInstance(bundle: Bundle?): FindFragment {
            val findFragment = FindFragment()
            findFragment.arguments = bundle
            return findFragment
        }
    }

}