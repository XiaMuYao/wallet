package com.xiamuyao.ulanbator.model.bean

import android.graphics.Rect
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Nullable
import com.previewlibrary.enitity.IThumbViewInfo

class UserViewInfo : IThumbViewInfo {

    private var url: String? = null  //图片地址
    private var mBounds: Rect? = null // 记录坐标
    var user: String? = "用户字段"
    private var videoUrl: String? = null

    constructor(url: String) {
        this.url = url
    }

    constructor(videoUrl: String, url: String) {
        this.url = url
        this.videoUrl = videoUrl
    }

    override fun getUrl(): String? {//将你的图片地址字段返回
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    override fun getBounds(): Rect? {//将你的图片显示坐标字段返回
        return mBounds
    }

    @Nullable
    override fun getVideoUrl(): String? {
        return videoUrl
    }

    fun setBounds(bounds: Rect) {
        mBounds = bounds
    }

    fun setVideoUrl(videoUrl: String) {
        this.videoUrl = videoUrl
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.url)
        dest.writeParcelable(this.mBounds, flags)
        dest.writeString(this.user)
        dest.writeString(this.videoUrl)
    }

    protected constructor(`in`: Parcel) {
        this.url = `in`.readString()
        this.mBounds = `in`.readParcelable(Rect::class.java.classLoader)
        this.user = `in`.readString()
        this.videoUrl = `in`.readString()
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<UserViewInfo> = object : Parcelable.Creator<UserViewInfo> {
            override fun createFromParcel(source: Parcel): UserViewInfo {
                return UserViewInfo(source)
            }

            override fun newArray(size: Int): Array<UserViewInfo?> {
                return arrayOfNulls(size)
            }
        }
    }
}
