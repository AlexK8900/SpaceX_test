package com.alexk8900.spacex.data.repositories

import com.alexk8900.spacex.data.rest.Api
import com.alexk8900.spacex.data.rest.dto.Crew
import com.alexk8900.spacex.data.rest.dto.Options
import com.alexk8900.spacex.data.rest.dto.Query
import com.alexk8900.spacex.data.rest.dto.Request
import com.alexk8900.spacex.domain.repositories.CardRepository
import javax.inject.Inject

class CardRepositoryImpl
@Inject constructor(
    private val api: Api
) : CardRepository {
    override suspend fun getCards(page: Int) =
        api.getLaunches(Request(Query(), Options("field -date_unix", 10, page))).docs.map {
            it.toModel()
        }.filter { it.dateUtc != null && it.dateUtc.substringBefore("-").toInt() > 2020 }

    override suspend fun getCrewPerson(id: String): Crew =
        api.getCrew(id)



}