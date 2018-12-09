package com.rubenexposito.themoviedblistapp.presentation.common

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView

class PortraitLandscapeRatioImageView @JvmOverloads constructor(
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
            val height = MeasureSpec.getSize(heightMeasureSpec)
            val width = Math.ceil(height.toFloat() * 0.666666667).toInt()
            setMeasuredDimension(width, height)
        } ?: super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}