package com.example.doceasy.signUpUser

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.doceasy.R
import com.example.doceasy.data.doctorData
import com.example.doceasy.data.saveDoctorData


@Composable
fun userPersonalDetails(navController: NavController) {
    var age by remember {
        mutableStateOf("")
    }
    var gender by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }

    val context= LocalContext.current
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)) {
            Text(
                "User Sign Up",
                color = colorResource(id = R.color.theme_color1),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Text(
            text = "Enter Age",
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
                value = age,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Your Age",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    age=it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "Enter Gender",
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
                value = gender,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Your Gender",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    gender=it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))

        Text(
            text = "Enter Phone",
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
                value = phone,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Your Phone",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    phone=it
                }
            )
        }

        Button(
            onClick = {
                val doctor=doctorData(
                    age = age,
                    gender = gender,
                    phone = phone,
                )
                saveDoctorData(doctor, onSucess = { Toast.makeText(context, "Data saved successfully", Toast.LENGTH_SHORT).show()}, onFailure = {exception->
                    Toast.makeText(context, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()})
                navController.navigate("docSignUpContactInfo")
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .size(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.theme_color1))
        ) {
            Text(text = "Next", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        }
    }
}
