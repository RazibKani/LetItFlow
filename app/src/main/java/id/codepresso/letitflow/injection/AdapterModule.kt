package id.codepresso.letitflow.injection

import id.codepresso.letitflow.presentation.CatFactAdapter
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

val adapterModule = module {

    factory { CatFactAdapter() }

}