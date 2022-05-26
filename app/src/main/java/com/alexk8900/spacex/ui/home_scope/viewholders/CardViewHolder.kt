package com.alexk8900.spacex.ui.home_scope.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import coil.dispose
import coil.load
import com.alexk8900.spacex.R
import com.alexk8900.spacex.data.model.Card
import com.alexk8900.spacex.databinding.CardBinding
import java.text.SimpleDateFormat

class CardViewHolder(
    private val binding: CardBinding,
    private val open: (id: Card) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        private const val timePattern = "dd-MM-yyyy"
    }

    private val context = itemView.context

    @SuppressLint("SimpleDateFormat")
    fun bind(model: Card) {
        binding.apply {
            itemView.setOnClickListener {
                open(model)
            }
            ivIcon.dispose()
            if (!model.smallIcon.isNullOrEmpty()) {
                ivIcon.load(model.smallIcon)
            } else {
                ivIcon.setImageBitmap(null)
            }
            tvName.text =
                context.getString(R.string.name_of_card, model.name.toString())
            tvFlight.text = context.getString(
                R.string.count_of_flight,
                model.flight?.toString()
            )
            tvStatus.text = context.getString(
                R.string.status_of_card,
                if (model.status == true) context.getString(R.string.ok_status)
                else context.getString(R.string.fail_status)
            )
            val dateFormat = SimpleDateFormat(timePattern)
            val dateString = dateFormat.format(model.date)
            tvDate.text = context.getString(R.string.date_of_flight, dateString)
        }
    }
}