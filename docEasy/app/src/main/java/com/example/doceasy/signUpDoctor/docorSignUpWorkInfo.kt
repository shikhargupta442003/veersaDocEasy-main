package com.example.doceasy.signUpDoctor

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.doceasy.R
import com.example.doceasy.data.saveDoctorData
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun docSignUpWorkInfo(navController: NavController,email:String?){
    var consultationFees by remember {
        mutableStateOf("")
    }
    var availableHours by remember {
        mutableStateOf("")
    }
    var timeSlots by remember {
        mutableStateOf("")
    }
    val context= LocalContext.current
    var timeslotlist by remember { mutableStateOf(listOf<Pair<String, Int>>()) }
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)) {
            Text(
                "Work Information",
                color = colorResource(id = R.color.theme_color1),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Text(
            text = "Consultation Fees",
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
                value = consultationFees,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Your Consultation Fees",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    consultationFees=it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "Available Hours/Days",
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
                value = availableHours,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Your Available Hours/Days",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    availableHours=it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "Time Slots",
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
                value = timeSlots,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = { Text("Enter Your TimeSlots", fontWeight = FontWeight.Bold) },
                onValueChange = {
                    timeSlots=it
                    timeslotlist= generateTimeSlots(timeSlots)
                }
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 4.dp))


        Button(
            onClick = {
                generateTimeSlots(timeSlots)
                val updates = mutableMapOf<String, Any>()
                updates["email"] = email.toString()
                updates["fees"] = consultationFees
                updates["availableHours"] = availableHours
                updates["timeslotList"] = timeslotlist
                updates["timeSlots"] = timeSlots
                saveDoctorData( email=email.toString(),onSucess = { Toast.makeText(context, "Data saved successfully", Toast.LENGTH_SHORT).show()}, onFailure = { exception->
                    Toast.makeText(context, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()},updates)
                navController.navigate("docSignUpProfessionalInfo/$email")

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
        Button(
            onClick = {},
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .size(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.theme_color1))
        ) {
            Text(text = "Back", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        }
    }
}
fun generateTimeSlots(input:String):List<Pair<String, Int>>{
    val parts = input.split("-")
    if (parts.size < 2) {
        // Return an empty list or throw an error if the input format is incorrect
        return emptyList()
    }
    val start = parts[0].toIntOrNull()
    val end = parts[1].toIntOrNull()

    if (start == null || end == null) {
        // Return an empty list if start or end is not a valid number
        return emptyList()
    }
    val timeSlots = mutableListOf<Pair<String, Int>>()
    val dateFormat = SimpleDateFormat("h:mm", Locale.getDefault())

    for (hour in start until end) {
        var calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, 0)
        }
        while (calendar.get(Calendar.HOUR_OF_DAY) < hour + 1) {
            val startTime = dateFormat.format(calendar.time)
            calendar.add(Calendar.MINUTE, 20)
            val endTime = dateFormat.format(calendar.time)
            if (calendar.get(Calendar.HOUR_OF_DAY) < hour + 1 || (calendar.get(Calendar.HOUR_OF_DAY) == hour + 1 && calendar.get(
                    Calendar.MINUTE) == 0)) {
                timeSlots.add("$startTime-$endTime" to 1)
            }
        }
    }

    return timeSlots
}
