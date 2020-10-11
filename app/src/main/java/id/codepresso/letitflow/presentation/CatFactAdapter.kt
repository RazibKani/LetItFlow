package id.codepresso.letitflow.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.codepresso.letitflow.R
import id.codepresso.letitflow.data.database.entity.CatFact

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

class CatFactAdapter : RecyclerView.Adapter<CatFactViewHolder>() {

    var catFacts = listOf<CatFact>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatFactViewHolder {
        val view =  LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cat_fact, parent, false)

        return CatFactViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatFactViewHolder, position: Int) {
        holder.bind(catFacts[position])
    }

    override fun getItemCount(): Int = catFacts.size

}