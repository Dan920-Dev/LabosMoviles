package com.jder00138218.laboratorio05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jder00138218.laboratorio05.R
import com.jder00138218.laboratorio05.databinding.FragmentMovieBinding
import com.jder00138218.laboratorio05.databinding.FragmentNewMovieBinding
import com.jder00138218.laboratorio05.ui.movie.viewmodel.MovieViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }


    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }

}