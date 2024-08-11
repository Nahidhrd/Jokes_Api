package com.example.jokesapidemo.apicall.FavViewModel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import com.example.jokesapidemo.Adpter.JokesAdapter
import com.example.jokesapidemo.RoomData.Jokes
import com.example.jokesapidemo.databinding.FragmentFavouriteBinding


class FavouriteFragment : Fragment(), JokesAdapter.HandleUserClick {
    private lateinit var binding: FragmentFavouriteBinding
    private val viewModel by viewModels<FavouriteViewModel>()
    private lateinit var adapter: JokesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = JokesAdapter(mutableListOf(), this)
        binding.recyclerViewJokes.adapter = adapter

        Log.d("TAG", "my favourite jokes:${adapter} ")
    }

    private fun observeViewModel() {
        viewModel.getAllJokes.observe(viewLifecycleOwner) { list ->
            adapter.updateData(list)
        }
    }

    override fun onDeleteClick(jokesData: Jokes) {
        viewModel.deleteJokes(jokesData)
    }
}



