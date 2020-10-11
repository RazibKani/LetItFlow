package id.codepresso.letitflow.injection

import id.codepresso.letitflow.presentation.CatFactViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

val viewModelModule = module {

    viewModel { CatFactViewModel(get()) }

}