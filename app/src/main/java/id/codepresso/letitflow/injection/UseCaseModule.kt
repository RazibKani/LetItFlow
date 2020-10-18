package id.codepresso.letitflow.injection

import id.codepresso.letitflow.domain.usecase.GetCatFactsUserCaseImpl
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 18/10/20.
 **/

val useCaseModule = module {

    factory { GetCatFactsUserCaseImpl(get()) }

}