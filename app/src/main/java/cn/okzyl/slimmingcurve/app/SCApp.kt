package cn.okzyl.slimmingcurve.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import cn.okzyl.slimmingcurve.BuildConfig
import timber.log.Timber

class SCApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = applicationContext

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var instance: Context
    }
}