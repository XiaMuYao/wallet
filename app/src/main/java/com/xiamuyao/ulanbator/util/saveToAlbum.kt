package com.xiamuyao.ulanbator.util

import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Environment
import com.xiamuyao.ulanbator.App
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.concurrent.thread

fun Bitmap.saveToAlbum(format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG, quality: Int = 100, filename: String = "", callback: ((path: String?, uri: Uri?)->Unit)? = null ) {
    GlobalScope.launch {
        try {
            //1. create path
            val dirPath = Environment.getExternalStorageDirectory().absolutePath + "/" + Environment.DIRECTORY_PICTURES
            val dirFile = File(dirPath)
            if (!dirFile.exists()) dirFile.mkdirs()
            val ext = when (format) {
                Bitmap.CompressFormat.PNG -> ".png"
                Bitmap.CompressFormat.JPEG -> ".jpg"
                Bitmap.CompressFormat.WEBP -> ".webp"
            }
            val target = File(dirPath, (if(filename.isEmpty()) System.currentTimeMillis().toString() else filename) + ext)
            if (target.exists()) target.delete()
            target.createNewFile()
            //2. save
            compress(format, quality, FileOutputStream(target))
            //3. notify
            MediaScannerConnection.scanFile(
               App.CONTEXT, arrayOf(target.absolutePath),
                    arrayOf("image/$ext")) { path, uri ->
                thread {
                    callback?.invoke(path, uri)

                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            thread {
                callback?.invoke(null, null)
            }
        }
    }
}