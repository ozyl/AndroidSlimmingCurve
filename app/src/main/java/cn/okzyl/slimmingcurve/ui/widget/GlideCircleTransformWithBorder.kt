package com.wander.baseframe.view.glide

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest


class GlideCircleTransformWithBorder : BitmapTransformation {
    private var mBorderPaint: Paint?=null
    private var mBorderWidth: Float=0.toFloat()

    constructor(context: Context) {

    }

    constructor(context: Context, borderWidth: Int, borderColor: Int) {

        mBorderWidth = Resources.getSystem().getDisplayMetrics().density * borderWidth

        mBorderPaint = Paint().apply{
            isDither = true
            isAntiAlias = true
            color = borderColor
            style = Paint.Style.STROKE
            strokeWidth = mBorderWidth
        }
    }


    protected override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap? {
        return circleCrop(pool, toTransform)
    }

    private fun circleCrop(pool: BitmapPool, source: Bitmap?): Bitmap? {
        if (source == null) return null

        val size = (Math.min(source.width, source.height) - mBorderWidth / 2).toInt()
        val x = (source.width - size) / 2
        val y = (source.height - size) / 2
        // TODO this could be acquired from the pool too
        val squared = Bitmap.createBitmap(source, x, y, size, size)
        val result = pool.get(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(result)
        val paint = Paint()
        paint.shader = BitmapShader(squared, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.setAntiAlias(true)
        val r = size / 2f
        canvas.drawCircle(r, r, r, paint)
        if (mBorderPaint != null) {
            val borderRadius = r - mBorderWidth / 2
            canvas.drawCircle(r, r, borderRadius, mBorderPaint!!)
        }
        return result
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {

    }

}