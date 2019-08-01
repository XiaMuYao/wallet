package com.xiamuyao.ulanbator.util

import android.annotation.SuppressLint
import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


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

    fun addZeroInHead(toString: String, num: Int = 2): String {
        var sb = StringBuffer()
        if (toString.length < num) {
            for (i in 1..num - toString.length) {
                sb.append("0")
            }
            return sb.append(toString).toString()
        } else {
            return toString
        }

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
        } catch (e: ParseException) {
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

//    fun getDayOfDay(num: Int=30): String {
//        val date = DateUtils.addDays(Date(), 10)   //
//        System.out.println("当前时间为:" + DateFormatUtils.format(Date(), "yyyy-MM-dd HH:mm:ss"))
//        val format = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss")
//        println("当前时间加上10天后:$format")
//
//    }


    @JvmStatic
    fun main(args: Array<String>) {
        val sdf = SimpleDateFormat("yyyyMMdd")
        val str = "20110823"
        val dt = sdf.parse(str)
        val rightNow = Calendar.getInstance()
        rightNow.time = dt
        rightNow.add(Calendar.DAY_OF_YEAR, 30)//日期加10天
        val dt1 = rightNow.time
        val reStr = sdf.format(dt1)
        println(reStr)
        println(getDayOfDay(30))
    }
}