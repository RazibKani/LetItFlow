package id.codepresso.letitflow

import android.app.Application
import id.codepresso.letitflow.injection.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    adapterModule,
                    repositoryModule,
                    useCaseModule,
                    serviceModule,
                    viewModelModule
                )
            )
        }
    }
}