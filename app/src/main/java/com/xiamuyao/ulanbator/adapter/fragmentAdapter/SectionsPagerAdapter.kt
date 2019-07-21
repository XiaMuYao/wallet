package com.xiamuyao.ulanbator.adapter.fragmentAdapter

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.BaseViewModel
import kotlinx.android.synthetic.main.fragment_find.view.*

class SectionsPagerAdapter(
    private var fragmentManager: FragmentManager,
    private var mFragmentList: Array<BaseFragment<out ViewDataBinding, out BaseViewModel>>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

}