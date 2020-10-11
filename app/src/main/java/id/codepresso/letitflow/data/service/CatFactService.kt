package id.codepresso.letitflow.data.service

import id.codepresso.letitflow.data.ApiResponse
import id.codepresso.letitflow.data.model.CatFactResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

interface CatFactService {

    @GET("facts/random")
    fun getCatFacts(
        @Query("animal_type") animalType: String,
        @Query("amount") amount: Int
    ): Flow<ApiResponse<List<CatFactResponse>>>

}