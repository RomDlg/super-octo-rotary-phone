package fr.limentic_romdlg.super_octo_rotary_phone

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.locationcomponent.location
import java.util.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private lateinit var mapview: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Init map & style
        mapview = findViewById(R.id.mapView)
        mapview.getMapboxMap().loadStyleUri(Style.DARK)
        object : Style.OnStyleLoaded {
            override fun onStyleLoaded(style: Style) {
                mapview.location.updateSettings {
                    enabled = true;
                    pulsingEnabled = true;
                }
            }
        }
        //Check if permissions needed are granted & ask if not
        if (checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            locationPermissionRequest.launch(arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION))
        }
    }


    //Function to ask for location permissions
    val locationPermissionRequest = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions())
    {
        permissions -> when {
            permissions.getOrDefault(android.Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                Toast.makeText(this, "Coarse location granted", Toast.LENGTH_SHORT)
            }
        permissions.getOrDefault(android.Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
            Toast.makeText(this, "Fine location granted", Toast.LENGTH_SHORT)
            } else -> {
            Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT)
            }
        }
    }
}