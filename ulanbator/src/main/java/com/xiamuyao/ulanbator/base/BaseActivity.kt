package com.xiamuyao.ulanbator.base

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gyf.immersionbar.ImmersionBar
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.utlis.LL


abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var binding: V
    lateinit var viewModel: VM
    lateinit var mContext: Context

    open val loadPage: Boolean = true

    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        //私有的初始化 Data Binding 和 ViewModel 方法
        initViewDataBinding(savedInstanceState)
        //页面传参
        initParam()
        // View 初始化
        initView()
        //初始化数据
        initData()
        //初始化 V <--> VM LiveData 改变 V
        initVVMObserver()
        //注册基本的事件回调
        initBaseLiveDataCallBack()

        setImmersionBar()
    }

    open fun setImmersionBar() {
        ImmersionBar.with(this)
            .statusBarColor(R.color.immersionBar)
            .fitsSystemWindows(true)    //解决状态栏和布局重叠问题，任选其一，默认为false，当为true时一定要指定statusBarColor()，不然状态栏为透明色，还有一些重载方法
            .init()
    }


    private fun initBaseLiveDataCallBack() {

        viewModel.disDialogStatus.observe(this, Observer {
            dismissDialog()
        })

        viewModel.showDialogStatus.observe(this, Observer {
            showDialog()
        })

        viewModel.finishStatus.observe(this, Observer { finish() })

    }

    private fun initViewDataBinding(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState))

        viewModel = ViewModelProviders.of(this).get(initViewModel())
        //让 ViewModel 拥有View的生命周期感应
        binding.setVariable(initVariableId(), viewModel)
        binding.lifecycleOwner = this
    }


    fun showDialog() {
        LL.d("showDialog")
    }

    fun dismissDialog() {
        LL.d("dismissDialog")
    }

    /**
     *  接受上一个界面传递的参数
     */
    open fun initParam() {

    }

    /**
     * 初始化V-VM之间的观察者回调
     */
    abstract fun initVVMObserver()

    /**
     * 初始化页面数据
     */
    open  fun initData() {
        viewModel.initData()
    }

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
    abstract fun initContentView(savedInstanceState: Bundle?): Int

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun initVariableId(): Int

    /**
     * initialize The ViewModel
     *
     * @return 继承BaseViewModel的ViewModel
     */
    abstract fun initViewModel(): Class<VM>


}