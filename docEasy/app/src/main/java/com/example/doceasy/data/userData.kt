package com.example.doceasy.data

data class userData(
    val email:String="",
    val name:String="",
    val appointmentTime:String="",
    val number:String="",
    val gender:String="",
    val age:String="",
)
fun userData.toMap():Map<String,Any?>{
    return mapOf(
        "email" to email,
        "name" to name,
        "gender" to gender,
        "appointmentTime" to appointmentTime,
        "number" to number
    )
}
