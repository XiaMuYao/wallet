package com.xiamuyao.sample.adapter.fragmentAdapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.xiamuyao.sample.fragment.BigImageFragment

class BigImageListFragmentAdapter(
    private var fragmentManager: FragmentManager,
    private var fragmentTitleList: List<String>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return BigImageFragment.newInstance(bundleOf("imageUrl" to fragmentTitleList[position]))
    }

    override fun getCount(): Int {
        return fragmentTitleList.size
    }
}