package com.isarthaksharma.weatherwink

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.isarthaksharma.weatherwink.databinding.ActivityFutureForecastBinding
import com.squareup.picasso.Picasso

class futureForecast : AppCompatActivity() {
    lateinit var futureBinding:ActivityFutureForecastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        futureBinding = ActivityFutureForecastBinding.inflate(layoutInflater)
        setContentView(futureBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val forcastDate1 =  intent.getStringExtra("forcastDate1")
        val forcastWeather1 = intent.getStringExtra("forcastWeather1")
        val forcastDay1 = intent.getStringExtra("forcastDay1")
        val forcastImage1 = intent.getStringExtra("forcastImage1")
        val forcastMaxTemp1 = intent.getStringExtra("forcastMaxTemp1")
        val forcastMinTemp1 = intent.getStringExtra("forcastMinTemp1")
        val forcastAQI1 = intent.getStringExtra("forcastAQI1")

        futureBinding.clickable1.setOnClickListener {
            if (futureBinding.moreInfo.visibility == View.VISIBLE) {
                futureBinding.moreInfo.visibility = View.GONE
                futureBinding.moreInfoLine.visibility = View.GONE
            } else {
                futureBinding.moreInfo.visibility = View.VISIBLE
                futureBinding.moreInfoLine.visibility = View.VISIBLE
            }
        }

        val forcastDate2 = intent.getStringExtra("forcastDate2")
        val forcastWeather2 = intent.getStringExtra("forcastWeather2")
        val forcastDay2 = intent.getStringExtra("forcastDay2")
        val forcastImage2 = intent.getStringExtra("forcastImage2")
        val forcastMaxTemp2 = intent.getStringExtra("forcastMaxTemp2")
        val forcastMinTemp2 = intent.getStringExtra("forcastMinTemp2")
        val forcastAQI2 = intent.getStringExtra("forcastAQI2")

        futureBinding.clickable2.setOnClickListener {
            if (futureBinding.moreInfo2.visibility == View.VISIBLE) {
                futureBinding.moreInfo2.visibility = View.GONE
                futureBinding.moreInfoLine2.visibility = View.GONE
            } else {
                futureBinding.moreInfo2.visibility = View.VISIBLE
                futureBinding.moreInfoLine2.visibility = View.VISIBLE

            }
        }

        val forcastDate3 = intent.getStringExtra("forcastDate3")
        val forcastWeather3 = intent.getStringExtra("forcastWeather3")
        val forcastDay3 = intent.getStringExtra("forcastDay3")
        val forcastImage3 = intent.getStringExtra("forcastImage3")
        val forcastMaxTemp3 = intent.getStringExtra("forcastMaxTemp3")
        val forcastMinTemp3 = intent.getStringExtra("forcastMinTemp3")
        val forcastAQI3 = intent.getStringExtra("forcastAQI3")

        futureBinding.clickable3.setOnClickListener {
            if (futureBinding.moreInfo3.visibility == View.VISIBLE) {
                futureBinding.moreInfo3.visibility = View.GONE
                futureBinding.moreInfoLine3.visibility = View.GONE
            } else {
                futureBinding.moreInfo3.visibility = View.VISIBLE
                futureBinding.moreInfoLine3.visibility = View.VISIBLE
            }
        }

        futureBinding.forcastDate1.text = forcastDate1
        futureBinding.forcastWeather1.text = forcastWeather1
        futureBinding.forcastDay1.text = forcastDay1
        Picasso.get().load("https:"+forcastImage1).into(futureBinding.forcastImage)
        futureBinding.forcastMaxTemp1.text = forcastMaxTemp1
        futureBinding.forcastMinTemp1.text = forcastMinTemp1
        futureBinding.forcastAQI1.text = forcastAQI1

        futureBinding.forcastDate2.text = forcastDate2
        futureBinding.forcastWeather2.text = forcastWeather2
        futureBinding.forcastDay2.text = forcastDay2
        Picasso.get().load("https:"+forcastImage2).into(futureBinding.forcastImage2)
        futureBinding.forcastMaxTemp2.text = forcastMaxTemp2
        futureBinding.forcastMinTemp2.text = forcastMinTemp2
        futureBinding.forcastAQI2.text = forcastAQI2


        futureBinding.forcastDate3.text = forcastDate3
        futureBinding.forcastWeather3.text = forcastWeather3
        futureBinding.forcastDay3.text = forcastDay3
        Picasso.get().load("https:"+forcastImage3).into(futureBinding.forcastImage3)
        futureBinding.forcastMaxTemp3.text = forcastMaxTemp3
        futureBinding.forcastMinTemp3.text = forcastMinTemp3
        futureBinding.forcastAQI3.text = forcastAQI3

    }
}