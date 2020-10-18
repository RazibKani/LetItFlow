package id.codepresso.letitflow.domain.usecase

import id.codepresso.letitflow.data.Resource
import id.codepresso.letitflow.data.entity.CatFact
import id.codepresso.letitflow.data.repository.CatFactRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Crafted by Razib Kani Maulidan on 18/10/20.
 **/

class GetCatFactsUserCaseImpl(
    private val catFactRepository: CatFactRepositoryImpl
) : GetCatFactsUseCase {

    override fun invoke(): Flow<Resource<List<CatFact>>> {
        return catFactRepository.getCatFacts().map {
            when (it.status) {
                Resource.Status.LOADING -> Resource.loading(null)
                Resource.Status.SUCCESS -> Resource.success(it.data)
                Resource.Status.ERROR -> Resource.error(it.message!!, null)
            }
        }
    }

}