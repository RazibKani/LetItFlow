package id.codepresso.letitflow.data.dao

import androidx.room.*
import id.codepresso.letitflow.data.entity.CatFact
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Razib Kani Maulidan on 10/10/20.
 **/

@Dao
interface CatFactDao {

    @Query("SELECT * FROM cat_fact")
    fun getAll(): Flow<List<CatFact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(catFacts: List<CatFact>)

}