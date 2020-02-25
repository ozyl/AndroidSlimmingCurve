package cn.okzyl.slimmingcurve.ui.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.data.entity.CookBookEntity
import cn.okzyl.slimmingcurve.databinding.LayoutHomeCbGridItemBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class HomeGridCBAdapter(var list: MutableList<CookBookEntity>) :
    BaseQuickAdapter<CookBookEntity, BaseViewHolder>(R.layout.layout_home_cb_grid_item,list) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: CookBookEntity?) {
        helper.getBinding<LayoutHomeCbGridItemBinding>()?.run {
            item?.run {
                vmCbName = cbName
                vmCbKcal = cbKcal
                vmCbPicUrl = cbPicUrl
            }
        }
    }
}