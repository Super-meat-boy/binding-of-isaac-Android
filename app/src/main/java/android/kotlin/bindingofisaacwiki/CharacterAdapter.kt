package android.kotlin.bindingofisaacwiki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(val characters: List<Character>, val itemClickListener: View.OnClickListener) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView = itemView.findViewById<CardView>(R.id.card_view)
        var iconView = itemView.findViewById<ImageView>(R.id.character_icon)
        var nameView = itemView.findViewById<TextView>(R.id.character_name)
        val startingItemView = itemView.findViewById<TextView>(R.id.starting_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        val character = characters[position]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
        holder.nameView.text = character.name
        holder.iconView.setImageResource(character.icon)
        holder.startingItemView.text = character.startingItem
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}




