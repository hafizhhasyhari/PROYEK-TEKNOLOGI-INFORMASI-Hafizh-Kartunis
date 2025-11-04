package com.example.proyekteknologiinformasihafizhweek1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ProjectDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_detail)

        // Ambil data project dari intent
        val project = intent.getSerializableExtra("project") as? Project

        // Ambil komponen UI dari layout
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvOwner = findViewById<TextView>(R.id.tvOwner)
        val tvDate = findViewById<TextView>(R.id.tvDate)
        val tvDesc = findViewById<TextView>(R.id.tvDesc)

        // Tampilkan data ke layar
        project?.let {
            tvTitle.text = it.title
            tvOwner.text = "Owner: ${it.owner}"
            tvDate.text = "Start: ${it.startDate}"
            tvDesc.text = it.description
        }
    }
}