package com.example.uas_mws

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.films_item.view.*

class FilmsAdapter (private val list: ArrayList<FilmResponse>) : RecyclerView.Adapter<FilmsAdapter.FilmViewHolder>() {
    inner class FilmViewHolder (itemview: View) :
            RecyclerView.ViewHolder(itemview) {
                fun bind(filmResponse: FilmResponse){
                    with(itemView) {
                        val cover = "${filmResponse.image}"
                        val title = "${filmResponse.title}"
                        val release = "Tahun Release : ${filmResponse.release}"
                        val desc = "Description : ${filmResponse.desc}"
                        val director = "Director : ${filmResponse.director}"
                        val producer = "Producer : ${filmResponse.producer}"
                        val time = "Waktu Tayang : ${filmResponse.time} (menit)"
                        val rating = "Rating Film : ${filmResponse.rating}"

                        // kita gunakan library picasso untuk image
                        Picasso.get().load(cover).into(ivCover);
                        tvTitle.text = title
                        tvReleaseDate.text = release
                        tvDescription.text = desc
                        tvDirector.text = director
                        tvProducer.text = producer
                        tvRunningTime.text = time
                        tvRating.text = rating
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.films_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
            holder.bind(list[position])
    }
}