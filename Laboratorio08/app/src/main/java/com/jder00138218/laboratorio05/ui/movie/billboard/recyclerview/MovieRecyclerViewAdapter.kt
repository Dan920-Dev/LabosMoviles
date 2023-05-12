package com.jder00138218.laboratorio05.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jder00138218.laboratorio05.data.model.MovieModel
import com.jder00138218.laboratorio05.databinding.MovieItemBinding

class MovieRecyclerViewAdapter (
    private val clcikListener: (MovieModel) -> Unit
) :RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    private val movies = ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clcikListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(movieList: List<MovieModel>){
        movies.clear()
        movies.addAll(movieList)
    }


}

