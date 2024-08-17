package com.isarthaksharma.weatherwink

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.isarthaksharma.weatherwink.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val TAG:String = "Errors"
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var longitude: Double = 0.0
    private var latitude: Double = 0.0

    private var recevied_Location= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        // Request location permissions
        requestPermissions()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lifecycleScope.launch {
            delay(2000L)
            val response = try {
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

            if (response.isSuccessful && response.body() != null) {
                Log.d(TAG, "Response Body: ${response.body()}")
                Toast.makeText(this@MainActivity, "Weather data fetched successfully!", Toast.LENGTH_LONG).show()
            } else {
                val errorBody = response.errorBody()?.string() // Get the error message from the server
                Log.d(TAG, "Error Response Code: ${response.code()} - Error Body: $errorBody")
                Toast.makeText(this@MainActivity, "Something went wrong! Code: ${response.code()}", Toast.LENGTH_LONG).show()
            }
        }
    }

    // Request location permissions and fetch location
    private fun requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Request permissions
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 1000)
        } else {
            // Permissions already granted, fetch location
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
            fusedLocationProviderClient.lastLocation.addOnCompleteListener {
                if (it.isSuccessful && it.result != null) {
                    longitude = it.result.longitude
                    latitude = it.result.latitude
                    recevied_Location="${latitude},${longitude}"
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
                // Permission granted, fetch location
                requestPermissions()
            } else {
                // Permission denied, show app info
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
