//package com.xiamuyao.ulanbator.model.bean
//
//import androidx.databinding.BaseObservable
//import androidx.databinding.Bindable
//
//class User : BaseObservable() {
//
//    @get:Bindable
//    var name: String? = null
//        set(name) {
//            field = name
//            notifyPropertyChanged(com.qiangxi.databindingdemo.BR.name)
//        }
//    @get:Bindable
//    var age: Int = 0
//        set(age) {
//            field = age
//            notifyPropertyChanged(com.qiangxi.databindingdemo.BR.age)
//        }
//    @get:Bindable
//    var sex: String? = null
//        set(sex) {
//            field = sex
//            notifyPropertyChanged(com.qiangxi.databindingdemo.BR.sex)
//        }
//    @get:Bindable
//    var isStudent: Boolean = false
//        set(student) {
//            field = student
//            notifyPropertyChanged(com.qiangxi.databindingdemo.BR.student)
//        }
//
//    val all: String
//        @Bindable("name", "age", "sex", "isStudent")
//        get() = "姓名:" + this.name + ",年龄=" + this.age + "，性别：" + this.sex + "，是不是学生=" + this.isStudent
//}