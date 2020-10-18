package id.codepresso.letitflow.data.repository

import id.codepresso.letitflow.data.Resource
import id.codepresso.letitflow.data.mapper.mapCatFact
import id.codepresso.letitflow.data.dao.CatFactDao
import id.codepresso.letitflow.data.entity.CatFact
import id.codepresso.letitflow.data.networkBoundResource
import id.codepresso.letitflow.data.api.CatFactApi
import id.codepresso.letitflow.domain.repository.CatFactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 * Crafted by Razib Kani Maulidan on 10/10/20.
 **/

class CatFactRepositoryImpl(
    private val catFactApi: CatFactApi,
    private val catFactDao: CatFactDao
) : CatFactRepository {

    override fun getCatFacts(): Flow<Resource<List<CatFact>>> {
        return networkBoundResource(
            fetchFromLocal = { catFactDao.getAll() },
            shouldFetchFromRemote = { true },
            fetchFromRemote = {
                catFactApi.getCatFacts("cat", 10)
            },
            processRemoteResponse = {},
            saveRemoteData = { responses ->
                catFactDao.insertAll(responses.map { mapCatFact(it) })
            },
            onFetchFailed = { _, _ -> }
        ).flowOn(Dispatchers.IO)
    }

}