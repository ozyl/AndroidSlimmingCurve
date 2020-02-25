package cn.okzyl.slimmingcurve.ui.adapter

import cn.okzyl.slimmingcurve.data.entity.HomeProviderMultiEntity
import cn.okzyl.slimmingcurve.ui.adapter.provider.HomeBigCBProvider
import cn.okzyl.slimmingcurve.ui.adapter.provider.HomeTitleProvider
import com.chad.library.adapter.base.BaseProviderMultiAdapter

class HomeAdapter(list: MutableList<HomeProviderMultiEntity>) :
    BaseProviderMultiAdapter<HomeProviderMultiEntity>(list) {

    init {
        addItemProvider(HomeBannerProvider())
        addItemProvider(HomeModuleProvider())
        addItemProvider(HomeTitleProvider())
        addItemProvider(HomeGridCBProvider())
        addItemProvider(HomeBigCBProvider())

    }

    override fun getItemType(data: List<HomeProviderMultiEntity>, position: Int): Int {
        return data[position].itemType
    }
}