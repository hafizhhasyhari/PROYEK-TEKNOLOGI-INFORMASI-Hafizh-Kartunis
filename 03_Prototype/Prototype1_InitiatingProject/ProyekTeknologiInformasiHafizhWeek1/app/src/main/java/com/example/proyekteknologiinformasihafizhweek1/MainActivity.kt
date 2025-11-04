package com.example.proyekteknologiinformasihafizhweek1

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyekteknologiinformasihafizhweek1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val projects = mutableListOf<Project>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data awal contoh
        projects.add(
            Project("Aplikasi Jadwal Kuliah", "Sistem jadwal kampus sederhana", "Hafizh", "2025-11-04")
        )
        projects.add(
            Project("Absensi QR", "Sistem absensi menggunakan QR Code", "Tim RPL", "2025-11-05")
        )

        setupRecycler()
        binding.fabAdd.setOnClickListener { showAddDialog() }
    }

    private fun setupRecycler() {
        val adapter = ProjectAdapter(projects)
        binding.rvProjects.layoutManager = LinearLayoutManager(this)
        binding.rvProjects.adapter = adapter
    }

    private fun showAddDialog() {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_add_project, null)

        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val etOwner = view.findViewById<EditText>(R.id.etOwner)
        val etDate = view.findViewById<EditText>(R.id.etDate)
        val etDesc = view.findViewById<EditText>(R.id.etDesc)

        AlertDialog.Builder(this)
            .setTitle("Tambah Project Baru")
            .setView(view)
            .setPositiveButton("Simpan") { d, _ ->
                val title = etTitle.text.toString().ifBlank { "Untitled Project" }
                val owner = etOwner.text.toString().ifBlank { "Unknown" }
                val date = etDate.text.toString().ifBlank { "2025-11-01" }
                val desc = etDesc.text.toString().ifBlank { "-" }
                projects.add(Project(title, desc, owner, date))
                binding.rvProjects.adapter?.notifyItemInserted(projects.size - 1)
                d.dismiss()
            }
            .setNegativeButton("Batal") { d, _ -> d.dismiss() }
            .show()
    }
}