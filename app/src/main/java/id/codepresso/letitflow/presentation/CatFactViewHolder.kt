package id.codepresso.letitflow.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import id.codepresso.letitflow.data.database.entity.CatFact
import kotlinx.android.synthetic.main.item_cat_fact.view.*

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

class CatFactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(catFact: CatFact) {
        itemView.tvText.text = catFact.text
    }

}