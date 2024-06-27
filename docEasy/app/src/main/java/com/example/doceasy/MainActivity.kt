package com.example.doceasy
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.doceasy.signUpDoctor.SecondActivity
import com.example.doceasy.signUpDoctor.docSignUp
import com.example.doceasy.signUpDoctor.docSignUpContactInfo
import com.example.doceasy.ui.theme.DocEasyTheme
import com.example.doceasy.user.userProfile
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var fusedLocationClient: FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setContent {
            DocEasyTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    userProfile()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    docSignUp()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DocEasyTheme {
        Greeting("Android")
    }
}