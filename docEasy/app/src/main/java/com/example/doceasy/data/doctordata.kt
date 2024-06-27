package com.example.doceasy.data

import com.google.firebase.Firebase
import com.google.firebase.database.database

data class doctorData(
    val email:String="",
    val name:String="",
    val age:String="",
    val phone:String="",
    val gender:String="",
    val dob:String="",
    val profilePic:String="",
    val mobileNo:String="",
    val address:String="",
    val state:String="",
    val pinCode:String="",
    val medicalLicenseNumber:String="",
    val specialization:String="",
    val experience:String="",
    val qualifications:String="",
    val affiliations:String="",
    val fees:String="",
    val availableHours:String="",
    val timeSlots:String="0-0",
    val license:String="",
    val idProof:String="",
    val qualificationProof:String="",
    val paymentMethod:String="",
    val insurancePartner:String="",
    val emergencyContact:String="",
    val password:String="",
    val timeslotList: List<Pair<String, Int>> = listOf(),
    val locationMaps:String=""
)

fun saveDoctorData(email: String,onSucess:()->Unit,onFailure:(Exception)->Unit,updates:MutableMap<String,Any>){
    val db=Firebase.database
    val doctorsRef=db.getReference("doctors")
    val encodedEmail=email.replace(".",",")
    val doctorRef=doctorsRef.child(encodedEmail)
    doctorRef.updateChildren(updates).addOnSuccessListener {
        onSucess()
    }
        .addOnFailureListener { exception->
            onFailure(exception)
        }
}
