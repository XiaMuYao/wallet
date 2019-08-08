package com.xiamuyao.ulanbator.view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.king.zxing.util.CodeUtils
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.util.UsetUtli.getUserId
import com.xiamuyao.ulanbator.util.getSpValue
import com.xiamuyao.ulanbator.util.saveToAlbum
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.To
import kotlinx.android.synthetic.main.dialog_share.*

/**
 * 分享dialog
 */
class ShareDialog : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.dialog_share, container)


        inflate.findViewById<TextView>(R.id.cancel).setOnClickListener { dismiss() }
//好累 瞎写点把

        val spValue = App.CONTEXT.getSpValue("shareUrl", "")

        val createQRCode = CodeUtils.createQRCode(spValue, 500)


        val userId = getUserId()


        inflate.findViewById<TextView>(R.id.textView80).setText(userId)
        var imageviewa: ImageView = inflate.findViewById<ImageView>(R.id.imageView21)
        imageviewa.setImageBitmap(createQRCode)


//        var layoutBitmap = inflate.findViewById<ConstraintLayout>(R.id.linearLayout10)

//        var a = createViewBitmap(layoutBitmap)

        inflate.findViewById<ImageView>(R.id.imageView23).setOnClickListener {
            createQRCode.saveToAlbum { path, uri ->
                DataBus.postData(EventConstant.DialogCLOSE, "")
                dismiss()
            }
        }

        return inflate
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Dialog_FullScreen)
    }

    private fun createViewBitmap(view: View): Bitmap {
        val createBitmap = Bitmap.createBitmap(1080, 1920, Bitmap.Config.RGB_565)
        view.layout(0, 0, 1080, 1920)
        view.draw(Canvas(createBitmap))
        return createBitmap
    }


}