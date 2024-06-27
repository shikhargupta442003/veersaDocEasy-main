package com.example.doceasy
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.doceasy.signUpDoctor.docSignUp
import com.example.doceasy.signUpDoctor.docSignUpAdditionalInfo
import com.example.doceasy.signUpDoctor.docSignUpContactInfo
import com.example.doceasy.signUpDoctor.docSignUpLoginTerms
import com.example.doceasy.signUpDoctor.docSignUpProfessionalInfo
import com.example.doceasy.signUpDoctor.docSignUpWorkInfo
import com.example.doceasy.signUpUser.userPersonalDetails
import com.example.doceasy.signUpUser.userSignUp
import com.example.doceasy.ui.theme.DocEasyTheme
import com.example.doceasy.user.allCategories
import com.example.doceasy.user.allDoctors
import com.example.doceasy.user.docProfileUser
import com.example.doceasy.user.userProfile
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var auth: FirebaseAuth
        auth=FirebaseAuth.getInstance()
        lateinit var fusedLocationClient: FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setContent {
            DocEasyTheme {
                val navController= rememberNavController()
                NavHost(navController = navController, startDestination = "userSignUp" ){
                    composable("docSignUp/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        docSignUp(navController = navController, email = email)
                    }
                    composable("docSignUpProfessionalInfo/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        docSignUpProfessionalInfo(navController=navController, email = email)
                    }
                    composable("docSignUpContactInfo/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        docSignUpContactInfo(navController=navController, fusedLocationClient, email = email)
                    }
                    composable("docSignUpWorkInfo/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        docSignUpWorkInfo(navController=navController, email = email)
                    }
                    composable("docSignUpLoginTerms"){
                        docSignUpLoginTerms(navController=navController,auth)
                    }
                    composable("docSignUpAdditionalInfo/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        docSignUpAdditionalInfo(navController=navController, email = email)
                    }
                    composable("userPersonalDetails/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        userPersonalDetails(navController=navController,email)
                    }
                    composable("docProfileUser/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        docProfileUser(navController=navController,email)
                    }
                    composable("userSignUp"){
                        userSignUp(navController=navController,auth)
                    }
                    composable("userProfile/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        userProfile(navController=navController,email)
                    }
                    composable("docProfileUser/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        docProfileUser(navController=navController,email)
                    }
                    composable("allDoctors/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        allDoctors(navController=navController,email)
                    }
                    composable("allCategories/{email}"){
                            backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email")
                        allCategories(navController=navController,email)
                    }

                }

            }
        }
    }
}

