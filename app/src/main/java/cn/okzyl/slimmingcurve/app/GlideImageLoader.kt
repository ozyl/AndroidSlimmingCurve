package cn.okzyl.slimmingcurve.app


import android.app.Activity
import android.content.Context
import android.os.Build
import android.widget.ImageView
import cn.okzyl.slimmingcurve.R
import com.youth.banner.loader.ImageLoader


class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView) {
            imageView.load(path,radius = 20,placeholder = R.drawable.image_place_holder)
    }

}