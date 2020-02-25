package cn.okzyl.slimmingcurve.app

import android.app.Activity

/**
 * @author kuky.
 * @description activity 栈管理
 */
object ActivityStackManager {

    private val activities = mutableListOf<Activity>()

    @JvmStatic
    fun addActivity(activity: Activity) = activities.add(activity)

    @JvmStatic
    fun removeActivity(activity: Activity) {
        if (activities.contains(activity)) {
            activities.remove(activity)
            activity.finish()
        }
    }

    @JvmStatic
    fun getTopActivity(): Activity? =
        if (activities.isEmpty()) null else activities[activities.size - 1]

    @JvmStatic
    fun finishAll() =
        activities.filter { it.isFinishing }.forEach { it.finish() }
}