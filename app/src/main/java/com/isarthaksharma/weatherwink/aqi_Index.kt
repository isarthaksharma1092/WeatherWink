package com.isarthaksharma.weatherwink

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.isarthaksharma.weatherwink.databinding.ActivityAqiIndexBinding

class aqi_Index : AppCompatActivity() {

    private lateinit var aqiBinding: ActivityAqiIndexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        aqiBinding = ActivityAqiIndexBinding.inflate(layoutInflater)
        setContentView(aqiBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve the AQI data passed from MainActivity
        val pm10 = intent.getStringExtra("PM10")
        val pm25 = intent.getStringExtra("PM2_5")
        val so2 = intent.getStringExtra("SO2")
        val no2 = intent.getStringExtra("NO2")
        val co = intent.getStringExtra("CO")
        val o3 = intent.getStringExtra("O3")

        aqiBinding.pm25.text = pm25
        aqiBinding.pm10Again.text = pm10
        aqiBinding.pm10.text = pm10
        aqiBinding.SO2.text = so2
        aqiBinding.O3.text = o3
        aqiBinding.no2.text = no2
        aqiBinding.co.text = co
    }
}