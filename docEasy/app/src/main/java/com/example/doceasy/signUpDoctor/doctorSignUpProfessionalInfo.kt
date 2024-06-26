package com.example.doceasy.signUpDoctor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doceasy.R

@Composable
fun docSignUpProfessionalInfo(){
    Column(modifier= Modifier
        .padding(horizontal = 20.dp)
        .fillMaxWidth()){
        Box (modifier=Modifier.padding(horizontal = 20.dp, vertical = 24.dp)){
            Text("Professional Information", color = colorResource(id = R.color.theme_color1), fontSize = 24.sp, fontWeight = FontWeight.ExtraBold )
        }
        Text(text = "Medical License Number", fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier=Modifier.padding(vertical = 8.dp))
        Box(modifier=Modifier.clip(RoundedCornerShape(12.dp)).background(color = colorResource(id = R.color.box_inside_color))){
            OutlinedTextField(
                value = "",
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("Enter Your Medical License Number", color= colorResource(id = R.color.box_hint_color), fontWeight = FontWeight.Bold) },
                onValueChange = {
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(text = "Specilization", fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier=Modifier.padding(bottom = 8.dp))
        Box(modifier=Modifier.clip(RoundedCornerShape(12.dp)).background(color = colorResource(id = R.color.box_inside_color))){
            OutlinedTextField(
                value = "",
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("Enter Your Specilization", color= colorResource(id = R.color.box_hint_color), fontWeight = FontWeight.Bold) },
                onValueChange = {
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(text = "Years of Experience", fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier=Modifier.padding(bottom = 8.dp))
        Box(modifier=Modifier.clip(RoundedCornerShape(12.dp)).background(color = colorResource(id = R.color.box_inside_color))) {
            OutlinedTextField(
                value = "",
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("Enter Your Years of Experience", fontWeight = FontWeight.Bold) },
                onValueChange = {
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(text = "Qualification", fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier=Modifier.padding(bottom = 8.dp))
        Box(modifier=Modifier.clip(RoundedCornerShape(12.dp)).background(color = colorResource(id = R.color.box_inside_color))) {
            OutlinedTextField(
                value = "",
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("Enter Your Qualifications", fontWeight = FontWeight.Bold) },
                onValueChange = {
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(text = "Affiliations", fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier=Modifier.padding(bottom = 8.dp))
        Box(modifier=Modifier.clip(RoundedCornerShape(12.dp)).background(color = colorResource(id = R.color.box_inside_color))) {
            OutlinedTextField(
                value = "",
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("Enter Your Affiliations", fontWeight = FontWeight.Bold) },
                onValueChange = {
                }
            )
        }


    }
}