package com.example.doceasy.data

import com.google.firebase.Firebase
import com.google.firebase.database.database

data class userData(
    val email:String="",
    val name:String="",
    val appointmentTime:String="",
    val number:String="",
    val gender:String="",
    val age:String="",
    val password:String=""
)
fun savePatientData(email: String,onSucess:()->Unit,onFailure:(Exception)->Unit,updates:MutableMap<String,Any>){
    val db= Firebase.database
    val doctorsRef=db.getReference("patients")
    val encodedEmail=email.replace(".",",")
    val doctorRef=doctorsRef.child(encodedEmail)
    doctorRef.updateChildren(updates).addOnSuccessListener {
        onSucess()
    }
        .addOnFailureListener { exception->
            onFailure(exception)
        }
}
