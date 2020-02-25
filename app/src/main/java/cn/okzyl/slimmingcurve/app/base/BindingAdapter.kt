package cn.okzyl.slimmingcurve.app.base

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.okzyl.slimmingcurve.app.GlideImageLoader
import cn.okzyl.slimmingcurve.app.load
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.listener.OnBannerListener

/**
 * 绑定 Banner 图片列表和点击事件
 * @param banners Banner 信息列表
 * @param listener 点击事件
 */
@BindingAdapter(value = ["bind:banners", "bind:bannerClick"], requireAll = false)
fun loadBannerImg(banner: Banner, banners: List<String>?, listener: OnBannerListener?) {
    if (banners.isNullOrEmpty()) return

    val images = arrayListOf<String>()
    banners.forEach { images.add(it) }

    banner.setImages(images)
        .setImageLoader(GlideImageLoader())
        .setBannerStyle(BannerConfig.RIGHT)
        .setDelayTime(5000).start()

    banner.setOnBannerListener(listener)
}



/**
 * 绑定 recyclerView 分割线
 */
@BindingAdapter("bind:divider")
fun bindRecyclerDivider(recyclerView: RecyclerView, decor: RecyclerView.ItemDecoration?) {
    decor?.run { recyclerView.addItemDecoration(this) }

}


/**
 * 加载图片
 */
@BindingAdapter(value = ["bind:imgUrl","bind:radius","bind:placeHolder"], requireAll = false)
fun loadImage(view: ImageView, url: String?,radius:Int?,placeHolder:Drawable?) {
        view.load(url,radius=radius?:0,placeholderDrawable = placeHolder)
}