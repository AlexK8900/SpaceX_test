package com.alexk8900.spacex.ui.home_scope.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.alexk8900.spacex.R
import com.alexk8900.spacex.data.rest.dto.Crew
import com.alexk8900.spacex.databinding.CrewBinding

class CrewViewHolder(
    private val binding: CrewBinding,
) : RecyclerView.ViewHolder(binding.root) {

    private val context = itemView.context
    fun bind(model: Crew){
        binding.apply {
            tvName.text = context.getString(R.string.name_of_card, model.name)
            tvAgency.text = context.getString(R.string.agency, model.agency)
            tvStatus.text = context.getString(R.string.status_of_crew, model.status)
        }
    }
}