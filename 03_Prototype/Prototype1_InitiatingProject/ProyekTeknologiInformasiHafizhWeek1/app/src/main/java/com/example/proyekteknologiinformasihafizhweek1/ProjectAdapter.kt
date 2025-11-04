package com.example.proyekteknologiinformasihafizhweek1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectAdapter(private val items: List<Project>) :
    RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    inner class ProjectViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvOwner: TextView = view.findViewById(R.id.tvOwner)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_project, parent, false)
        return ProjectViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = items[position]
        holder.tvTitle.text = project.title
        holder.tvOwner.text = "Owner: ${project.owner}"
        holder.tvDate.text = "Start: ${project.startDate}"

        holder.itemView.setOnClickListener { view ->
            val ctx = view.context
            val intent = Intent(ctx, ProjectDetailActivity::class.java)
            intent.putExtra("project", project)
            ctx.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}