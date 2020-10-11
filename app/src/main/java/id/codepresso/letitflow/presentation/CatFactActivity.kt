package id.codepresso.letitflow.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.codepresso.letitflow.R
import id.codepresso.letitflow.data.Resource
import kotlinx.android.synthetic.main.content_cat_fact.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatFactActivity : AppCompatActivity() {

    private val viewModel by viewModel<CatFactViewModel>()
    private val catFactAdapter by inject<CatFactAdapter>()

    private val linearLayoutManager by lazy { LinearLayoutManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_fact)
        setSupportActionBar(findViewById(R.id.toolbar))

        setupViews()
        subscribeCatFacts()
    }

    private fun setupViews() {
        rvCatFact.apply {
            adapter = catFactAdapter
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
        }
    }

    private fun subscribeCatFacts() {
        viewModel.catFacts.observe(this, {
            when (it.status) {
                Resource.Status.LOADING -> {
                    showLoading()
                }
                Resource.Status.SUCCESS -> {
                    hideLoading()
                    catFactAdapter.catFacts = it.data ?: listOf()
                }
                Resource.Status.ERROR -> {
                    hideLoading()
                    showError(it.message)
                }
            }
        })
    }

    private fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        pbLoading.visibility = View.GONE
    }

    private fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}