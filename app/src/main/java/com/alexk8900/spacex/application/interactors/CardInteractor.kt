package com.alexk8900.spacex.application.interactors

import android.annotation.SuppressLint
import com.alexk8900.spacex.data.model.Card
import com.alexk8900.spacex.domain.repositories.CardRepository
import com.alexk8900.spacex.domain.usecases.CardUseCase
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import javax.inject.Inject

class CardInteractor
@Inject constructor(
    private val cardRepository: CardRepository
) : CardUseCase {
    companion object {
        private const val timePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        const val ADD_MORE = "addMore"
    }

    private val cards = mutableListOf<Card>()
    private var page = 1
    override val cardsFlow = MutableStateFlow<List<Card>>(listOf())

    override suspend fun initCards() {
        if (cards.isNullOrEmpty()) {
            cards.clear()
            addCards()
        }
    }

    @SuppressLint("SimpleDateFormat")
    override suspend fun addCards() {
        page++
        if(cards.isNotEmpty()){
            cards.remove(cards.last())
        }
        val currentCards = cardRepository.getCards(page)
        addCrew(currentCards)
        cards.addAll(currentCards.map {
            val simpleDate = SimpleDateFormat(timePattern)
            it.date = simpleDate.parse(it.dateUtc)
            it
        })
        if(cards.size % 10 == 0){
            cards.add(Card(id = ADD_MORE))
        }
        val listOfCard = mutableListOf<Card>()
        listOfCard.addAll(cards)
        cardsFlow.value = listOfCard
    }

    private suspend fun addCrew(cards: List<Card>) {
        val notEmptyCrew = cards.filter { it.crewIds.isNotEmpty() }
        if (notEmptyCrew.isNotEmpty()) {
            notEmptyCrew.map { card ->
                card.crewIds.map {
                    val crew = cardRepository.getCrewPerson(it)
                    card.crew.add(crew)
                }
            }
        }
    }

}

