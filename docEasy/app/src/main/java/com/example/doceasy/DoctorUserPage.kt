package com.example.doceasy


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DoctorUserPage(navController: NavController) {


    val context= LocalContext.current

Column(modifier=Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center) {
    Button(
        onClick = {
            navController.navigate("userSignUp")
        },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .size(52.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.theme_color1))
    ) {
        Text(text = "User", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
    }


    Button(
        onClick = {
            navController.navigate("docSignUpLoginTerms")
        },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .size(52.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.theme_color1))
    ) {
        Text(text = "Doctor", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
    }

}

}
