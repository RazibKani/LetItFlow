package id.codepresso.letitflow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import id.codepresso.letitflow.data.Resource
import id.codepresso.letitflow.data.repository.CatFactRepositoryImpl
import kotlinx.coroutines.flow.map

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

class CatFactViewModel(repository: CatFactRepositoryImpl) : ViewModel() {

    val catFacts = repository.getCatFacts().map {
        when (it.status) {
            Resource.Status.LOADING -> Resource.loading(null)
            Resource.Status.SUCCESS -> Resource.success(it.data)
            Resource.Status.ERROR -> Resource.error(it.message!!, null)
        }
    }.asLiveData(viewModelScope.coroutineContext)

}