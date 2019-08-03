package com.xiamuyao.ulanbator.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.AccountDetailsActivity
import com.xiamuyao.ulanbator.adapter.fragmentAdapter.SectionsPagerAdapter
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.databinding.FragmentManagingMoneyBinding
import com.xiamuyao.ulanbator.view.ScaleTransitionPagerTitleView
import com.xiamuyao.ulanbator.viewmodel.ManagingMoneyViewModel
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator


class ManagingMoneyFragment : BaseFragment<FragmentManagingMoneyBinding, ManagingMoneyViewModel>() {

    private val mFragmentList: Array<BaseFragment<out ViewDataBinding, out BaseViewModel>> by lazy {
        arrayOf(
            ContractFragmentFragment.newInstance(null),
            FixedDepositFragmentFragment.newInstance(null)
        )
    }

    private val managingMoneyAdapter by lazy {
        SectionsPagerAdapter(fragmentManager!!, mFragmentList)
    }

    override fun initView() {
        initMagicIndicator()
        binding.managingViewPager.setSlide(true)
        binding.managingViewPager.adapter = managingMoneyAdapter
        binding.view.setOnClickListener {
            AccountDetailsActivity.start(context!!)
        }
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
        binding.managingIndicator.setBackgroundResource(R.drawable.round_indicator_bg)
        val commonNavigator = CommonNavigator(context)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return viewModel.titleList.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val clipPagerTitleView = ScaleTransitionPagerTitleView(context)
                clipPagerTitleView.text = viewModel.titleList[index]
                clipPagerTitleView.setPadding(117, 0, 117, 0)
                clipPagerTitleView.normalColor = Color.parseColor("#FFFFFF")
                clipPagerTitleView.selectedColor = Color.parseColor("#878DA8")
                clipPagerTitleView.setOnClickListener { binding.managingViewPager.currentItem = index }
                return clipPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = LinePagerIndicator(context)
                val navigatorHeight = context.resources.getDimension(R.dimen.common_navigator_height)
                val borderWidth = UIUtil.dip2px(context, 1.0).toFloat()
                val lineHeight = navigatorHeight - 2 * borderWidth
                indicator.lineHeight = lineHeight
                indicator.yOffset = borderWidth
                indicator.setColors(Color.parseColor("#282633"))
                indicator.roundRadius = context.resources.getDimension(R.dimen.common_navigator_roundRadius)
                return indicator
            }
        }
        binding.managingIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(binding.managingIndicator, binding.managingViewPager)

    }

    companion object {
        fun newInstance(bundle: Bundle?): ManagingMoneyFragment {
            val findFragment = ManagingMoneyFragment()
            findFragment.arguments = bundle
            return findFragment
        }
    }

}