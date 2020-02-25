package cn.okzyl.slimmingcurve.vm

import androidx.lifecycle.MutableLiveData
import cn.okzyl.slimmingcurve.app.base.BaseViewModel
import cn.okzyl.slimmingcurve.data.entity.HomeModuleEntity
import cn.okzyl.slimmingcurve.data.repository.HomeRepository

class HomeViewModel : BaseViewModel<HomeRepository>() {

    val banners = MutableLiveData<MutableList<String>>()
    val modules = MutableLiveData<MutableList<HomeModuleEntity.HomeModule>>()


    fun setBanner(){
        banners.value = repo.getBanner()
    }
    fun setModule(){
        modules.value = repo.getModules()
    }
}