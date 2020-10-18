package id.codepresso.letitflow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import id.codepresso.letitflow.domain.usecase.GetCatFactsUserCaseImpl

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

class CatFactViewModel(
    getCatFactsUseCase: GetCatFactsUserCaseImpl
) : ViewModel() {

    val catFacts =
        getCatFactsUseCase.invoke().asLiveData(viewModelScope.coroutineContext)

}