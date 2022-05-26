package com.alexk8900.spacex.domain.repositories

import com.alexk8900.spacex.data.model.Card
import com.alexk8900.spacex.data.rest.dto.Crew

interface CardRepository {
    suspend fun getCards(page: Int): List<Card>
    suspend fun getCrewPerson(id: String): Crew
}