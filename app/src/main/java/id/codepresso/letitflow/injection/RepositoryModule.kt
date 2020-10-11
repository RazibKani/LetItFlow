package id.codepresso.letitflow.injection

import id.codepresso.letitflow.data.repository.CatFactRepositoryImpl
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

val repositoryModule = module {

    single { CatFactRepositoryImpl(get(), get()) }

}