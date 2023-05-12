package com.jder00138218.laboratorio05.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.jder00138218.laboratorio05.data.model.MovieModel
import com.jder00138218.laboratorio05.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit){

        binding.titleMovieTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification


        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }
}