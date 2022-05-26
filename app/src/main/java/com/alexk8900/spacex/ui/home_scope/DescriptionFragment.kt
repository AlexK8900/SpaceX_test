package com.alexk8900.spacex.ui.home_scope

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.dispose
import coil.load
import com.alexk8900.spacex.R
import com.alexk8900.spacex.data.model.Card
import com.alexk8900.spacex.databinding.FragmentDescriptionBinding
import com.alexk8900.spacex.ui.common.BaseMvvmFragment
import com.alexk8900.spacex.ui.home_scope.HomeFragment.Companion.CARD_ID
import com.alexk8900.spacex.ui.home_scope.adapters.CrewAdapter
import java.text.SimpleDateFormat

class DescriptionFragment :
    BaseMvvmFragment<DescriptionViewModel, FragmentDescriptionBinding>() {
    companion object {
        private const val timePattern = "hh-mm dd-MM-yyyy"
    }

    override val viewModel: DescriptionViewModel by viewModels { viewModelFactory }

    override fun getViewBinding(): FragmentDescriptionBinding =
        FragmentDescriptionBinding.inflate(layoutInflater)

    private val crewAdapter by lazy { CrewAdapter(requireContext()) }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val card = arguments?.get(CARD_ID) as Card
        binding.apply {
            ivIcon.dispose()
            if (!card.bigIcon.isNullOrEmpty()) {
                ivIcon.load(card.bigIcon)
            } else {
                ivIcon.isVisible = false
            }
            tvName.text = "${card.name}"
            tvFlight.text = requireContext().getString(
                R.string.count_of_flight,
                card.flight.toString()
            )
            tvStatus.text = requireContext().getString(
                R.string.status_of_card,
                if (card.status == true) requireContext().getString(
                    R.string.ok_status
                )
                else requireContext().getString(R.string.fail_status)
            )
            tvDetails.isVisible =
                !card.details.isNullOrEmpty()
            tvDetails.text = card.details
            val dateFormat = SimpleDateFormat(timePattern)
            val dateString = dateFormat.format(card.date)
            tvDate.text = requireContext().getString(
                R.string.date_of_flight,
                dateString
            )

            if (card.crew.isNotEmpty()) {
                tvCrew.isVisible = true
                rvCrew.apply {
                    adapter = crewAdapter
                    layoutManager = LinearLayoutManager(
                        requireContext(),
                        RecyclerView.VERTICAL,
                        false
                    )
                }
                rvCrew.isNestedScrollingEnabled = false
                crewAdapter.submitList(card.crew)
            } else {
                tvCrew.isVisible = false
            }
        }

    }
}
