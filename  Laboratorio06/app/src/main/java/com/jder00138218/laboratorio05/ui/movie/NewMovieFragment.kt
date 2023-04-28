package com.jder00138218.laboratorio05.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.jder00138218.laboratorio05.R
import com.jder00138218.laboratorio05.data.description
import com.jder00138218.laboratorio05.data.model.MovieModel
import com.jder00138218.laboratorio05.ui.movie.MovieViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [newMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class newMovieFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var descritionEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var submitButton: Button

    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        var name: String
        var ndescription: String
        var category: String
        var qualification: String

        submitButton.setOnClickListener {
            name = nameEditText.text.toString()
            ndescription = descritionEditText.text.toString()
            category = categoryEditText.text.toString()
            qualification = qualificationEditText.text.toString()

            val movie = MovieModel(name, category, ndescription, qualification)

            movieViewModel.addMovies(movie)
            Log.d("movie", movieViewModel.getMovies().toString())

        }

    }

    private fun bind(){
        nameEditText = view?.findViewById(R.id.name_ET) as EditText
        descritionEditText = view?.findViewById(R.id.description_ET) as EditText
        qualificationEditText = view?.findViewById(R.id.qualification_ET) as EditText
        categoryEditText = view?.findViewById(R.id.category_ET) as EditText
        submitButton = view?.findViewById(R.id.send_BT) as Button
    }

}