package cn.okzyl.slimmingcurve.data.entity

class HomeModuleEntity(var moduleList:MutableList<HomeModule>)  : HomeProviderMultiEntity(MODULE) {

    class HomeModule(
        val backgroundResId:Int,
        val title:String,
        val icon:Int,
        val type:Int
    ){
        companion object{
            const val JIAN_ZHI = 1
            const val ZENG_JI = 2
            const val GAN_HUO = 3
        }
    }
}