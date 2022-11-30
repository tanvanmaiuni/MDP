package com.mdp.cvbuilderapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdp.cvbuilderapp.model.WorkExperience
import kotlinx.android.synthetic.main.work_detail.view.*

class WorkExperienceAdapter(val context: Context, val workExperienceList: MutableList<WorkExperience>):
    RecyclerView.Adapter<WorkExperienceAdapter.WorkExperienceViewHolder>() {

    inner class WorkExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkExperienceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.work_detail, parent, false)
        return WorkExperienceViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkExperienceViewHolder, position: Int) {
        val workExperience = workExperienceList[position]
        holder.itemView.txtTitle.text = workExperience.title
        holder.itemView.txtCompany.text = workExperience.company
        holder.itemView.txtDuration.text = workExperience.duration
        holder.itemView.txtLocation.text = workExperience.location
        holder.itemView.imageView.setImageResource(workExperience.image)
    }

    override fun getItemCount(): Int {
        return workExperienceList.size
    }
}