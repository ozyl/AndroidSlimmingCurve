package cn.okzyl.slimmingcurve.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.data.entity.HomeProviderMultiEntity
import cn.okzyl.slimmingcurve.databinding.LayoutHomeBannerBinding
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.youth.banner.listener.OnBannerListener


class HomeBannerProvider : BaseItemProvider<HomeProviderMultiEntity>() {
    override val itemViewType: Int = HomeProviderMultiEntity.BANNER

    override val layoutId: Int = R.layout.layout_home_banner


    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }


    override fun convert(helper: BaseViewHolder, data: HomeProviderMultiEntity?) {
        helper.getBinding<LayoutHomeBannerBinding>()?.run {
            bannerEntity = data?.toEntity()
            bannerListener = OnBannerListener {
            }
        }
    }
}