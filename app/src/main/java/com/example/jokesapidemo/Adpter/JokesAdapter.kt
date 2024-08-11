package com.example.jokesapidemo.Adpter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jokesapidemo.RoomData.Jokes
import com.example.jokesapidemo.databinding.ItemLayoutBinding

class JokesAdapter(
    private var jokeList: List<Jokes>,
    private var handleUserClick: HandleUserClick
) : RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {

    interface HandleUserClick {
        fun onDeleteClick(jokesData: Jokes)
    }

    fun updateData(newList: List<Jokes>) {
            jokeList = newList.toMutableList()
             notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jokeList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        jokeList[position].let { itemData ->
            holder.binding.apply {
                if (itemData.joke == null) {
                    jokeSetup.text = itemData.setup
                    delivery.text = itemData.delivery
                    type.text = "Category: ${itemData.type}"
                } else {
                    delivery.text = itemData.joke
                    type.text = "Category: ${itemData.type}"
                }
                btnFavorite.setOnClickListener {
                    handleUserClick.onDeleteClick(itemData)
                }
            }
        }
    }

    inner class JokesViewHolder(var binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}