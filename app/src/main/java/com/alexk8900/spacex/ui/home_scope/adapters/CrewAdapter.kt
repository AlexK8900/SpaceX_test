package com.alexk8900.spacex.ui.home_scope.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexk8900.spacex.data.rest.dto.Crew
import com.alexk8900.spacex.databinding.CrewBinding
import com.alexk8900.spacex.ui.home_scope.viewholders.CrewViewHolder

class CrewAdapter(context: Context) :
    ListAdapter<Crew, RecyclerView.ViewHolder>(CrewDiffItemCallback()) {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return CrewViewHolder(
            CrewBinding.inflate(
                layoutInflater,
                parent,
                false
            ),
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val item = currentList[position]
        if (holder is CrewViewHolder) {
            holder.bind(item)
        }
    }
}

class CrewDiffItemCallback : DiffUtil.ItemCallback<Crew>() {
    override fun areItemsTheSame(oldItem: Crew, newItem: Crew): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Crew, newItem: Crew): Boolean =
        false
}