package id.codepresso.letitflow.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Crafted by Razib Kani Maulidan on 10/10/20.
 **/

@Entity(tableName = "cat_fact")
data class CatFact(
    @PrimaryKey val id: String,
    val text: String
)