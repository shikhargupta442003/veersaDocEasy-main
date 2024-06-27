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
)
fun doctorData.toMap():Map<String,Any?>{
    return mapOf(
        "email" to email,
        "name" to name,
        "gender" to gender,
        "dob" to dob,
        "profilePic" to profilePic,
        "mobileNo" to mobileNo,
        "address" to address,
        "state" to state,
        "pinCode" to pinCode,
        "medicalLicenseNumber" to medicalLicenseNumber,
        "specialization" to specialization,
        "experience" to experience,
        "qualifications" to qualifications,
        "affiliations" to affiliations,
        "fees" to fees,
        "availableHours" to availableHours,
        "timeSlots" to timeSlots,
        "license" to license,
        "idProof" to idProof,
        "qualificationProof" to qualificationProof,
        "paymentMethod" to paymentMethod,
        "insurancePartner" to insurancePartner,
        "emergencyContact" to emergencyContact,
        "password" to password,
        "timeslotList" to timeslotList
    )
}
fun saveDoctorData(doctor:doctorData,onSucess:()->Unit,onFailure:(Exception)->Unit){
    val db=Firebase.database
    val doctorsRef=db.getReference("doctors")
    val emailVal=doctor.email
    val encodedEmail=emailVal.toString().replace(".",",")
    val doctorRef=doctorsRef.child(encodedEmail)
    val doctorMap=doctor.toMap()
    doctorRef.updateChildren(doctorMap).addOnSuccessListener {
        onSucess()
    }
        .addOnFailureListener { exception->
            onFailure(exception)
        }
}
