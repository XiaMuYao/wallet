package com.xiamuyao.sample

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates
import com.xiamuyao.sample.model.repository.PlaceRepository
import com.xiamuyao.sample.network.ServiceCreator
import com.xiamuyao.sample.network.api.BusinessService
import com.xiamuyao.ulanbator.LibApp
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.*


class App : Application(), KodeinAware {
    override val kodein = Kodein.lazy {

        //创建
        bind<BusinessService>() with singleton { ServiceCreator.create(BusinessService::class.java) }

        //从容器中选择
        bind<PlaceRepository>() with singleton { PlaceRepository.getInstance(instance()) }

    }

    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext

        LibApp.init(CONTEXT)

    }


}