package cn.okzyl.slimmingcurve.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.app.base.BaseFragment
import cn.okzyl.slimmingcurve.data.entity.CookBookEntity
import cn.okzyl.slimmingcurve.data.entity.HomeBannerEntity
import cn.okzyl.slimmingcurve.data.entity.HomeGridCBEntity
import cn.okzyl.slimmingcurve.data.entity.HomeTitleEntity
import cn.okzyl.slimmingcurve.databinding.FragmentHomeBinding
import cn.okzyl.slimmingcurve.ui.adapter.HomeAdapter
import cn.okzyl.slimmingcurve.data.entity.HomeBigCBEntity
import cn.okzyl.slimmingcurve.data.entity.HomeModuleEntity
import cn.okzyl.slimmingcurve.vm.HomeViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun getLayoutId(): Int = R.layout.fragment_home

    var bannerList = mutableListOf<String>()
    var moudleList = mutableListOf<HomeModuleEntity.HomeModule>()

    private val homeAdapter by lazy {
        HomeAdapter(
            mutableListOf(
                HomeBannerEntity(bannerList),
                HomeModuleEntity(moudleList),
                HomeTitleEntity("最新菜谱", HomeTitleEntity.LATEST_RECIPES),
                HomeGridCBEntity(
                    mutableListOf(
                        CookBookEntity(
                            cbKcal = 29,
                            cbName = "纯素蔬果沙拉",
                            cbPicUrl = "http://n1.itc.cn/img8/wb/recom/2016/07/31/146992488828471859.JPEG"
                        ),
                        CookBookEntity(
                            cbKcal = 29,
                            cbName = "纯素蔬果沙拉",
                            cbPicUrl = "http://n1.itc.cn/img8/wb/recom/2016/07/31/146992488828471859.JPEG"
                        ),
                        CookBookEntity(
                            cbKcal = 29,
                            cbName = "纯素蔬果沙拉",
                            cbPicUrl = "http://n1.itc.cn/img8/wb/recom/2016/07/31/146992488828471859.JPEG"
                        ),
                        CookBookEntity(
                            cbKcal = 29,
                            cbName = "纯素蔬果沙拉",
                            cbPicUrl = "http://n1.itc.cn/img8/wb/recom/2016/07/31/146992488828471859.JPEG"
                        )
                    )
                ),
                HomeTitleEntity("今日推荐", HomeTitleEntity.LATEST_RECIPES),
                HomeBigCBEntity(
                    CookBookEntity(
                        cbKcal = 29,
                        cbName = "纯素蔬果沙拉",
                        cbPicUrl = "http://n1.itc.cn/img8/wb/recom/2016/07/31/146992488828471859.JPEG"
                    )
                ),
                HomeTitleEntity("热门推荐", HomeTitleEntity.LATEST_RECIPES)
            )
        )
    }

    private val mViewModel by lazy {
        getViewModel(HomeViewModel::class.java)
    }

    override fun actionsOnViewInflate() {
        super.actionsOnViewInflate()

        mViewModel.banners.observe(this, Observer {
            bannerList.addAll(it)
            homeAdapter.notifyDataSetChanged()
        })
        mViewModel.modules.observe(this, Observer {
            moudleList.addAll(it)
            homeAdapter.notifyDataSetChanged()
        })

        mViewModel.setBanner()
        mViewModel.setModule()
    }

    override fun initFragment(view: View, savedInstanceState: Bundle?) {

        mBinding?.run {
            homeAdapter = this@HomeFragment.homeAdapter
        }

    }

}