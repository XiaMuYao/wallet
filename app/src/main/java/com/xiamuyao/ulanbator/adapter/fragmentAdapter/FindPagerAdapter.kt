package com.xiamuyao.ulanbator.adapter.fragmentAdapter

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.xiamuyao.ulanbator.fragment.FindMessageListFragment

class FindPagerAdapter(
    private var fragmentManager: FragmentManager,
    var titleList: ArrayList<String>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return FindMessageListFragment.newInstance(bundleOf("title" to titleList[position]))
    }

    override fun getCount(): Int {
        return titleList.size
    }

}