package com.xiamuyao.ulanbator.listener

import android.view.View

/**
 * prevent large mounts of click event
 */
class NonDoubleClickListener : View.OnClickListener {
    private var limit: Double = 500.0

    var last = 0L

    private var delegateListener: View.OnClickListener? = null
    private var listener: ((View?) -> Unit)? = null

    constructor(listener: (View?) -> Unit) {
        this.listener = listener
    }

    constructor(listener: View.OnClickListener) {
        delegateListener = listener
    }

    override fun onClick(v: View?) {
        if (last > 0 && System.currentTimeMillis() - last < limit) {
            return
        }
        last = System.currentTimeMillis()
        if (delegateListener != null) {
            delegateListener?.onClick(v)
        } else {
            listener?.invoke(v)
        }

    }

}