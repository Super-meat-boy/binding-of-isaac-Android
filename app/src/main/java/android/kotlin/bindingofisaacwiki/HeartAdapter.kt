package android.kotlin.bindingofisaacwiki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class HeartAdapter(val character: Character) : RecyclerView.Adapter<HeartAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView = itemView.findViewById<RelativeLayout>(R.id.heart_card_view)
        var heartView = itemView.findViewById<ImageView>(R.id.heart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_heart, parent, false)
        return HeartAdapter.ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardView.tag = position
        holder.heartView.setImageResource(R.drawable.pixel_heart)
    }

    override fun getItemCount(): Int {
        return character.heartNumber
    }

}