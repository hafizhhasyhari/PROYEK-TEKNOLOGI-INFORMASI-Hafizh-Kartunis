package com.example.proyekteknologiinformasihafizhweek1

import java.io.Serializable

// Data class untuk menyimpan data project
data class Project(
    var title: String,
    var description: String,
    var owner: String,
    var startDate: String
) : Serializable