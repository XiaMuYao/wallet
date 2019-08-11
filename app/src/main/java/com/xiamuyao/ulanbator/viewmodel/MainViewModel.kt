package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import android.app.DownloadManager
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import org.kodein.di.generic.instance
import android.os.Environment.DIRECTORY_DOWNLOADS
import org.kodein.di.weakReference
import android.app.DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
import android.net.Uri
import android.os.Environment
import com.xiamuyao.ulanbator.model.bean.response.GetVerSion
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.util.RateUtli.getPriceList
import com.zhangke.websocket.WebSocketHandler
import kotlinx.coroutines.delay
import java.io.File
import okhttp3.ResponseBody


class MainViewModel(application: Application) : BaseViewModel(application) {
    private val userrepository: UserRepository by instance()
    private val repository: WalletRepository by instance()

    var loadOk = MutableLiveData<Boolean>()
    var updata = MutableLiveData<GetVerSion.DataBean>()

    //底部点击菜单控件List
    var bottomClickIdList = arrayListOf(
        R.id.mainBottomTabOne,
        R.id.mainBottomTabTwo,
        R.id.mainBottomTabThere,
        R.id.mainBottomTabFour,
        R.id.mainBottomTabFive
    )

    //底部菜单ImageView控件List
    var bottomClickImageIdList = arrayListOf(
        R.id.bottom_tab_iv_one,
        R.id.bottom_tab_iv_two,
        R.id.bottom_tab_iv_there,
        R.id.bottom_tab_iv_four,
        R.id.bottom_tab_iv_five
    )

    var fragmentIndex = MutableLiveData<Int>()


    init {
        fragmentIndex.value = 0
        loadOk.value = true
    }

    override fun initData() {
        //汇率数据默认第一次调用
        getExchangeRateData()
        appUpdataViewModel()
    }

    fun appUpdataViewModel() {

        launch {
            val theLatestVersionNumber = userrepository.getTheLatestVersionNumber()
            updata.value = theLatestVersionNumber.data
            theLatestVersionNumber
        }

    }


    /**
     * 获取汇率数据
     */
    fun getExchangeRateData() {
        loadOk.value = false
        val find = getPriceList().find { it.pairName == "MFT" }
        if (find!!.close.length < 2) {
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_MFTKRWT)
        }
        launch {
            repository.obtainExchangeRate()
            loadOk.value = true
        }
    }

    /**
     * 更改ViewPager下标
     * @param index Int
     */
    fun setViewPagerIndex(index: Int) {
        fragmentIndex.value = index
    }

}