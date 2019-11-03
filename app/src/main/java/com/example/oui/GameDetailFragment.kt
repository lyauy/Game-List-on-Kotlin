package com.example.oui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_game_detail.*

class GameDetailFragment : Fragment() {

    var game: Game? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(game!!.img).into(image_game)
        desc_game.text = game!!.description
        link.text = "Voir le lien"
        link.setOnClickListener({
            val url = game!!.link
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })
    }
    companion object {
        fun create(game: Game): GameDetailFragment {
            val result = GameDetailFragment()
            result.game = game
            return result
        }
    }
}
