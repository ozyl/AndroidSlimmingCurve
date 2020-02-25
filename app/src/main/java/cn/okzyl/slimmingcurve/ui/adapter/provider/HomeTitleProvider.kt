package cn.okzyl.slimmingcurve.ui.adapter.provider

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.data.entity.HomeProviderMultiEntity
import cn.okzyl.slimmingcurve.data.entity.HomeTitleEntity
import cn.okzyl.slimmingcurve.databinding.LayoutHomeTitleBinding
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import timber.log.Timber

class HomeTitleProvider : BaseItemProvider<HomeProviderMultiEntity>() {

    override val itemViewType: Int = HomeProviderMultiEntity.TITLE

    override val layoutId: Int = R.layout.layout_home_title

    var mData:HomeTitleEntity?=null

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, data: HomeProviderMultiEntity?) {
        helper.getBinding<LayoutHomeTitleBinding>()?.run {
            mData = data?.toEntity<HomeTitleEntity>()?.apply {
                vdTitle = title
                provider = this@HomeTitleProvider
            }
        }
    }

    fun click(v: View){
        mData?.run {
            when(titleType){
                HomeTitleEntity.LATEST_RECIPES -> {
                    Timber.d("点击最新菜谱")
                }
                HomeTitleEntity.TODAY_RECOMMEND -> {
                    Timber.d("点击今日推荐")
                }
                HomeTitleEntity.HOT_RECOMMEND -> {
                    Timber.d("点击热门推荐")
                }
            }
        }
    }
}