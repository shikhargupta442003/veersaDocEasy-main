package com.example.doceasy.user

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.doceasy.R
import com.example.doceasy.data.doctorData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun specialityPage(navController: NavController,email:String?,database: FirebaseDatabase,speciality:String?
) {
    val doctorsListState = remember { mutableStateOf<List<doctorData>>(emptyList()) }
    fetchDoctorsData(database, doctorsListState,speciality)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.back),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(35.dp)
                            // add a border (optional)
                        )

                        Text("$speciality", fontSize = 24.sp)


                    }

                })
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
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
            LazyColumn {
                items(doctorsListState.value){
                    Card(modifier = Modifier
                        .padding(20.dp).fillMaxWidth()
                        .height(160.dp),colors = CardDefaults.cardColors(
                        containerColor = Color(0x0F20201F)
                    )){
                        Row(modifier = Modifier.padding(20.dp)){
                            Image(
                                painter = painterResource(R.drawable.female_doctor),
                                contentDescription = "avatar",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(100.dp)
                                // clip to the circle shape
                                // add a border (optional)
                            )
                            Column(modifier= Modifier.padding(start = 20.dp)){
                                Row(modifier= Modifier.width(200.dp), horizontalArrangement = Arrangement.SpaceBetween){
                                    Text("${it.name}")
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
                                Spacer(modifier= Modifier.padding(vertical=4.dp))
                                Text("bsbfsnfiosvshsnsknfosinf")

                                Row(modifier= Modifier.width(200.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
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
private fun fetchDoctorsData(
    database: FirebaseDatabase,
    doctorsListState: MutableState<List<doctorData>>,
    specialty: String?
) {
    val doctorsRef = database.getReference("doctors")

    doctorsRef.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val doctorsList = mutableListOf<doctorData>()

            for (doctorSnapshot in snapshot.children) {
                val doctor = doctorSnapshot.getValue(doctorData::class.java)
                doctor?.let {item->
                    Log.d("DoctorData", "Doctor: $item") // Log the doctor data
                    if (item.specialization != specialty) {
                        Log.d("FilterMatch", "Specialization matched: ${item.specialization}")
                        doctorsList.add(item)
                    } else {
                        Log.d("FilterMismatch", "Specialization did not match: ${item.specialization}")
                    }
                }
            }

            doctorsListState.value = doctorsList
            Log.d("doctorslistsize",doctorsListState.value.toString())
        }
        override fun onCancelled(error: DatabaseError) {
            // Handle database error
        }
    })
}