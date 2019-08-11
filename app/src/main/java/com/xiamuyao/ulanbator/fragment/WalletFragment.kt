package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.WalletInfoActivity
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.databinding.FragmentHomeOldBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.utlis.To
import com.xiamuyao.ulanbator.view.SpaceItemDecoration
import com.xiamuyao.ulanbator.viewmodel.WalletViewModel


class WalletFragment : BaseFragment<FragmentHomeOldBinding, WalletViewModel>() {

    companion object {
        fun newInstance(bundle: Bundle?): WalletFragment {
            val homeFragment = WalletFragment()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    private val wallerAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_wallet, viewModel.walletList, BR.walletListBean)
    }
    private val lifeAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_home_temp, viewModel.lifeObservableArrayList, BR.homeListBean)
    }

    private val gameAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_home_temp, viewModel.gameObservableArrayList, BR.homeListBean)
    }


    override fun initView() {
        viewModel.gameList()
        viewModel.lifeList()
        binding.walletRecyclerView.defaultStyle(wallerAdapter)
        binding.lifeReLayout.defaultStyle(lifeAdapter, GridLayoutManager(activity!!, 3))
        binding.gameReLayout.defaultStyle(gameAdapter, GridLayoutManager(activity!!, 3))

        binding.lifeReLayout.addItemDecoration(SpaceItemDecoration())
        binding.gameReLayout.addItemDecoration(SpaceItemDecoration())

        binding.walletShow.setOnClickListener {
            viewModel.showOrHide.value = viewModel.showOrHide.value!!.not()
            viewModel.showOrHideListData()
        }

        wallerAdapter.setOnItemClickListener { _, _, position ->
            val find = App.marketList.find { it.pairName == wallerAdapter.getItem(position)?.pairName }
            val bundle = Bundle()
            bundle.putSerializable("data", wallerAdapter.getItem(position))
            bundle.putString("rate", find?.pairToPrice)
            WalletInfoActivity.start(context!!, bundle)
        }
        lifeAdapter.setOnItemClickListener { _, _, position ->
            To.showToast( getString(R.string.daikaifangjingqingqidai))
        }
        gameAdapter.setOnItemClickListener { _, _, position ->
            To.showToast(getString(R.string.daikaifangjingqingqidai))

        }
        binding.lifeAll.setOnClickListener {
            To.showToast(getString(R.string.daikaifangjingqingqidai))

        }
        binding.gameAll.setOnClickListener {
            To.showToast(getString(R.string.daikaifangjingqingqidai))

        }
    }

    override fun initVVMObserver() {

        DataBus.observeData(this, EventConstant.quote_Refresh, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                if (viewModel.calculationStatus.value!!) {
                    viewModel.calculationStatus.value = false
                    viewModel.setTheSumOfAssets()
                    viewModel.calculationStatus.value = true

                }
            }
        })

        DataBus.observeData(this, EventConstant.valuationCurrencyRefresh, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.refreshCurrency()
            }
        })

//        DataBus.observeData(this, EventConstant.LaunageSet, object : DataBusObservable<String> {
//            override fun dataBusDataCallBack(it: String) {
//onCreate(null)
//            }
//        })


    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_home_old
    }

    override fun initVariableId(): Int {
        return BR.walletViewModel
    }

    override fun initViewModel(): Class<WalletViewModel> {
        return WalletViewModel::class.java
    }

    override fun onResume() {
        super.onResume()
//        LL.d("onResume::"+App.CONTEXT.getString(R.string.login))
        viewModel.initData()
    }

}