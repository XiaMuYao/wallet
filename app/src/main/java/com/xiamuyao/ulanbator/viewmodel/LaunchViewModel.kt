package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.activity.MainActivity
import com.xiamuyao.ulanbator.activity.NoLoginActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.ProjectConstant.USER_TOKEN
import com.xiamuyao.ulanbator.model.repository.PlaceRepository
import com.xiamuyao.ulanbator.util.getSpValue
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import kotlinx.coroutines.delay
import org.kodein.di.generic.instance

class LaunchViewModel(application: Application) : BaseViewModel(application) {

    private val repository: PlaceRepository by instance()


    override fun initData() {
        launch {
            kotlinx.coroutines.delay(2000)
            //没有用户
            if (getSpValue(USER_TOKEN, "").isEmpty()) {
                startActivity(NoLoginActivity::class.java)
            }else{
                //主页
                startActivity(MainActivity::class.java)
                ActivityStackManager.getInstance().finishAllActivity()
            }
        }
    }

}