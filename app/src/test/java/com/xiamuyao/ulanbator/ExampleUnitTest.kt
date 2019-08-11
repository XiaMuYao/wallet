package com.xiamuyao.ulanbator

import com.xiamuyao.ulanbator.util.RateUtli.RoundDown
import org.junit.Test
import java.text.DecimalFormat
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

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
        println(RoundDown("1.555555".toDouble(), 4))

    }



    @Test
    fun addition_isCor0redct() {

        var type = "561.556"

        println(testStr(type))
    }

    fun testStr(type: String): String {
        var last = ""
        var latrStr = StringBuffer()

        val split = type.split(".")

        if (split.size == 1) {
            latrStr.append(split[0])

            for (i in 0..4) {
                latrStr.append("0")
            }
            return latrStr.toString()

        } else if (split.size == 2) {
            latrStr.append(split[0])

            if (split[1].length < 4) {
                for (i in 0..4 - split[1].length) {
                    latrStr.append("0")
                }
            } else {
                val s = split[1]
                val subSequence = s.subSequence(0, 4)
                latrStr.append(subSequence)
            }
            return latrStr.toString()
        }
        return ""
    }

}
