package com.example.doceasy.data

data class Specialist(val id: Int, val name: String){
companion object {
    val predefinedSpecialists = listOf(
        Specialist(1, "Cardiology"),
        Specialist(2, "Dermatology"),
        Specialist(3, "Endocrinology"),
        Specialist(4, "Gastroenterology"),
        Specialist(5, "Hematology"),
        Specialist(6, "Nephrology"),
        Specialist(7, "Neurology"),
        Specialist(8, "Obstetrics"),
        Specialist(9, "Oncology"),
        Specialist(10, "Ophthalmology"),
        Specialist(11, "Orthopedics"),
        Specialist(12, "Otolaryngology (ENT)"),
        Specialist(13, "Pediatrics"),
        Specialist(14, "Psychiatry"),
        Specialist(15, "Pulmonology"),
        Specialist(16, "Rheumatology"),
        Specialist(17, "Urology"),
        Specialist(18, "Allergy "),
        Specialist(19, "Anesthesiology"),
        Specialist(20, "Critical Care "),
        Specialist(21, "Emergency Medicine"),
        Specialist(22, "Family Medicine"),
        Specialist(23, "Geriatrics"),
        Specialist(24, "Genetics"),
        Specialist(25, "Infectious Disease"),
        Specialist(26, "Internal Medicine"),
        Specialist(27, "Nuclear Medicine"),
        Specialist(28, "Pathology"),
        Specialist(29, "Physiatry"),
        Specialist(30, "Plastic Surgery"),
        Specialist(31, "Radiology"),
        Specialist(32, "Sports Medicine"),
        Specialist(33, "Thoracic Surgery"),
        Specialist(34, "Vascular Surgery"),
        Specialist(35, "Occupational Medicine"),
        Specialist(36, "Pain Medicine")
    )
}}
