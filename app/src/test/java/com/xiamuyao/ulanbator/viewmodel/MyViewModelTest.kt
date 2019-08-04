package com.xiamuyao.ulanbator.viewmodel

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

class MyViewModelTest {

    @Test
    fun getMylist() {

    }

    @Test
    fun getMylist1() {
        var a = "1.4952891"

        val nf = NumberFormat.getNumberInstance()
        nf.setMaximumFractionDigits(2)
        println(nf.format(a))
//        println(a.toBigDecimal().setScale(2))
    }


}