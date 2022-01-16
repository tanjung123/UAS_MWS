package com.example.uas_mws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.films_item.*
import kotlinx.android.synthetic.main.films_item.view.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<FilmResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //menampilkan progressBar
        showLoading(true)
        // panggil read data film
        readFilm()
    }

    private fun readFilm() {
        rvFilms.setHasFixedSize(true)
        rvFilms.layoutManager = LinearLayoutManager(this)
        RetrofitClient.instance.getFilms().enqueue(object : retrofit2.Callback<ArrayList<FilmResponse>>{
            override fun onFailure(call: Call<ArrayList<FilmResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Failed to read data", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<ArrayList<FilmResponse>>, response: Response<ArrayList<FilmResponse>>
            ) {
                response.body()?.let { list.addAll(it) }

                val adapter = FilmsAdapter(list)
                rvFilms.adapter = adapter
                showLoading(false)
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}