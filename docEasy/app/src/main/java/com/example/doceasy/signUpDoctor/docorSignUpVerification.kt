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
fun docSignUpVerification(){
    Column(modifier= Modifier
        .padding(horizontal = 20.dp)
        .fillMaxWidth()){
        Box (modifier=Modifier.padding(horizontal = 20.dp, vertical = 24.dp)){
            Text("Verification Documents", color = colorResource(id = R.color.theme_color1), fontSize = 24.sp, fontWeight = FontWeight.ExtraBold )
        }
        Text(text = "Media License Copy", fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier=Modifier.padding(vertical = 8.dp))
        Box(modifier=Modifier.clip(RoundedCornerShape(12.dp)).background(color = colorResource(id = R.color.box_inside_color))){
            OutlinedTextField(
                value = "",
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("", color= colorResource(id = R.color.box_hint_color), fontWeight = FontWeight.Bold) },
                onValueChange = {
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(text = "ID Proof", fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier=Modifier.padding(bottom = 8.dp))
        Box(modifier=Modifier.clip(RoundedCornerShape(12.dp)).background(color = colorResource(id = R.color.box_inside_color))){
            OutlinedTextField(
                value = "",
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("", color= colorResource(id = R.color.box_hint_color), fontWeight = FontWeight.Bold) },
                onValueChange = {
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(text = "Proof of Qualifications", fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier=Modifier.padding(bottom = 8.dp))
        Box(modifier=Modifier.clip(RoundedCornerShape(12.dp)).background(color = colorResource(id = R.color.box_inside_color))) {
            OutlinedTextField(
                value = "",
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("", fontWeight = FontWeight.Bold) },
                onValueChange = {
                }
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 4.dp))

    }
}