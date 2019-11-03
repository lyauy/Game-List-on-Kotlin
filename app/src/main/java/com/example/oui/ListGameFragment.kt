package com.example.oui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_list_game.*

class ListGameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getListGames()
        refresh_items.setOnRefreshListener {
            getListGames()
            refresh_items.isRefreshing = false
        }

    }

    fun getListGames() {

        val queue = Volley.newRequestQueue(activity)
        val url = "https://my-json-server.typicode.com/bgdom/cours-android/games"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val games = Gson().fromJson(response, Array<Game>::class.java)

                recycler.layoutManager = LinearLayoutManager(activity)
                recycler.adapter = GameAdapter(object: GameAdapterInterface{
                    override val games: Array<Game> = games

                    override fun open(game: Game) {
                        fragmentManager!!
                            .beginTransaction()
                            .replace(R.id.container, GameDetailFragment.create(game))
                            .commit()
                    }

                })
            },
            Response.ErrorListener { Log.d("azerty", "That didn't work!")  })

        queue.add(stringRequest)
    }
}
