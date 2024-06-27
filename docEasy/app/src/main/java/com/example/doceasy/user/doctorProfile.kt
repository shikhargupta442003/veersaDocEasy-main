package com.example.doceasy.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doceasy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun docProfileUser(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,            // crop the image if it's not a square
                            modifier = Modifier
                                .size(20.dp)
                            // add a border (optional)
                        )

                        Text("All Doctors", fontSize = 16.sp)


                    }

                })
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp), colors = CardDefaults.cardColors(
                    containerColor = Color(0x0F20201F)
                )
            ) {
                Row(modifier = Modifier.padding(20.dp)) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .size(100.dp)
                        // clip to the circle shape
                        // add a border (optional)
                    )
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        Row(
                            modifier = Modifier.width(200.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Dr. Pawan")
                            Image(
                                painter = painterResource(R.drawable.ic_launcher_background),
                                contentDescription = "avatar",
                                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                modifier = Modifier
                                    .size(24.dp)
                                // clip to the circle shape
                                // add a border (optional)
                            )
                        }
                        Spacer(modifier = Modifier.padding(vertical = 4.dp))
                        Text("Speciality")

                        Row(
                            modifier = Modifier.width(200.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Consultation Fees: Rs120.00",)

                        }
                    }


                }
            }
            Text("Details", fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
            Text("dnskfnioenf skn fsv dnskfnioenf skn fsvdnskfnioenf skn fsvdnskfnioenf skn fsvdnskfnioenf skn fsvdnskfnioenf skn fsvdnskfnioenf skn fsv ")

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            ) {
                Text("TimeSlot")
                Text("See All")
            }
            LazyRow {
                items(3) {
                    Card(
                        modifier = Modifier
                            .padding(20.dp)
                            .width(120.dp)
                            .height(50.dp), colors = CardDefaults.cardColors(
                            containerColor = Color(0xff00de8e)
                        )
                    ) {
                        Text(
                            "$it", textAlign = TextAlign.Center, modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            ) {
                Text("Date")
                Text("See All")
            }
            LazyRow {
                items(3) {
                    Card(
                        modifier = Modifier
                            .padding(20.dp)
                            .width(120.dp)
                            .height(50.dp), colors = CardDefaults.cardColors(
                            containerColor = Color(0xff00de8e)
                        )
                    ) {
                        Text(
                            "$it", textAlign = TextAlign.Center, modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
            Button(
                onClick = {

                   },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .size(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.theme_color1))
            ) {
                Text(text = "Book an Appointment", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
            }
        }
    }
}