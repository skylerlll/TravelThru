package com.example.travelthru

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ConverterActivity : AppCompatActivity() {
    var gmt: Int = 0

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        val time = arrayListOf<TextView>(findViewById(R.id.time00),
            findViewById(R.id.time01),
            findViewById(R.id.time02),
            findViewById(R.id.time03),
            findViewById(R.id.time04),
            findViewById(R.id.time05),
            findViewById(R.id.time06),
            findViewById(R.id.time07),
            findViewById(R.id.time08),
            findViewById(R.id.time09),
            findViewById(R.id.time10),
            findViewById(R.id.time11),
            findViewById(R.id.time12),
            findViewById(R.id.time13),
            findViewById(R.id.time14),
            findViewById(R.id.time15),
            findViewById(R.id.time16),
            findViewById(R.id.time17),
            findViewById(R.id.time18),
            findViewById(R.id.time19),
            findViewById(R.id.time20),
            findViewById(R.id.time21),
            findViewById(R.id.time22),
            findViewById(R.id.time23)
        )

        val bundle: Bundle? = intent.extras
        if (bundle!=null) {
            val getGmt = bundle.getString("GMT") // 1
            if (getGmt != null) {
                this.gmt = getGmt.toInt()
            }
        }

        for (i in 0..23) {
            var newTime = i + gmt
            if (newTime > 23) {
                newTime -= 24
                time[i].text = "+1 day $newTime :00"
            } else if (newTime < 0) {
                newTime +=24
                time[i].text = "-1 day $newTime :00"
            } else {
                time[i].text = "$newTime :00"
            }

            if (newTime < 7 || newTime > 20) {
                time[i].setBackgroundColor(R.color.purple_200)
                time[i].setTextColor(R.color.white)
            }
        }
    }
}