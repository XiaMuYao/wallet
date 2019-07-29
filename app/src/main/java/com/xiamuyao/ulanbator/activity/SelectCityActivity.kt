package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.databinding.ActivitySelectcityBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.LL
import com.xiamuyao.ulanbator.viewmodel.SelectCityViewModel


/**
 * 选择国家
 */
class SelectCityActivity : BaseActivity<ActivitySelectcityBinding, SelectCityViewModel>() {

    private val contractAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_city, viewModel.cityList, BR.cityListBean)
    }

    override fun initView() {
        binding.cityRecyclerView.defaultStyle(contractAdapter)

        contractAdapter.setOnItemClickListener { _, _, position ->
            DataBus.postData(EventConstant.selectCityName, viewModel.cityList[position]?.titleCN.toString())
            DataBus.postData(EventConstant.selectCityNum, viewModel.cityList[position]?.dialingCode.toString())
            DataBus.postData(EventConstant.countryCode, viewModel.cityList[position]?.countryCode.toString())
            finish()
        }

        //todo 选择国家筛选
        binding.editText.addTextChangedListener {
            LL.d("数据是${it?.toString()}")
        }
    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_selectcity
    }

    override fun initVariableId(): Int {
        return BR.selectcityViewModel
    }

    override fun initViewModel(): Class<SelectCityViewModel> {
        return SelectCityViewModel::class.java
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, SelectCityActivity::class.java)
            // starter.putExtra()
            context.startActivity(starter)
        }
    }

}