package uz.gita.stepmodule

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.lang.Math.PI

class CustomSpeed @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defItem: Int = 0
) : View(context, attributeSet, defItem) {
    private var cordX = 0f
    private var cordY = 0f
    private var radius = 0f
    private var alpha = 0

    private val centerX get() = width / 2f

    private val centerY get() = height / 2f
    private val painSpeed = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 40f
    }

    private val state = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }
    private var maxValue: Int = 100
    var minValue: Int = 20
        set(value) {
            field = value
        }

    init {
        val attr = context.obtainStyledAttributes(attributeSet, R.styleable.CustomSpeed, 0, 0)
        maxValue = attr.getInt(R.styleable.CustomSpeed_maxValue, 100)
        minValue = attr.getInt(R.styleable.CustomSpeed_minValue, 20)
        attr.recycle()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            cordX = width / 2f
            cordY = height.toFloat()
            val minAmount = kotlin.math.min(width / 2, height)
            radius = minAmount - 20f

            canvas.drawCircle(cordX, cordY, 60f, state)
            canvas.drawCircle(cordX, cordY, radius, painSpeed)

            alpha = 180 - minValue * 180 / maxValue // 60 tezlik
            canvas.drawLine(cordX, cordY, getStopX(alpha), getStopY(alpha), painSpeed)
        }

    }

    private fun getStopX(alpha: Int): Float {
        return (cordX + kotlin.math.cos(alpha * PI / 180) * radius).toFloat()
    }

    private fun getStopY(alpha: Int): Float {
        return (cordY - kotlin.math.sin(alpha * PI / 180) * radius).toFloat()
    }
}