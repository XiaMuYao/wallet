package com.xiamuyao.ulanbator.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.allenliu.versionchecklib.v2.AllenVersionChecker
import com.allenliu.versionchecklib.v2.builder.UIData
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.fragmentAdapter.SectionsPagerAdapter
import com.xiamuyao.ulanbator.databinding.ActivityMainBinding
import com.xiamuyao.ulanbator.viewmodel.MainViewModel
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.fragment.*
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), ViewPager.OnPageChangeListener,
    View.OnClickListener {

    private val mFragmentList: Array<BaseFragment<out ViewDataBinding, out BaseViewModel>> by lazy {
        arrayOf(
            WalletFragment.newInstance(null),
            QuotationFragment.newInstance(null),
            ManagingMoneyFragment.newInstance(null),
            FindFragment.newInstance(null),
            MyFragment.newInstance(null)
        )
    }



    var permissions = arrayOf<String>(
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CALL_PHONE
    )


    private val markerAdapter by lazy {
        SectionsPagerAdapter(supportFragmentManager, mFragmentList)
    }

    override fun onClick(v: View) {
        viewModel.setViewPagerIndex(viewModel.bottomClickIdList.indexOf(v.id))
        selectorBottomImage(viewModel.fragmentIndex.value!!)
    }

    private fun selectorBottomImage(value: Int) {
        viewModel.bottomClickImageIdList.withIndex().forEach {
            binding.root.findViewById<ImageView>(it.value).isSelected = it.index == value
        }
    }

    override fun initView() {
        // 这里可以绑定到 viewmodel 中的 setViewPagerIndex 直接绑定 传参进去
        binding.include2.mainBottomTabOne.setOnClickListener(this)
        binding.include2.mainBottomTabTwo.setOnClickListener(this)
        binding.include2.mainBottomTabThere.setOnClickListener(this)
        binding.include2.mainBottomTabFour.setOnClickListener(this)
        binding.include2.mainBottomTabFive.setOnClickListener(this)
        selectorBottomImage(viewModel.fragmentIndex.value!!)
        ActivityCompat.requestPermissions(this, permissions, 10010)
    }


    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        selectorBottomImage(position)
    }

    override fun initVVMObserver() {
        //行情 - 改变汇率
        DataBus.observeData(this, EventConstant.quote_Refresh, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                if (viewModel.loadOk.value!!) {
                    viewModel.getExchangeRateData()
                }
            }
        })

        viewModel.updata.observe(this, Observer {
            appUpdata()
        })
    }

    fun appUpdata() {

        val value = viewModel.updata.value!!

        if (ProjectConstant.APP_VERSION < value.versionNoAndroid.toInt()) {

            AllenVersionChecker
                .getInstance()
                .downloadOnly(
                    UIData.create()
                        .setContent(getString(R.string.banbengengxin))
                        .setTitle(
                            getString(R.string.shifouyaogengxin)
                        )
                        .setDownloadUrl(value.androidUrl)
                )
                .executeMission(this)
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        when (requestCode) {
            10010 -> {
                viewModel.appUpdataViewModel()
            }
        }

    }

    override fun initData() {
        with(binding.viewPager) {
            adapter = markerAdapter
            addOnPageChangeListener(this@MainActivity)
        }
        //获取汇率数据
        viewModel.getExchangeRateData()
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return BR.mainViewModel
    }

    override fun initViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }
}
