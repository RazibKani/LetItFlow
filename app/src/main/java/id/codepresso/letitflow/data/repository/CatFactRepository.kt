package id.codepresso.letitflow.data.repository

import id.codepresso.letitflow.data.Resource
import id.codepresso.letitflow.data.database.entity.CatFact
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Razib Kani Maulidan on 10/10/20.
 **/

interface CatFactRepository {

    fun getCatFacts(): Flow<Resource<List<CatFact>>>

}