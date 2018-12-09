package com.rubenexposito.themoviedblistapp.presentation.common

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView

class LandscapeRatioImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {
    private var path = Path()
    private var rect: RectF? = null

    override fun onDraw(canvas: Canvas?) {
        rect = RectF(0f, 0f, width.toFloat(), height.toFloat())

        path.addRoundRect(rect, 0f, 0f, Path.Direction.CW)
        canvas?.clipPath(path)
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        drawable?.let {
            val width = MeasureSpec.getSize(widthMeasureSpec)
            val height = Math.ceil(width.toFloat() * 0.5625).toInt()
            setMeasuredDimension(width, height)
        } ?: super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}