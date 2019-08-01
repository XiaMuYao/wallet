package com.xiamuyao.ulanbator

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.time.LocalTime

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://WanAndroidBean.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        var now = LocalTime.now()
        println(LocalTime.now().hour)
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.xiamuyao.scudmvvm",now)
    }
}
