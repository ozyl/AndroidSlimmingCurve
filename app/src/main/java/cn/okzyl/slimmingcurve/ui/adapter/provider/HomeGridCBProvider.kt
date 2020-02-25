package cn.okzyl.slimmingcurve.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.data.entity.HomeGridCBEntity
import cn.okzyl.slimmingcurve.data.entity.HomeProviderMultiEntity
import cn.okzyl.slimmingcurve.databinding.LayoutHomeCbGridBinding
import cn.okzyl.slimmingcurve.ui.widget.GridGapItemDecoration
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import me.jessyan.autosize.utils.AutoSizeUtils


class HomeGridCBProvider : BaseItemProvider<HomeProviderMultiEntity>() {
    override val itemViewType: Int = HomeProviderMultiEntity.CB_GRID_ITEM

    override val layoutId: Int = R.layout.layout_home_cb_grid

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, data: HomeProviderMultiEntity?) {
        helper.getBinding<LayoutHomeCbGridBinding>()?.run {
            data?.toEntity<HomeGridCBEntity>()?.cbList?.let {
                adapter = HomeGridCBAdapter(it)
                divider = GridGapItemDecoration(AutoSizeUtils.dp2px(context,14F))
            }
        }
    }
}