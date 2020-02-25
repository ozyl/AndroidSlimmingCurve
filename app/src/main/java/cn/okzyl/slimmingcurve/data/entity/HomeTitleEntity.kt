package cn.okzyl.slimmingcurve.data.entity

class HomeTitleEntity(var title:String,val titleType:Int) : HomeProviderMultiEntity(TITLE){
    companion object{
        var LATEST_RECIPES = 1
        var TODAY_RECOMMEND = 2
        var HOT_RECOMMEND = 3
    }
}