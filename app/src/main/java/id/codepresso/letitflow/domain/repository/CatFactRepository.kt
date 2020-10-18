package id.codepresso.letitflow.domain.repository

import id.codepresso.letitflow.data.Resource
import id.codepresso.letitflow.data.entity.CatFact
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Razib Kani Maulidan on 10/10/20.
 **/

interface CatFactRepository {

    fun getCatFacts(): Flow<Resource<List<CatFact>>>

}