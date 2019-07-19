package com.xiamuyao.ulanbator.view

import android.app.Dialog
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope

abstract class BaseDialog : AppCompatDialogFragment() {

    protected val isPortrait: Boolean
        get() {
            return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
        }

    protected lateinit var binding: ViewDataBinding

    override fun onCreateDialog(paramBundle: Bundle?): Dialog {
        val view = RelativeLayout(context)
        view.layoutParams = LayoutParams(-1, -1)
        val dialog = super.onCreateDialog(paramBundle)
        dialog.requestWindowFeature(1)
        dialog.setContentView(view as View)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0) as Drawable)
            dialog.window!!.setLayout(-1, -1)
        }
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, paramBundle: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutID, container, false)
        return binding.root
    }

    override fun onViewCreated(paramView: View, paramBundle: Bundle?) {
        super.onViewCreated(paramView, paramBundle)
        handleArgument()
        initView(paramView)
        lifecycleScope.launchWhenResumed {
            initVVMObserver()
        }
    }

    open fun initVVMObserver(){

    }

    override fun dismiss() {
        if (activity != null) {
            val mDialog = dialog
            if (!(activity as FragmentActivity).isDestroyed && mDialog != null) {
                if (mDialog.isShowing && null != fragmentManager) {
                    this.fragmentManager!!.beginTransaction().remove(this).commitAllowingStateLoss()
                }
            }
        }
    }

    fun show(paramFragmentManager: FragmentManager?) {
        if (null == paramFragmentManager) return
        val tag = this::class.java.name
        var f = paramFragmentManager.findFragmentByTag(tag)
        if (null == f) {
            f = this
        }
        if (f is BaseDialog) {
            paramFragmentManager.beginTransaction().remove(f).commitAllowingStateLoss()
            paramFragmentManager.let { f.show(it, tag) }
        }
    }

    abstract val layoutID: Int

    open fun handleArgument() {}
    protected abstract fun initView(view: View)
}