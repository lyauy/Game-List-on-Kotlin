package com.example.oui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class GameAdapter(val games: GameAdapterInterface) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    override fun onCreateViewHolder(container: ViewGroup, position: Int): ViewHolder {
        val element = LayoutInflater.from(container.context).inflate(R.layout.item, container, false)
        return ViewHolder(element)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games.games[position])
    }

    override fun getItemCount(): Int {
        return games.games.size
    }

    inner class ViewHolder(val container: View) : RecyclerView.ViewHolder(container) {
        fun bind(game: Game){
            this.container.name.text = game.name
            this.container.setOnClickListener{
                this@GameAdapter.games.open(game)
            }
            Picasso.get().load(game.img).into(container.image)
        }
    }
}