package com.xiamuyao.ulanbator.util

import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.model.bean.HotCommunityBean
import com.xiamuyao.ulanbator.model.bean.SkirtListBean
import com.xiamuyao.ulanbator.model.bean.TagBean
import com.xiamuyao.ulanbator.model.bean.TopMessageBean
import java.io.UnsupportedEncodingException
import java.util.*

object DataUtli {
    @JvmStatic
    fun main(args: Array<String>) {
        println(getRandomJianHan(3))
    }

    // 图片List
    var imageList = arrayListOf<String>(
        "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2854809930,1757246720&fm=26&gp=0.jpg",
        "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3523603182,3350066083&fm=26&gp=0.jpg",
        "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1291301625,3994446816&fm=26&gp=0.jpg",
        "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3393363076,4141651445&fm=26&gp=0.jpg",
        "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2699887995,1300144339&fm=26&gp=0.jpg",
        "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4158386410,3651127847&fm=26&gp=0.jpg",
        "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2266977696,417541961&fm=11&gp=0.jpg",
        "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2416146298,2995738268&fm=26&gp=0.jpg",
        "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3279596351,2017990313&fm=11&gp=0.jpg"
    )

    /**
     * 返回热门数据
     */
    fun getHotPageList() = run {
        val tempList = arrayListOf<String>()
        repeat(8) {
            tempList.add("热门$it")
        }
        tempList
    }

    /**
     * 获取热门社区
     */
    fun getHotCommunity() = run {
        val tempList = ObservableArrayList<HotCommunityBean>()
        repeat(10) {
            tempList.add(HotCommunityBean(it, getRandomJianHan(3), imageList[getRandom(8)]))
        }
        tempList
    }

    fun getSkirtList() = run {
        val tempList = ObservableArrayList<SkirtListBean>()
        repeat(10) {
            tempList.add(
                SkirtListBean(
                    it,
                    "https://pics3.baidu.com/feed/622762d0f703918f103d2b9b8b3ea79358eec4ff.jpeg?token=ae0847d8af998e3a70eb5507e05555b3&s=46C3DC16499F40CA565021DE030080F2",
                    "https://pics3.baidu.com/feed/622762d0f703918f103d2b9b8b3ea79358eec4ff.jpeg?token=ae0847d8af998e3a70eb5507e05555b3&s=46C3DC16499F40CA565021DE030080F2",
                    getRandomJianHan(getRandom(4)),
                    "2019-02-15",
                    getRandomJianHan(getRandom(12)),
                    getRandomJianHan(getRandom(120)),
                    getRandom().toString(),
                    getRandom().toString(),
                    getImageList(),
                    getRandom(555).toString(),
                    getRandomTagList()
                )
            )
        }
        tempList
    }

    /**
     * 获取图片地址
     */
    fun getImageList(num: Int = 9) = run {
        val tempList = ObservableArrayList<String>()
        repeat(getRandom(num)) {
            tempList.add(imageList[it])
        }
        tempList
    }

    /**
     * 获取随机标签List
     */
    fun getRandomTagList(num: Int = 5) = run {
        val tempList = ObservableArrayList<TagBean>()
        repeat(getRandom(num)) {
            tempList.add(TagBean(it, "# ${getRandomJianHan(3)}"))
        }
        tempList
    }

    /**
     * 获取随机文字List
     */
    fun getRandomListString(num: Int = 100, textLength: Int = 2) = run {

        val tempList = ObservableArrayList<String>()

        repeat(getRandom(num)) {
            tempList.add(getRandomJianHan(textLength))
        }
        tempList
    }

    /**
     * 获取随机数字
     */
    fun getRandom(num: Int = 100) = run {
        Random().nextInt(num)
    }

    /**
     * 获取随机字符串
     */
    fun getRandomJianHan(len: Int): String {
        var ret = ""
        for (i in 0 until len) {
            var str: String? = null
            val hightPos: Int
            val lowPos: Int // 定义高低位
            val random = Random()
            hightPos = 176 + Math.abs(random.nextInt(39)) // 获取高位值
            lowPos = 161 + Math.abs(random.nextInt(93)) // 获取低位值
            val b = ByteArray(2)
            b[0] = hightPos.toByte()
            b[1] = lowPos.toByte()
            try {
                str = String(b, charset("GBK")) // 转成中文
            } catch (ex: UnsupportedEncodingException) {
                ex.printStackTrace()
            }

            ret += str
        }
        return ret
    }


    /**
     * 获取置顶消息
     */
    fun getTopMessage() = run {

        val tempList = ObservableArrayList<TopMessageBean>()
        repeat(2) {
            tempList.add(TopMessageBean(it, getRandomJianHan(3), imageList[getRandom(8)]))
        }
        tempList
    }


}