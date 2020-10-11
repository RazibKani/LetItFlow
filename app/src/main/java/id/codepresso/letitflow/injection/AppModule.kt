package id.codepresso.letitflow.injection

import id.codepresso.letitflow.data.database.AppDatabase
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

val appModule = module {

    single { AppDatabase(context = get()) }
    single { AppDatabase(context = get()).catFactDao() }

}