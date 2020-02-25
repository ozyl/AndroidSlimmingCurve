package cn.okzyl.slimmingcurve.data.entity

import android.graphics.Color

data class CookBookEntity(
    var cbName:String,
    var cbKcal:Int,
    var cbPicUrl:String,
    var cbDesc:String="",
    var cbTags: MutableList<CookBookTagEntity> = mutableListOf()
)

data class CookBookTagEntity(
    var tagName:String,
    var tagColor:Color,
    var tagType:Int
){
    companion object{
        const val CB_TAG_BREAKFAST = 1;
        const val CB_TAG_LUNCH = 2;
        const val CB_TAG_DINNER = 3;
    }
}