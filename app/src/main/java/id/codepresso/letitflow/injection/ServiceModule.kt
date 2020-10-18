package id.codepresso.letitflow.injection

import id.codepresso.letitflow.BuildConfig
import id.codepresso.letitflow.data.createNetworkClient
import id.codepresso.letitflow.data.api.CatFactApi
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

val serviceModule = module {

    single {
        createNetworkClient("https://cat-fact.herokuapp.com/", BuildConfig.DEBUG)
            .build()
    }

    single { (get() as Retrofit).create(CatFactApi::class.java) }

}