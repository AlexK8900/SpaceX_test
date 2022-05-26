package com.alexk8900.spacex.ui.home_scope

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexk8900.spacex.R
import com.alexk8900.spacex.data.model.Card
import com.alexk8900.spacex.databinding.FragmentHomeBinding
import com.alexk8900.spacex.ui.common.BaseMvvmFragment
import com.alexk8900.spacex.ui.home_scope.adapters.CardAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BaseMvvmFragment<HomeViewModel, FragmentHomeBinding>() {
    companion object {
        const val CARD_ID = "cardId"
    }

    override val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val scope = CoroutineScope(Dispatchers.Main.immediate)


    private val cardAdapter by lazy {
        CardAdapter(requireContext(),
            { openCard(it) },
            { scope.launch { viewModel.showMore() } }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCards.apply {
            adapter = cardAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                RecyclerView.VERTICAL,
                false
            )
        }

        scope.launch {
            viewModel.observeCards().collect { cards ->
                cardAdapter.submitList(cards)
            }
        }
        scope.launch {
            viewModel.initCards()
        }
    }

    private fun openCard(card: Card) {
        findNavController().navigate(
            R.id.action_homeFragment_to_descriptionFragment,
            bundleOf(CARD_ID to card)
        )
    }
}