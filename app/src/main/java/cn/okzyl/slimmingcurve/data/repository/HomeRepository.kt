package cn.okzyl.slimmingcurve.data.repository

import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.app.base.BaseRepository
import cn.okzyl.slimmingcurve.data.entity.HomeModuleEntity

class HomeRepository : BaseRepository() {

    fun getBanner():MutableList<String>{
        return mutableListOf(
            "https://hbimg.huabanimg.com/a41768d9503267825fe4a1af20dc908797905c918843ab-vMgzIL_fw658",
            "https://hbimg.huabanimg.com/d5cd662d374c527633a4bc1673e3b47f869772ece9b6cd-ChqVlz_fw658"
        )
    }
    fun getModules():MutableList<HomeModuleEntity.HomeModule>{
        return mutableListOf(
            HomeModuleEntity.HomeModule(
                icon = R.mipmap.ic_launcher,
                backgroundResId = R.drawable.bg_home_pink,
                title = "减脂",type = HomeModuleEntity.HomeModule.JIAN_ZHI
            ),
            HomeModuleEntity.HomeModule(
                icon = R.mipmap.ic_launcher,
                backgroundResId = R.drawable.bg_home_yellow,
                title = "增肌",type = HomeModuleEntity.HomeModule.ZENG_JI
            ),
            HomeModuleEntity.HomeModule(
                icon = R.mipmap.ic_launcher,
                backgroundResId = R.drawable.bg_home_blue,
                title = "干货",type = HomeModuleEntity.HomeModule.GAN_HUO
            )
        )
    }

}