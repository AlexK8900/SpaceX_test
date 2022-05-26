package com.alexk8900.spacex.ui.home_scope.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.alexk8900.spacex.application.extensions.onClicked
import com.alexk8900.spacex.databinding.ShowMoreButtonBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@FlowPreview
class ShowMoreButtonViewHolder(
    binding: ShowMoreButtonBinding,
    private val showMore: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.showMore.onClicked()
            .debounce(500)
            .onEach { showMore() }
            .launchIn(CoroutineScope(Dispatchers.Main.immediate))
    }
}