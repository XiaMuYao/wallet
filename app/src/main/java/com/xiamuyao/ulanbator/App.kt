package com.xiamuyao.ulanbator

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates
import com.xiamuyao.ulanbator.model.repository.PlaceRepository
import com.xiamuyao.ulanbator.network.ServiceCreator
import com.xiamuyao.ulanbator.network.api.BusinessService
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.*
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshFooter
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import android.R.attr.colorPrimary
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator
import com.previewlibrary.ZoomMediaLoader
import com.xiamuyao.ulanbator.util.TestImageLoader
import com.zhangke.websocket.WebSocketHandler
import com.zhangke.websocket.WebSocketSetting


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

        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white)//全局设置主题颜色
            ClassicsHeader(context)//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            //指定为经典Footer，默认是 BallPulseFooter
            ClassicsFooter(context).setDrawableSize(20f)
        }

    }




}