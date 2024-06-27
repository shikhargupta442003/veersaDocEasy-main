package com.example.doceasy.signUpDoctor

import android.Manifest
import android.annotation.SuppressLint
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doceasy.R
import com.example.doceasy.data.doctorData
import com.example.doceasy.data.saveDoctorData
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class SecondActivity : ComponentActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setContent {
            MaterialTheme {
                docSignUpContactInfo(fusedLocationClient = fusedLocationClient)
            }
        }
    }
}

@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun docSignUpContactInfo(fusedLocationClient: FusedLocationProviderClient) {

    val locationPermissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    var location by remember { mutableStateOf<Location?>(null) }
    var clinicAddress by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var pincode by remember { mutableStateOf("") }
    var locationvalue by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)) {
            Text(
                "Contact Information",
                color = colorResource(id = R.color.theme_color1),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Text(
            text = "Clinic/Hospital Address",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(color = colorResource(id = R.color.box_inside_color))
        ) {
            OutlinedTextField(
                value = clinicAddress,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Your Clinic/Hospital Address",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    clinicAddress = it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "State",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(color = colorResource(id = R.color.box_inside_color))
        ) {
            OutlinedTextField(
                value = state,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Your State",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    state = it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "Pincode",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(color = colorResource(id = R.color.box_inside_color))
        ) {
            OutlinedTextField(
                value = pincode,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("Enter Your Pincode", fontWeight = FontWeight.Bold) },
                onValueChange = {
                    pincode = it
                }
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "Location on Maps",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(color = colorResource(id = R.color.box_inside_color))
        ) {
            OutlinedTextField(
                value = locationvalue,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    locationvalue = it
                }
            )
        }

        if (locationPermissionState.allPermissionsGranted) {
            Button(
                onClick = {
                    fusedLocationClient.lastLocation.addOnSuccessListener { loc: Location? ->
                        loc?.let {
                            location = it
                            val geocoder = Geocoder(context, Locale.getDefault())
                            val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                            if (addresses != null) {
                                if (addresses.isNotEmpty()) {
                                    locationvalue = addresses[0].getAddressLine(0)
                                } else {
                                    Toast.makeText(context, "Unable to get address", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue))
            ) {
                Text(text = "Get Location", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
            }
            location?.let {

            }
        } else {
            Button(onClick = { locationPermissionState.launchMultiplePermissionRequest() }) {
                Text("Request Location Permission")
            }
        }

        Button(
            onClick = {
                val doctor = doctorData(
                    address = clinicAddress,
                    state = state,
                    pinCode = pincode
                )
                saveDoctorData(
                    doctor,
                    onSucess = {
                        Toast.makeText(
                            context,
                            "Data saved successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    onFailure = { exception ->
                        Toast.makeText(
                            context,
                            "Error: ${exception.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    })

            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.theme_color1))
        ) {
            Text(text = "Next", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        }
    }
}
