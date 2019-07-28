package com.xiamuyao.ulanbator.utlis

import android.widget.Toast
import com.xiamuyao.ulanbator.LibApp

object To {

    private var mToast: Toast? = null

    fun showToast(text: String) {

        if (mToast == null) {
            mToast = Toast.makeText(LibApp.getContext(), text, Toast.LENGTH_SHORT)
        } else {
            mToast!!.setText(text)
            mToast!!.duration = Toast.LENGTH_SHORT
        }
        mToast!!.show()
    }


}
