package com.xiamuyao.ulanbator

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://WanAndroidBean.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        var type = "18945715484"
        var first = type.substring(0, 3)

        var after = type.substring(type.length - 4, type.length)
        var aaaa = "${first}****${after}"

        println(aaaa)

    }
    @Test
    fun addition_isCorredct() {

        var type = "0.000000000000000000"

        println(        type.toBigDecimal().stripTrailingZeros().toPlainString())

    }


}
