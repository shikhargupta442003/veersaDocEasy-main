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
import com.example.doceasy.ui.theme.DocEasyTheme
import com.example.doceasy.user.allCategories
import com.example.doceasy.user.allDoctors
import com.example.doceasy.user.docProfileUser
import com.example.doceasy.user.userProfile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DocEasyTheme {
                val navController= rememberNavController()
                NavHost(navController = navController, startDestination = "docSignUpLoginTerms" ){
                    composable("docSignUp"){
                        docSignUp(navController=navController)
                    }
                    composable("docProfileUser"){
                        docProfileUser(navController=navController)
                    }
                    composable("docSignUpProfessionalInfo"){
                        docSignUpProfessionalInfo(navController=navController)
                    }
                    composable("docSignUpContactInfo"){
                        docSignUpContactInfo(navController=navController)
                    }
                    composable("docSignUpWorkInfo"){
                        docSignUpWorkInfo(navController=navController)
                    }
                    composable("docSignUpLoginTerms"){
                        docSignUpLoginTerms(navController=navController)
                    }
                    composable("docSignUpAdditionalInfo"){
                        docSignUpAdditionalInfo(navController=navController)
                    }
                    composable("userProfile"){
                        userProfile(navController=navController)
                    }
                    composable("docProfileUser"){
                        docProfileUser(navController=navController)
                    }
                    composable("allDoctors"){
                        allDoctors(navController=navController)
                    }
                    composable("allCategories"){
                        allCategories(navController=navController)
                    }

                }

            }
        }
    }
}

