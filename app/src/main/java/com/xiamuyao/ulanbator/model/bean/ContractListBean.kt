package com.xiamuyao.ulanbator.model.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.xiamuyao.ulanbator.constant.ProjectConstant

class ContractListBean : BaseObservable() {
    var id: Int = -1
    var contractImage: String = ProjectConstant.IMAGE_URL

    var contractPercentage: String = "0.1%~0.2%"
    var contractType: String = "日化收益率"
    var contractLever: String = "S1"
    var contractThreshold: String = "门槛：$1000-$2000"


}