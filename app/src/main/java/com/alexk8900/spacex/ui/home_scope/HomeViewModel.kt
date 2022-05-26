package com.alexk8900.spacex.ui.home_scope

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexk8900.spacex.domain.usecases.CardUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel
@Inject constructor(
    private val cardUseCase: CardUseCase
) : ViewModel() {

    fun observeCards() = cardUseCase.cardsFlow

    suspend fun initCards() {
        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            cardUseCase.initCards()
        }
    }

    suspend fun showMore() {
        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            Log.e("LOGS", "SHOW MORE")
            cardUseCase.addCards()
        }
    }
}
