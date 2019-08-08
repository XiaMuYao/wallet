package com.xiamuyao.ulanbator.util

import android.text.TextUtils
import java.math.BigDecimal
import java.text.DecimalFormat

object ArithUtil {


    fun convertNumber(value: String, num: Int = 6): String {
        if (TextUtils.isEmpty(value)) {
            return ""
        }
        if (num == 0) {
            return DecimalFormat("#,###").format(BigDecimal(value))
        }

        val pattern = StringBuffer()
        for (i in (0 until num)) {
            pattern.append("#")
        }

        return DecimalFormat("#,###.$pattern").format(BigDecimal(value))
    }


    /**
     * value:1.23 num:4
     * result:1.2300
     */
    fun convertNumber3(value: String, num: Int = 4): String {
        val pattern = StringBuffer()
        for (i in (0 until num)) {
            pattern.append("0")
        }

        if (value.isNullOrBlank() || value == "0") {
            return "0.$pattern"
        }
        if (num == 0) {
            return DecimalFormat("#,###").format(BigDecimal(value.trim()))
        }

        return DecimalFormat("#,##0.$pattern").format(BigDecimal(value.trim()))
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(convertNumber3("4657702.88123"))
    }

}