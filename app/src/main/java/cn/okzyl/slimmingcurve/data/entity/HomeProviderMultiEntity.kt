package cn.okzyl.slimmingcurve.data.entity

open class HomeProviderMultiEntity (
    var itemType:Int
){
    companion object{
        var BANNER = 1
        var MODULE = 2
        var TITLE = 3
        var CB_GRID_ITEM = 4
        var BIG_IMAGE = 5
        var CB_LIST_ITEM = 6
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> toEntity() = this as T
}