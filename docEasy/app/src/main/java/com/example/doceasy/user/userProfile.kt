package com.example.doceasy.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.doceasy.R
import com.example.doceasy.data.Specialist

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun userProfile(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title={
                    Row(
                        modifier=Modifier.fillMaxWidth()
                    ){
                        Column {
                            Spacer(modifier = Modifier.padding(start = 10.dp, top = 20.dp))

                            Image(
                                painter = painterResource(R.drawable.user),
                                contentDescription = "avatar",
                                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)                       // clip to the circle shape

                                //.border(2.dp, Color.Black, CircleShape) // add a border (optional)
                            )
                        }
                        Column(Modifier.padding(start = 24.dp, top = 12.dp)) {

                            Text("Hi, Welcome Back,", fontSize = 16.sp)
                            Text("Shikhar Gupta")
                        }
                        Box(modifier= Modifier
                            .padding(start = 100.dp)
                            .align(Alignment.CenterVertically)){
                            Image(
                                painter = painterResource(R.drawable.notification_bell),
                                contentDescription = "Notification",
                                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                modifier = Modifier
                                    .size(24.dp)
                                    .offset(y = 8.dp)
                                // add a border (optional)
                            )
                        }

                    }

                })

        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = false, onClick = { /*TODO*/ },icon = {
                    Icon(
                        painterResource(id = R.drawable.ic_launcher_background),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "upload"
                    )
                },
                    label = {Text("Expenses")})
                NavigationBarItem(selected = false, onClick = { /*TODO*/ },icon = {
                    Icon(
                        painterResource(id = R.drawable.ic_launcher_background),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "upload"
                    )
                },
                    label = {Text("Expenses")})
                NavigationBarItem(selected = false, onClick = { /*TODO*/ },icon = {
                    Icon(
                        painterResource(id = R.drawable.ic_launcher_background),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "upload"
                    )
                },
                    label = {Text("Expenses")})
                NavigationBarItem(selected = false, onClick = { /*TODO*/ },icon = {
                    Icon(
                        painterResource(id = R.drawable.ic_launcher_background),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "upload"
                    )
                },
                    label = {Text("Expenses")})
            }
        }
    ) {innerPadding->
        Column(modifier=Modifier.padding(innerPadding)){
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 24.dp)
                    .fillMaxWidth()
                    .height(60.dp)
            ) {

                OutlinedTextField(
                    value = "Search ...",
                    shape = RoundedCornerShape(12.dp),

                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.microphone),
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(21.dp)
                        )

                    },
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(280.dp)
                        .padding(end = 10.dp)
                )

            }
            Card(modifier= Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(horizontal = 30.dp, vertical = 10.dp), colors = CardDefaults.cardColors(
                containerColor = Color(0xff0b8fac),
            )) {
                Row(modifier = Modifier.padding(top = 20.dp)){
                    Column(modifier= Modifier
                        .width(200.dp)
                        .padding(start = 10.dp)){
                        Text("Medical Center", color = Color.White, fontSize = 20.sp)
                        Text("Yorem ipsum dolor sit amett. Nunc vulputate libero et velit interdum.", fontSize = 10.sp,color = Color.White, modifier = Modifier.padding(end = 10.dp))

                    }

                    Image(
                        painter = painterResource(R.drawable.male_doctor),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .size(100.dp)
                        // clip to the circle shape
                        // add a border (optional)
                    )
                }
            }
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),horizontalArrangement = Arrangement.SpaceBetween){
                Text("Categories")
                Text("See All")
            }
            LazyRow {
                items(Specialist.predefinedSpecialists){specialist->
                    Card(modifier = Modifier
                        .padding(10.dp)
                        .width(120.dp)
                        .height(50.dp),colors = CardDefaults.cardColors(
                        containerColor = Color(0xff00de8e))) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "${specialist.name}",
                                color = Color.White,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(horizontal = 8.dp)
                                    .fillMaxWidth(),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1

                            )
                        }
                    }

                }
            }
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),horizontalArrangement = Arrangement.SpaceBetween){
                Text("All Doctors")
                Text("See All")
            }
            LazyColumn {
                items(20){
                    Card(modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(160.dp),colors = CardDefaults.cardColors(
                        containerColor = Color(0x0F20201F)
                    )){
                        Row(modifier = Modifier.padding(20.dp)){
                                Image(
                                    painter = painterResource(R.drawable.male_surgon),
                                    contentDescription = "avatar",
                                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                    modifier = Modifier
                                        .size(100.dp)
                                    // clip to the circle shape
                                    // add a border (optional)
                                )
                            Column(modifier=Modifier.padding(start = 20.dp)){
                                Row(modifier=Modifier.width(200.dp), horizontalArrangement = Arrangement.SpaceBetween){
                                    Text("Dr. Pawan")
                                    Image(
                                        painter = painterResource(R.drawable.heart_431),
                                        contentDescription = "avatar",
                                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                        modifier = Modifier
                                            .size(24.dp)
                                        // clip to the circle shape
                                        // add a border (optional)
                                    )
                                }
                                Spacer(modifier=Modifier.padding(vertical=4.dp))
                                Text("bsbfsnfiosvshsnsknfosinf")

                                Row(modifier=Modifier.width(200.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                                    Button(onClick = {}){
                                        Text("Book", )
                                    }
                                    Row(){
                                        Image(
                                            painter = painterResource(R.drawable.star),
                                            contentDescription = "avatar",
                                            contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                            modifier = Modifier
                                                .size(24.dp)
                                            // clip to the circle shape
                                            // add a border (optional)
                                        )
                                        Text("5.0")
                                    }

                                }
                            }


                        }
                    }
                }
            }
        }

    }
}