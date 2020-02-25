package cn.okzyl.slimmingcurve.app.base

import androidx.lifecycle.ViewModel
import cn.okzyl.slimmingcurve.utils.ReflexUtil

open class BaseViewModel<R:BaseRepository> : ViewModel() {
    val repo by lazy {
        ReflexUtil.getGenericClass<R>(this).getDeclaredConstructor().newInstance()
    }
}