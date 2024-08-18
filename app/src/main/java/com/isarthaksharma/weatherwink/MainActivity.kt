package com.isarthaksharma.weatherwink

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.isarthaksharma.weatherwink.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val TAG:String = "Errors"
    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private var longitude: Double = 0.0
    private var latitude: Double = 0.0
    private var recevied_Location= ""
    private lateinit var dataSetting: DataSetting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        //shimmer
        mainBinding.shimmerLayout.visibility = View.VISIBLE
        mainBinding.appUi.visibility = View.GONE
        mainBinding.shimmerLayout.startShimmer()

        //location permission
        requestPermissions()
        // response fetching
        fetchWeatherData()
        //setting data after getting response
        dataSetting = DataSetting(mainBinding)

        mainBinding.main.setOnRefreshListener {
            mainBinding.shimmerLayout.visibility = View.VISIBLE
            mainBinding.appUi.visibility = View.GONE
            mainBinding.shimmerLayout.startShimmer()
            requestPermissions()
            fetchWeatherData()
            dataSetting = DataSetting(mainBinding)

            // Stop the refreshing animation
            mainBinding.main.isRefreshing = false
        }

        mainBinding.addCities.setOnClickListener {
            startActivity(Intent(this@MainActivity,manageCities::class.java))
        }
    }

    private fun fetchWeatherData() {
        lifecycleScope.launch {
            delay(1000L)
            //requesting the network
            val response = try {
                //creating instance
                Retrofit_Instance.createRetrofit.weatherRequest(recevied_Location)
            } catch (e: IOException) {
                Log.d(TAG, "IOException: ${e.message}")
                Toast.makeText(this@MainActivity, "Check your internet connection.", Toast.LENGTH_LONG).show()
                return@launch
            } catch (e: HttpException) {
                Log.d(TAG, "HttpException: ${e.message}")
                Toast.makeText(this@MainActivity, "Server error: ${e.message}", Toast.LENGTH_LONG).show()
                return@launch
            }

            // handling the request made [NO internet issue & NO location issue found]
            if (response.isSuccessful && response.body() != null) {
                val weatherData = response.body()
                Log.d(TAG, "Response Body: ${response.body()}")
                weatherData?.let {
                    dataSetting.setCurrentWeather(it)
                    dataSetting.setMoonSunTime(it)
                    dataSetting.setHourlyTemp(it)
                    dataSetting.setAqi(it)
                }


                Toast.makeText(this@MainActivity, "Weather data fetched successfully!", Toast.LENGTH_LONG).show()
                mainBinding.shimmerLayout.stopShimmer()
                mainBinding.shimmerLayout.visibility = View.GONE
                mainBinding.appUi.visibility = View.VISIBLE


            } else {
                val errorBody = response.errorBody()?.string() // Get the error message from the server
                Log.d(TAG, "Error Response Code: ${response.code()} - Error Body: $errorBody")
                Toast.makeText(this@MainActivity, "Something went wrong! Code: ${response.code()}", Toast.LENGTH_LONG).show()
            }
        }
    }

    // requesting the user current Location of device
    private fun requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 1000)
        } else {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
            fusedLocationProviderClient.lastLocation.addOnCompleteListener {
                if (it.isSuccessful && it.result != null) {
                    longitude = it.result.longitude
                    latitude = it.result.latitude
                    recevied_Location = "${latitude},${longitude}"
                } else {
                    Toast.makeText(this, "Unable to get location", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                requestPermissions()
            } else {
                Toast.makeText(this, "Enable all permissions in App Settings", Toast.LENGTH_LONG).show()
                val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", packageName, null)
                }
                startActivity(intent)
                finish()
            }
        }
    }
}
