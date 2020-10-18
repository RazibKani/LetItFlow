package id.codepresso.letitflow.domain.usecase

import id.codepresso.letitflow.data.Resource
import id.codepresso.letitflow.data.entity.CatFact
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Razib Kani Maulidan on 18/10/20.
 **/

interface GetCatFactsUseCase {
    operator fun invoke(): Flow<Resource<List<CatFact>>>
}