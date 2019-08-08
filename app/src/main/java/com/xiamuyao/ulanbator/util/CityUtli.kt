package com.xiamuyao.ulanbator.util

import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.utlis.LL
import java.util.*

object CityUtli {

    //汉语
    const val CHINESE = 1
    //英语
    const val ENGLISH = 2
    //韩语
    const val KOREAN = 3
    //日语
    const val JAPANESE = 4
    var cityList = arrayListOf<cityBean>(
        cityBean(CHINESE, App.CONTEXT.getString(R.string.chaina), "zh", ""),
        cityBean(ENGLISH, App.CONTEXT.getString(R.string.english), "en", ""),
        cityBean(JAPANESE, App.CONTEXT.getString(R.string.riyu), "jq", ""),
        cityBean(KOREAN, App.CONTEXT.getString(R.string.hanyu), "ko", "")
    )

    fun saveLanguage(index: Int) {
        LL.d("SELECITY:$index")
        App.CONTEXT.putSpValue("SELECITY", index)
    }

    fun getLanguage(): Int {
        return App.CONTEXT.getSpValue("SELECITY", -1)
    }

    fun geyLanguageBySys(value: Int): Locale? {

        return when (value) {
            CHINESE -> {
                Locale.CHINESE
            }
            ENGLISH -> {
                Locale.ENGLISH
            }
            KOREAN -> {
                Locale.KOREAN
            }
            JAPANESE -> {
                Locale.JAPANESE
            }
            else -> Locale.CHINESE
        }

    }

    class cityBean(var cityId: Int, var cityName: String, var cityType: String, var cityZName: String)


}