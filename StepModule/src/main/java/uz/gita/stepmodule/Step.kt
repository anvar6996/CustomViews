package uz.gita.stepmodule

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import uz.gita.stepmodule.utils.sp

class Step @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0) :
    View(context, attr, defStyle) {

    private val paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.RED
    }
    private val paint2 = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 5.sp
        color = Color.BLACK
    }
    private val paintImg = Paint().apply {


    }


    private val paintText = Paint().apply {
        textSize = 20.sp
        color = Color.WHITE
    }
    private var count = 5

    override fun onDraw(canvas: Canvas) {
        val radius = width / (count) / 2f * 0.45f
        val padding = radius / count * 8.5f
        for (i in 0 until count) {
            canvas.drawCircle(i * 2 * radius + radius + padding * i, height / 2f, radius, paint)
        }
        val bounds = Rect()
        paintText.getTextBounds("1", 0, 1, bounds)
        val textHeight = bounds.height()
        val textWidth = bounds.width()
        canvas.drawText(
            "1",
            radius - textWidth,
            height / 2f + textHeight / 2,
            paintText
        )

        canvas.drawText(
            "2",
            radius * 3 + padding - textWidth,
            height / 2f + textHeight / 2,
            paintText
        )
        canvas.drawText(
            "3",
            radius * 5 + padding * 2 - textWidth,
            height / 2f + textHeight / 2,
            paintText
        )
        canvas.drawText(
            "4",
            radius * 7 + padding * 3 - textWidth,
            height / 2f + textHeight / 2,
            paintText
        )
        canvas.drawText(
            "5",
            radius * 9 + padding * 4 - textWidth,
            height / 2f + textHeight / 2,
            paintText
        )
        canvas.drawLine(
            radius * 2,
            height / 2f,
            radius * 2 + padding,
            height / 2f,
            paint2
        )
        canvas.drawLine(
            radius * 4 + padding,
            height / 2f,
            radius * 4 + padding * 2,
            height / 2f,
            paint2
        )
        canvas.drawLine(
            radius * 6 + padding * 2,
            height / 2f,
            radius * 6 + padding * 3,
            height / 2f,
            paint2
        )
        canvas.drawLine(
            radius * 8 + padding * 3,
            height / 2f,
            radius * 8 + padding * 4,
            height / 2f,
            paint2
        )

    }
}