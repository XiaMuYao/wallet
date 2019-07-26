package com.xiamuyao.ulanbator.model.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.xiamuyao.ulanbator.constant.ProjectConstant

class FixedListBean : BaseObservable() {
    var id: Int = -1
    var fixedImage: String = ProjectConstant.IMAGE_URL


}