package com.xiamuyao.ulanbator.model.bean

import com.previewlibrary.enitity.IThumbViewInfo

class SkirtListBean(
    var id: Int,
    var headUrl: String,
    var imageUrl: String,
    var name: String,
    var time: String,
    var text: String,
    var message: String,
    var good: String,
    var imageList: List<UserViewInfo>
)