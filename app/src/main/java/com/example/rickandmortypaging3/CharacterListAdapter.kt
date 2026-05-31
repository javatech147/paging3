package com.example.rickandmortypaging3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortypaging3.databinding.ItemCharacterBinding
import com.example.rickandmortypaging3.model.Character

class CharacterListAdapter(private val onItemClick: (Character) -> Unit) :
    PagingDataAdapter<Character, CharacterListAdapter.CharacterViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position = position)?.let {
            holder.bind(it)
        }
    }

    inner class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Character) {
            with(binding) {
                name.text = item.name
                species.text = item.species
                gender.text = item.gender
                Glide.with(binding.root.context)
                    .load(item.image)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .circleCrop()
                    .into(imageView)
                root.setOnClickListener {
                    onItemClick.invoke(item)
                }
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(
                oldItem: Character,
                newItem: Character
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Character,
                newItem: Character
            ) = oldItem == newItem
        }
    }
}
