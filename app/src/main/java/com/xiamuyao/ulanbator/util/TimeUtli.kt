package com.xiamuyao.ulanbator.util

import android.annotation.SuppressLint
import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*
import java.text.ParseException as ParseException1


object TimeUtli {


    const val DEFAULT_TO_DATE_TIME = "yyyy-MM-dd HH:mm:ss"
    const val DEFAULT_TO_DATE_TIME_YYYY_MMM = "yyyy/MM/dd HH:mm:ss"

    const val DEFAULT_TO_DATE = "yyyy/MM/dd"

    const val DEFAULT_TO_YY_MM_DD = "yy/MM/dd"
    const val DEFAULT_TO_HH_MM_SS = "HH:mm:ss"

    const val DEFAULT_TO_TIME = "HH:mm:ss"

    const val DEFAULT_TO_YYMMDD = "MM/dd HH:mm"

    const val DEFAULT_TO_HHMM = "HH:mm"

    const val DEFAULT_FROM_DATE_TIME = "yyyyMMddHHmmss"

    const val DEFAULT_FROM_YYYYMMDD = "yyyymmdd"

    const val DEFAULT_YYYY_MM_DD = "yyyy-MM-dd"

    const val DEFAULT_YYYYNMMYDDD = "yyyy年MM月dd日"

    const val DEFAULT_YYYNMYDD = "yyyyMMdd"

    const val DEFAULT_TO_YY_MM_DD_HHMM = "yy/MM/dd HH:mm"

    const val DEFAULT_TO_YYYY_MM_DD_HHMMSS = "yyyy/MM/dd HH:mm:ss"


    fun getTime(): String {
        val cal = Calendar.getInstance()
        val temeTime =
            "${cal.get(Calendar.YEAR)}-" +
                    "${addZeroInHead((cal.get(Calendar.MONTH) + 1).toString())}-" +
                    addZeroInHead(cal.get(Calendar.DATE).toString())
        return temeTime
    }


    @SuppressLint("SimpleDateFormat")
    fun parse(source: String, toFormat: String = DEFAULT_TO_DATE, fromFormat: String = DEFAULT_FROM_DATE_TIME): String {
        return if (source.isNotEmpty()) {
            SimpleDateFormat(toFormat).format(SimpleDateFormat(fromFormat).parse(source))
        } else {
            ""
        }
    }

    fun checkOption(option: String, _date: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val cl = Calendar.getInstance()
        var date: Date? = null

        try {
            date = sdf.parse(_date) as Date
        } catch (e: ParseException1) {
            e.printStackTrace()
        }

        cl.time = date
        if ("pre" == option) {
            // 时间减一天
            cl.add(Calendar.DAY_OF_MONTH, -1)

        } else if ("next" == option) {
            // 时间加一天
            cl.add(Calendar.DAY_OF_YEAR, 1)
        } else {
            // do nothing
        }
        date = cl.time
        return sdf.format(date)
    }

    /**
     * 获取置顶天数以后的时间
     * @param num Int
     * @return String
     */
    fun getDayOfDay(num: Int = 30): String {
        val toTime = System.currentTimeMillis().toString().toTime()
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val dt = sdf.parse(toTime)
        val rightNow = Calendar.getInstance()
        rightNow.time = dt
        rightNow.add(Calendar.DAY_OF_YEAR, num)
        val dt1 = rightNow.time
        val reStr = sdf.format(dt1)
        return reStr
    }


    fun addZeroInHead(str: String, expectLenght: Int = 2): String {
        val sb = StringBuffer()
        for (i in 0 until expectLenght - str.length) {
            sb.append("0")
        }
        return sb.toString() + str
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(getDayOfDay())
    }
}