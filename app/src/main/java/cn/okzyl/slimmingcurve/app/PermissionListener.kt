package cn.okzyl.slimmingcurve.app

/**
 * @author kuky
 * @description 动态权限申请监听
 */
interface PermissionListener {
    fun onGranted()

    fun onDenied(deniedPermissions: List<String>)
}
