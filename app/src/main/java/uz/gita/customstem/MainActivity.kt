package uz.gita.customstem

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import uz.gita.stepmodule.CustomSpeed

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttons).setOnClickListener {
            findViewById<CustomSpeed>(R.id.speedometr).minValue =
                findViewById<CustomSpeed>(R.id.speedometr).minValue + 50
        }
    }
}