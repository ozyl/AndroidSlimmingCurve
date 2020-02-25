package cn.okzyl.slimmingcurve.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.data.entity.HomeProviderMultiEntity
import cn.okzyl.slimmingcurve.databinding.LayoutHomeModuleBinding
import cn.okzyl.slimmingcurve.data.entity.HomeModuleEntity
import cn.okzyl.slimmingcurve.ui.widget.GridGapItemDecoration
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder


class HomeModuleProvider : BaseItemProvider<HomeProviderMultiEntity>() {
    override val itemViewType: Int = HomeProviderMultiEntity.MODULE

    override val layoutId: Int = R.layout.layout_home_module

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, data: HomeProviderMultiEntity?) {
        helper.getBinding<LayoutHomeModuleBinding>()?.run {
            data?.toEntity<HomeModuleEntity>()?.moduleList?.let {
                adapter = HomeModuleAdapter(it)
                divider = GridGapItemDecoration(10)
            }
        }
    }
}