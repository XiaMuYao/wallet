package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.LinearLayoutManager
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.HomeItemImageAdapter
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.FragmentRecommendBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.RecommendViewModel


class RecommendFragment : BaseFragment<FragmentRecommendBinding, RecommendViewModel>() {

    private val hotAdapter by lazy {
        BaseNoChildClickAdapter(R.layout.item_hot_community, viewModel.hotCommunity, BR.hotCommunityBean)
    }
    private val topMessageAdapter by lazy {
        BaseNoChildClickAdapter(R.layout.item_top_message, viewModel.topMessage, BR.topMessageBean)
    }

    private val listMessageAdapter by lazy {
        HomeItemImageAdapter(R.layout.item_home_card_skirt, viewModel.skirtList)
    }

    override fun initVVMObserver() {

    }

    override fun initView() {
        binding.hotRecyclerView.defaultStyle(hotAdapter, LinearLayoutManager(context, LinearLayout.HORIZONTAL, false))
        binding.topMessageRecyclerView.defaultStyle(topMessageAdapter)
        binding.listMessageRecyclerView.defaultStyle(listMessageAdapter)
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_recommend
    }

    override fun initVariableId(): Int {
        return BR.recommendViewModel
    }

    override fun initViewModel(): Class<RecommendViewModel> {
        return RecommendViewModel::class.java
    }

    //<editor-fold desc="页面指示器">
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
    //</editor-fold>

}
