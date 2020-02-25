package cn.okzyl.slimmingcurve.app

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import cn.okzyl.slimmingcurve.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.wander.baseframe.view.glide.GlideCircleTransformWithBorder
import timber.log.Timber

fun <T> ImageView.load(
    img: T, placeholder: Int? = null, placeholderDrawable: Drawable? = null, circle: Boolean? = false
    , radius: Int = 0, borderWidth: Int = 0, borderColorResId: Int = R.color.colorWhite
    , error: RequestBuilder<Drawable>? = null, loadError: ((GlideException?) -> Unit)? = null
) {
    val imgWrapper: Any? = when (img) {
        is String -> {
            if (img.isNotEmpty() && img.first().toString() == "#") {
                ColorDrawable(Color.parseColor(img))
            } else {
                img as Any?
            }
        }
        else -> img
    }
    val glideRequest = Glide.with(this).load(imgWrapper).apply {
        placeholder?.let { placeholder(it) }
        placeholderDrawable?.let { placeholder(it) }
        error?.let { error(error) }
        if (radius != 0) {
            transform(RoundedCorners(radius))
        }
        if (circle == true) {
            transform(CircleCrop())
        }
        if (borderWidth != 0) {
            transform(
                GlideCircleTransformWithBorder(
                    context,
                    borderWidth,
                    getColor(borderColorResId)
                )
            )
        }
        //解决过度动画导致placeholder残留问题 https://www.jianshu.com/p/28f5bcee409f
        val drawableCrossFadeFactory =
            DrawableCrossFadeFactory.Builder(300).setCrossFadeEnabled(true).build()
        transition(DrawableTransitionOptions().crossFade(drawableCrossFadeFactory))
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Timber.w("图片加载错误==》路径：${img}，失败信息：${e}")
                    loadError?.invoke(e)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    Timber.i("图片预加载成功==》${img}")
                    return false
                }

            })
        thumbnail(0.5f)
    }
    glideRequest.into(this)
}

fun getColor(colorResId:Int)=ContextCompat.getColor(SCApp.instance,colorResId)
fun getDrawable(resId:Int)=ContextCompat.getDrawable(SCApp.instance,resId)