package cn.okzyl.slimmingcurve.ui.adapter.provider

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.data.entity.HomeProviderMultiEntity
import cn.okzyl.slimmingcurve.databinding.LayoutHomeBigCbBinding
import cn.okzyl.slimmingcurve.data.entity.HomeBigCBEntity
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class HomeBigCBProvider : BaseItemProvider<HomeProviderMultiEntity>(){
    override val itemViewType: Int
        get() = HomeProviderMultiEntity.BIG_IMAGE
    override val layoutId: Int
        get() = R.layout.layout_home_big_cb

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, data: HomeProviderMultiEntity?) {
        data?.toEntity<HomeBigCBEntity>()?.run {
            helper.getBinding<LayoutHomeBigCbBinding>()?.run {
                vmCbPicUrl = cb.cbPicUrl
                vmCbName = cb.cbName
            }
        }
    }
}