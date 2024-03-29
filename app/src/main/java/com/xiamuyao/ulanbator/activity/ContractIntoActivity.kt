package com.xiamuyao.ulanbator.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.databinding.ActivityContractintoBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.view.CustomPopupWindow
import com.xiamuyao.ulanbator.viewmodel.ContractIntoViewModel
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_contractinto.*


/**
 * 合约 操作
 */
class ContractIntoActivity : BaseActivity<ActivityContractintoBinding, ContractIntoViewModel>() {


    override fun initView() {
        setTitleBar(
            getString(R.string.zhuanruheyu),
            { finish() },
            titleBarColor = R.color.touming
        )

        viewModel.productId.value = intent.getStringExtra("productId")
        viewModel.interestMax.value = intent.getStringExtra("interestMax")
        viewModel.shouyiText.value = intent.getStringExtra("shouyiText")
        val money = intent.getStringExtra("money")
        viewModel.from.value = intent.getStringExtra("from")
        val stateRate = intent.getIntExtra("stateRate", -1)
        val userAmountMax = intent.getIntExtra("userAmountMax", -1)
        //设置进度条
        binding.signSeekBar.setValueFormatListener { progress ->
            "$$money"
        }
        binding.signSeekBar.configBuilder.signColor(Color.parseColor("#00FFFFFF")).build()

        binding.signSeekBar.configBuilder
            .min(0f)
            .max(100f)
            .progress(stateRate.toFloat())
            .build()


        binding.editText.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                viewModel.nowSelectPrice.value = "0"
                viewModel.expectedReturn.value = "0"
                setData()
                return@addTextChangedListener
            }
            viewModel.calculateTheAmountAfterTheInput(viewModel.inoutMoney.value?.toBigDecimal()!!)
            setData()
        }

        binding.constraintLayout.setOnClickListener {
            if (viewModel.from.value != "2") {
                val customPopupWindow = CustomPopupWindow(this, viewModel.pariList)
                customPopupWindow.showAsDropDown(binding.constraintLayout)
            }

        }

    }


    override fun initVVMObserver() {

        DataBus.observeData(this, EventConstant.finsh, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
              viewModel.finishStatus.call()
            }
        })


        viewModel.productId.observe(this, Observer {
            viewModel.getPageData(it)
        })

        viewModel.loadOk.observe(this, Observer {
            setData()
            //页面属性
            when (viewModel.type.value) {
                0 -> {
                    binding.button.visibility = View.VISIBLE

                }
                1 -> {
                    binding.button3.visibility = View.VISIBLE
                    binding.button5.visibility = View.VISIBLE
                }
                2 -> {
                    binding.button4.visibility = View.VISIBLE

                }
            }

        })

        DataBus.observeData(this, EventConstant.SELECT_PAIRNAME, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectPairName.value = it
                if (viewModel.inoutMoney.value.isNullOrEmpty()) return
                viewModel.calculateTheAmountAfterTheInput(viewModel.inoutMoney.value?.toBigDecimal()!!)
            }
        })
        DataBus.observeData(this, EventConstant.SELECT_PAIR_PRICE, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectPairPrice.value = it

            }
        })
        DataBus.observeData(this, EventConstant.SELECT_PAIR_INDEX, object : DataBusObservable<Int> {
            override fun dataBusDataCallBack(it: Int) {
                viewModel.setTitle1(it)

            }
        })

        viewModel.disContract.observe(this, Observer {
            showDisContract()
        })
        viewModel.showBuyDialog.observe(this, Observer {
            showBuyDialog()
        })
    }

    private fun setData() {
        //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
        val greenSpan1 = ForegroundColorSpan(ContextCompat.getColor(this, R.color.lvse))
        val greenSpan2 = ForegroundColorSpan(ContextCompat.getColor(this, R.color.lvse))
        val greenSpan3 = ForegroundColorSpan(ContextCompat.getColor(this, R.color.lvse))
        val greenSpan4 = ForegroundColorSpan(ContextCompat.getColor(this, R.color.lvse))
        val greenSpan5 = ForegroundColorSpan(ContextCompat.getColor(this, R.color.lvse))

        if (viewModel.from.value == "1") {
            dingcunGroup.visibility = View.VISIBLE
            textView33.visibility = View.GONE
            val builder = SpannableStringBuilder(
                getString(R.string.yuejishijian) +
                        viewModel.earningsStartTime.value +
                        getString(R.string.cjamsjemhsjpiuo) +
                        viewModel.incomeArrivalTime.value +
                        getString(R.string.shouyicaozhang)
            )

            val startTime1 = getString(R.string.yuejishijian).length
            val endTime1 = startTime1 + viewModel.earningsStartTime.value?.length!!

            val startTime2 = endTime1 + getString(R.string.cjamsjemhsjpiuo).length
            val endTime2 = startTime2 + viewModel.incomeArrivalTime.value?.length!!

            builder.setSpan(
                greenSpan1,
                startTime1,
                endTime1,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )

            builder.setSpan(
                greenSpan3,
                startTime2,
                endTime2,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )

            binding.textView32.setText(builder)

        } else {
            dingcunGroup.visibility = View.GONE
            textView33.visibility = View.VISIBLE
            val builder = SpannableStringBuilder(
                getString(R.string.femhnoqo) +
                        viewModel.thisleaveDay.value + getString(R.string.tiantiantian) +
                        getString(R.string.yujishouyi) +
                        viewModel.expectedReturn.value +
                        " MFT," +
                        viewModel.dueTransferTime.value +
                        getString(R.string.manqizhuanru) +
                        "S1" +
                        getString(R.string.huoqi)
            )

            val startTime1 = getString(R.string.femhnoqo).length
            val endTime1 = startTime1 + viewModel.thisleaveDay.value?.length!! + 1

            val startTime2 = endTime1 + getString(R.string.yujishouyi).length
            val endTime2 = startTime2 + viewModel.expectedReturn.value!!.length


            val startTime3 = endTime2 + " MFT,".length
            val endTime3 = startTime3 + viewModel.dueTransferTime.value?.length!!

            builder.setSpan(
                greenSpan1,
                startTime1,
                endTime1,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )

            builder.setSpan(
                greenSpan2,
                startTime2,
                endTime2,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )

            builder.setSpan(
                greenSpan3,
                startTime3,
                endTime3,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )



            binding.textView32.setText(builder)


            val builder1 = SpannableStringBuilder(
                getString(R.string.tiqianzhuanchushouxuwei) +
                        viewModel.thisleaveDay.value + "天" +
                        getString(R.string.jieyuejieyuejieyu) +
                        viewModel.leaveRateViewModel.value +"%"+
                        getString(R.string.shoufuweijisuan))




            val startTime4 = getString(R.string.tiqianzhuanchushouxuwei).length
            val endTime4 = startTime4 + (viewModel.thisleaveDay.value + "天" ).length

            val startTime5 = endTime4 + getString(R.string.jieyuejieyuejieyu).length
            val endTime5 = startTime5 + viewModel.shouyiText.value?.length!!


            builder1.setSpan(
                greenSpan4,
                startTime4,
                endTime4,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )

            builder1.setSpan(
                greenSpan5,
                startTime5,
                endTime5,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )

            binding.textView33.setText(builder1)


        }


    }

    fun showDisContract() {
        val builder = AlertDialog.Builder(this).setTitle(getString(R.string.jiechuheyueme))
            .setMessage(getString(R.string.querenshifoujiechuheyue)).setPositiveButton(getString(R.string.jiechu))
            { _, _ ->
                viewModel.contactContractNet()
            }
            .setNegativeButton(getString(R.string.quxia)) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
        builder.create().show()
    }

    fun showBuyDialog() {
        val builder = AlertDialog.Builder(this).setTitle(getString(R.string.querengoumaishangpin))
            .setMessage(getString(R.string.querenshfoyaogoumai)).setPositiveButton(getString(R.string.queding))
            { _, _ ->
                viewModel.buyProDuctNet()
            }
            .setNegativeButton(getString(R.string.quxia)) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
        builder.create().show()
    }



    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_contractinto
    }

    override fun initVariableId(): Int {
        return BR.contractintoViewModel
    }

    override fun initViewModel(): Class<ContractIntoViewModel> {
        return ContractIntoViewModel::class.java
    }

    companion object {
        fun start(
            context: Context,
            productId: String,
            shouyiText: String,
            from: String,
            stateRate: Int,
            userAmountMax: Int,
            money: String,
            interestMax: String
        ) {
            val starter = Intent(context, ContractIntoActivity::class.java)
            starter.putExtra("productId", productId)
            starter.putExtra("shouyiText", shouyiText)
            starter.putExtra("from", from)
            starter.putExtra("stateRate", stateRate)
            starter.putExtra("userAmountMax", userAmountMax)
            starter.putExtra("money", money)
            starter.putExtra("interestMax", interestMax)
            context.startActivity(starter)
        }
    }


}
