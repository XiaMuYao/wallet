package com.xiamuyao.ulanbator.utlis

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import com.xiamuyao.ulanbator.LibApp

import java.util.Locale

object LocalManageUtil {

    /**
     * 获取App的locale
     *
     * @return Locale对象
     */
    val appLocale: Locale
        get() {
            val locale: Locale
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                locale = LocaleList.getDefault().get(0)
            } else {
                locale = Locale.getDefault()
            }
            return locale
        }

    /**
     * 获取系统local
     *
     * @return
     */
    val systemLocale: Locale
        get() = Resources.getSystem().configuration.locale

    /**
     * 获取选择的语言设置
     * @param context
     * @return
     */
    private fun getSetLanguageLocale(context: Context): Locale {
        when (LibApp.getContext().getSpValue("SELECITY", 0)) {
            0
            -> return systemLocale
            1//
            -> return Locale.CHINESE
            2
            -> return Locale.ENGLISH
            3
            -> return Locale.KOREA
            4
            -> return Locale.JAPAN
            else
            -> return Locale.CHINESE
        }
    }

    /**
     * 设置 本地语言
     *
     * @param context
     * @param select
     */
    fun saveSelectLanguage(context: Context, select: Int) {
        LibApp.getContext().putSpValue("SELECITY", select)
        setApplicationLanguage(context)
    }


    /**
     * 初始化语言 方法
     *
     * @param context
     */
    fun setLocal(context: Context): Context {
        return setApplicationLanguage(context)
    }

    /**
     * 设置语言类型
     */
    fun setApplicationLanguage(context: Context): Context {

        val resources = context.resources
        val dm = resources.displayMetrics
        val config = resources.configuration
        val locale = getSetLanguageLocale(context)//获取sp里面保存的语言

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val localeList = LocaleList(locale)
            LocaleList.setDefault(localeList)
            config.setLocales(localeList)
            Locale.setDefault(locale)
            return context.createConfigurationContext(config)
        } else {
            config.locale = locale
        }
        resources.updateConfiguration(config, dm)
        return context
    }

    /**
     * 获取本地保存的语言
     *
     * @param context
     * @return
     */
    fun getLocalSaveLanguage(context: Context): String {
        val locale = getSetLanguageLocale(context)
        var language = locale.language
        if (language == "zh") {
            language = "zh-CN"
        } else if (language == "en") {
            language = "en"
        } else if (language == "ja") {
            language = "ja"
        }
        return language
    }

}