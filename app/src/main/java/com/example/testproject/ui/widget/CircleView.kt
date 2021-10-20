package com.example.testproject.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val outerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GRAY
    }
    private val innerPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    fun setCircleBackground(color: String) {
        innerPaint.color = Color.parseColor(color)
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas ?: return

        val w = width
        val h = height

        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 2).toFloat(), outerPaint)

        val radius = (width / 2) - width / 20
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(),
            radius.toFloat(), innerPaint)
    }
}