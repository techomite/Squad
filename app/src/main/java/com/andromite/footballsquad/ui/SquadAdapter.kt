package com.andromite.footballsquad.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andromite.api.data.entities.Squad
import com.andromite.footballsquad.R
import com.andromite.footballsquad.databinding.SquadListLayoutBinding

class SquadAdapter : ListAdapter<Squad,SquadAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Squad>(){
    override fun areItemsTheSame(oldItem: Squad, newItem: Squad): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Squad, newItem: Squad): Boolean {
        return oldItem.squadName == newItem.squadName
    }
}) {


    class ViewHolder(view :View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.context.getSystemService(LayoutInflater::class.java).inflate(R.layout.squad_list_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val squad = getItem(position)
        SquadListLayoutBinding.bind(holder.itemView).apply {
            nameTextView.text = squad.squadName
            playersTextView.text = squad.squadPlayed.toString()
            winTextView.text = squad.squadWinned.toString()
            loseTextView.text = squad.squadLoosed.toString()
            pointsTextView.text = squad.squadPoints.toString()
        }
    }


}

