package com.alexk8900.spacex.ui.home_scope.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexk8900.spacex.application.interactors.CardInteractor
import com.alexk8900.spacex.data.model.Card
import com.alexk8900.spacex.databinding.CardBinding
import com.alexk8900.spacex.databinding.ShowMoreButtonBinding
import com.alexk8900.spacex.ui.home_scope.viewholders.CardViewHolder
import com.alexk8900.spacex.ui.home_scope.viewholders.ShowMoreButtonViewHolder

class CardAdapter(
    context: Context,
    private val open:(id: Card) -> Unit,
    private val showMore:() -> Unit) :
    ListAdapter<Card, RecyclerView.ViewHolder>(CardDiffItemCallback()) {
    companion object{
        private const val CARD = 1
        private const val SHOW_MORE_BUTTON = 2
    }

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when(viewType){
            CARD -> CardViewHolder(
                CardBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                ),
                open
            )
            SHOW_MORE_BUTTON -> ShowMoreButtonViewHolder(
                ShowMoreButtonBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                ),
                showMore
            )
            else -> throw IllegalArgumentException("Invalid viewType[$viewType]")
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val item = currentList[position]
        if (holder is CardViewHolder) {
            holder.bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(currentList[position].id == CardInteractor.ADD_MORE){
            SHOW_MORE_BUTTON
        } else {
            CARD
        }
    }
}

class CardDiffItemCallback : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean =
        false
}