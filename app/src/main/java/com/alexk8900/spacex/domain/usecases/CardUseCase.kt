package com.alexk8900.spacex.domain.usecases

import com.alexk8900.spacex.data.model.Card
import kotlinx.coroutines.flow.StateFlow


interface CardUseCase {
    val cardsFlow: StateFlow<List<Card>>
    suspend fun initCards()
    suspend fun addCards()
}