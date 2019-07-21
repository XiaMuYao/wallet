package com.xiamuyao.ulanbator.adapter.fragmentAdapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.xiamuyao.ulanbator.fragment.BigPhotoFragment

class ShowPhotoFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    private var imageUrlList: ArrayList<String>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return BigPhotoFragment.newInstance(bundleOf("imageUrl" to imageUrlList[position]))
    }

    override fun getCount(): Int {
        return imageUrlList.size
    }
}