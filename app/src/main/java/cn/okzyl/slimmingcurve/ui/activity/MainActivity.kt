package cn.okzyl.slimmingcurve.ui.activity

import android.os.Bundle
import cn.okzyl.slimmingcurve.R
import cn.okzyl.slimmingcurve.app.base.BaseActivity
import cn.okzyl.slimmingcurve.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initActivity(savedInstanceState: Bundle?) {
        mainNav.itemIconTintList = null
    }


}
