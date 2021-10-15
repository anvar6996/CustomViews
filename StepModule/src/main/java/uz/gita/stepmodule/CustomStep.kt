package uz.gita.stepmodule

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import uz.gita.stepmodule.utils.dp
import uz.gita.stepmodule.utils.sp

class CustomStep @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStayle: Int = 0
) : View(context, attributeSet, defStayle) {

    private val paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.GREEN
    }
    private val paintText = Paint().apply {
        textSize = 17.sp
        color = Color.BLACK
    }
    private val paintLine = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 4.dp
        color = Color.BLACK
    }
    private var count: Int = 5

    init {
        val attr = context.obtainStyledAttributes(attributeSet, R.styleable.CustomStep, 0, 0)
        count = attr.getInt(R.styleable.CustomStep_count, 5)
        attr.recycle()
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            val radius = width / (count) / 2f * 0.8f
            val padding = radius / count * 2.5f
            for (i in 0 until count) {
                it.drawCircle(i * 2 * radius + radius + padding * i, height / 2f, radius, paint)
            }
            val bounds = Rect()
            paintText.getTextBounds("1", 0, 1, bounds)
            val textH = bounds.height()
            val textW = bounds.width()
            it.drawText(

                "1",
                radius - textW,
                height / 2f + textH / 2,
                paintText
            )
            it.drawText(
                "2",
                radius * 3 - textW + padding,
                height / 2f + textH / 2,
                paintText
            )
            it.drawText(
                "3",
                radius * 6 - textW,
                height / 2f + textH / 2,
                paintText
            )
            it.drawText(
                "4",
                radius * 8 + padding - textW,
                height / 2f + textH / 2,
                paintText
            )
            it.drawText(
                "5",
                radius * 11 - textW,
                height / 2f + textH / 2,
                paintText
            )

            it.drawLine(radius * 2, height / 2f, 2 * radius + padding, height / 2f, paintLine)
            it.drawLine(radius * 5, height / 2f, 4 * radius + padding, height / 2f, paintLine)
            it.drawLine(radius * 7, height / 2f, 7 * radius + padding, height / 2f, paintLine)
            it.drawLine(radius * 10, height / 2f, 9 * radius + padding, height / 2f, paintLine)


        }

    }

}