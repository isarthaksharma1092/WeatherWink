package com.isarthaksharma.weatherwink

import android.annotation.SuppressLint
import android.content.Intent
import com.isarthaksharma.weatherwink.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import java.time.LocalDate

@SuppressLint("SetTextI18n")
class DataSetting(private val mainBinding: ActivityMainBinding) {

    fun setCurrentWeather(data: dataClass_Weather) {
        mainBinding.locationName.text = data.location.name
        mainBinding.dateTime.text = LocalDate.now().dayOfWeek.name
        mainBinding.currentWeather.text = data.current.condition.text
        mainBinding.currentTemperature.text = "${data.current.temp_c} ℃"

        mainBinding.currWind.text = "${data.current.wind_kph} Km/h"
        mainBinding.currHumidity.text = "${data.current.humidity} %"
        mainBinding.airPressure.text = "${data.current.pressure_mb} mb"
        mainBinding.currFeelsTemp.text = "${data.current.feelslike_c} ℃"
        mainBinding.currVisibility.text = "${data.current.vis_km} Km"
        mainBinding.uv.text = "${data.current.uv} nm"

        mainBinding.snowChance.text = "${data.forecast.forecastday[0].day.daily_chance_of_snow} %"
        mainBinding.rainChance.text = "${data.forecast.forecastday[0].day.daily_chance_of_rain} %"
        mainBinding.minTemp.text = "${data.forecast.forecastday[0].day.mintemp_c} ℃"
        mainBinding.maxTemp.text = "${data.forecast.forecastday[0].day.maxtemp_c} ℃"
    }

    fun setMoonSunTime(data: dataClass_Weather) {
        //sunset
        mainBinding.sunriseTime.text = data.forecast.forecastday[0].astro.sunrise
        //sunrise
        mainBinding.sunsetTime.text = data.forecast.forecastday[0].astro.sunset
        //moonset
        mainBinding.moonriseTime.text = data.forecast.forecastday[0].astro.moonrise
        //moonrise
        mainBinding.moonsetTime.text = data.forecast.forecastday[0].astro.moonset
    }

    fun setHourlyTemp(data: dataClass_Weather) {
        //0
        mainBinding.temp12am.text = "${data.forecast.forecastday[0].hour[0].temp_c} ℃"
        mainBinding.temp12amConditions.text = data.forecast.forecastday[0].hour[0].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[0].condition.icon).into(mainBinding.img12am)
        // 1
        mainBinding.temp1am.text = "${data.forecast.forecastday[0].hour[1].temp_c} ℃"
        mainBinding.temp1amConditions.text = data.forecast.forecastday[0].hour[1].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[1].condition.icon).into(mainBinding.img1am)

        // 2
        mainBinding.temp2am.text = "${data.forecast.forecastday[0].hour[2].temp_c} ℃"
        mainBinding.temp2amConditions.text = data.forecast.forecastday[0].hour[2].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[2].condition.icon).into(mainBinding.img2am)

        // 3
        mainBinding.temp3am.text = "${data.forecast.forecastday[0].hour[3].temp_c} ℃"
        mainBinding.temp3amConditions.text = data.forecast.forecastday[0].hour[3].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[3].condition.icon).into(mainBinding.img3am)

        // 4
        mainBinding.temp4am.text = "${data.forecast.forecastday[0].hour[4].temp_c} ℃"
        mainBinding.temp4amConditions.text = data.forecast.forecastday[0].hour[4].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[4].condition.icon).into(mainBinding.img4am)

        // 5
        mainBinding.temp5am.text = "${data.forecast.forecastday[0].hour[5].temp_c} ℃"
        mainBinding.temp5amConditions.text = data.forecast.forecastday[0].hour[5].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[5].condition.icon).into(mainBinding.img5am)

        // 6
        mainBinding.temp6am.text = "${data.forecast.forecastday[0].hour[6].temp_c} ℃"
        mainBinding.temp6amConditions.text = data.forecast.forecastday[0].hour[6].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[6].condition.icon).into(mainBinding.img6am)

        // 7
        mainBinding.temp7am.text = "${data.forecast.forecastday[0].hour[7].temp_c} ℃"
        mainBinding.temp7amConditions.text = data.forecast.forecastday[0].hour[7].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[7].condition.icon).into(mainBinding.img7am)

        // 8
        mainBinding.temp8am.text = "${data.forecast.forecastday[0].hour[8].temp_c} ℃"
        mainBinding.temp8amConditions.text = data.forecast.forecastday[0].hour[8].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[8].condition.icon).into(mainBinding.img8am)

        // 9
        mainBinding.temp9am.text = "${data.forecast.forecastday[0].hour[9].temp_c} ℃"
        mainBinding.temp9amConditions.text = data.forecast.forecastday[0].hour[9].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[9].condition.icon).into(mainBinding.img9am)

        // 10
        mainBinding.temp10am.text = "${data.forecast.forecastday[0].hour[10].temp_c} ℃"
        mainBinding.temp10amConditions.text = data.forecast.forecastday[0].hour[10].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[10].condition.icon).into(mainBinding.img10am)

        // 11
        mainBinding.temp11am.text = "${data.forecast.forecastday[0].hour[11].temp_c} ℃"
        mainBinding.temp11amConditions.text = data.forecast.forecastday[0].hour[11].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[11].condition.icon).into(mainBinding.img11am)

        // 12
        mainBinding.temp12pm.text = "${data.forecast.forecastday[0].hour[12].temp_c} ℃"
        mainBinding.temp12pmConditions.text = data.forecast.forecastday[0].hour[12].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[12].condition.icon).into(mainBinding.img12pm)

        // 13
        mainBinding.temp1pm.text = "${data.forecast.forecastday[0].hour[13].temp_c} ℃"
        mainBinding.temp1pmConditions.text = data.forecast.forecastday[0].hour[13].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[13].condition.icon).into(mainBinding.img1pm)

        // 14
        mainBinding.temp2pm.text = "${data.forecast.forecastday[0].hour[14].temp_c} ℃"
        mainBinding.temp2pmConditions.text = data.forecast.forecastday[0].hour[14].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[14].condition.icon).into(mainBinding.img2pm)

        // 15
        mainBinding.temp3pm.text = "${data.forecast.forecastday[0].hour[15].temp_c} ℃"
        mainBinding.temp3pmConditions.text = data.forecast.forecastday[0].hour[15].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[15].condition.icon).into(mainBinding.img3pm)

        // 16
        mainBinding.temp4pm.text = "${data.forecast.forecastday[0].hour[16].temp_c} ℃"
        mainBinding.temp4pmConditions.text = data.forecast.forecastday[0].hour[16].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[16].condition.icon).into(mainBinding.img4pm)

        // 17
        mainBinding.temp5pm.text = "${data.forecast.forecastday[0].hour[17].temp_c} ℃"
        mainBinding.temp5pmConditions.text = data.forecast.forecastday[0].hour[17].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[17].condition.icon).into(mainBinding.img5pm)

        // 18
        mainBinding.temp6pm.text = "${data.forecast.forecastday[0].hour[18].temp_c} ℃"
        mainBinding.temp6pmConditions.text = data.forecast.forecastday[0].hour[18].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[18].condition.icon).into(mainBinding.img6pm)

        // 19
        mainBinding.temp7pm.text = "${data.forecast.forecastday[0].hour[19].temp_c} ℃"
        mainBinding.temp7pmConditions.text = data.forecast.forecastday[0].hour[19].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[19].condition.icon).into(mainBinding.img7pm)

        // 20
        mainBinding.temp8pm.text = "${data.forecast.forecastday[0].hour[20].temp_c} ℃"
        mainBinding.temp8pmConditions.text = data.forecast.forecastday[0].hour[20].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[20].condition.icon).into(mainBinding.img8pm)

        // 21
        mainBinding.temp9pm.text = "${data.forecast.forecastday[0].hour[21].temp_c} ℃"
        mainBinding.temp9pmConditions.text = data.forecast.forecastday[0].hour[21].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[21].condition.icon).into(mainBinding.img9pm)

        // 22
        mainBinding.temp10pm.text = "${data.forecast.forecastday[0].hour[22].temp_c} ℃"
        mainBinding.temp10pmConditions.text = data.forecast.forecastday[0].hour[22].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[22].condition.icon).into(mainBinding.img10pm)

        // 23
        mainBinding.temp11pm.text = "${data.forecast.forecastday[0].hour[23].temp_c} ℃"
        mainBinding.temp11pmConditions.text = data.forecast.forecastday[0].hour[23].condition.text
        Picasso.get().load("https:"+data.forecast.forecastday[0].hour[23].condition.icon).into(mainBinding.img11pm)

    }

    fun setAqi(data: dataClass_Weather){
        val pm10 = data.current.air_quality.pm10.toString()
        val pm2_5 = data.current.air_quality.pm2_5.toString()
        val so2 = data.current.air_quality.so2.toString()
        val no2 = data.current.air_quality.no2.toString()
        val co = data.current.air_quality.co.toString()
        val o3 = data.current.air_quality.o3.toString()

        mainBinding.currAqi.text = pm10
        val intentAQI = Intent(mainBinding.root.context,aqi_Index::class.java)
        intentAQI.putExtra("PM10", pm10)
        intentAQI.putExtra("PM2_5", pm2_5)
        intentAQI.putExtra("SO2", so2)
        intentAQI.putExtra("NO2", no2)
        intentAQI.putExtra("CO", co)
        intentAQI.putExtra("O3", o3)

        mainBinding.airqualityLayout.setOnClickListener {
            mainBinding.root.context.startActivity(intentAQI)
        }
    }
}
