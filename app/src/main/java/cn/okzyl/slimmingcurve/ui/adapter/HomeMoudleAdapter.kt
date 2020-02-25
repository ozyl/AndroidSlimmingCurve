package cn.okzyl.slimmingcurve.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.app.getDrawable
import cn.okzyl.slimmingcurve.databinding.LayoutHomeModuleItemBinding
import cn.okzyl.slimmingcurve.data.entity.HomeModuleEntity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class HomeModuleAdapter(var list: MutableList<HomeModuleEntity.HomeModule>) :
    BaseQuickAdapter<HomeModuleEntity.HomeModule, BaseViewHolder>(R.layout.layout_home_module_item,list) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeModuleEntity.HomeModule?) {
        helper.getBinding<LayoutHomeModuleItemBinding>()?.run {
            item?.let {
                title = it.title
                background = getDrawable(it.backgroundResId)
                icon = getDrawable(it.icon)
            }
        }
    }
}