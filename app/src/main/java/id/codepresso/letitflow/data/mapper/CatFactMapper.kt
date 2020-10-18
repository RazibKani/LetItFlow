package id.codepresso.letitflow.data.mapper

import id.codepresso.letitflow.data.entity.CatFact
import id.codepresso.letitflow.domain.model.CatFactResponse

/**
 * Crafted by Razib Kani Maulidan on 10/10/20.
 **/

fun mapCatFact(input: CatFactResponse): CatFact {
    return CatFact(input.id, input.text)
}