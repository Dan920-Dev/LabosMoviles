package com.jder00138218.laboratorio05.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jder00138218.laboratorio05.R
import com.jder00138218.laboratorio05.data.model.MovieModel
import com.jder00138218.laboratorio05.databinding.FragmentBillboardBinding
import com.jder00138218.laboratorio05.databinding.FragmentMovieBinding
import com.jder00138218.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.jder00138218.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewHolder
import com.jder00138218.laboratorio05.ui.movie.viewmodel.MovieViewModel


class BillboardFragment : Fragment() {

    private lateinit var  buttonAdd : FloatingActionButton


private lateinit var  binding: FragmentBillboardBinding
private lateinit var  adapter: MovieRecyclerViewAdapter

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView(view)
        buttonAdd = view.findViewById(R.id.add_movie)

        buttonAdd.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

    }

    private fun showSelectedItem(movie: MovieModel){
        movieViewModel.setSelectMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecycleView(view: View){
        binding.widgetRecycleView.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter { selecttedMovie ->
            showSelectedItem(selecttedMovie)
        }

        binding.widgetRecycleView.adapter = adapter
        displayMovies()
    }

}