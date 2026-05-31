package com.example.rickandmortypaging3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortypaging3.databinding.ItemLoaderBinding

class ProgressLoaderAdapter : LoadStateAdapter<ProgressLoaderAdapter.ProgressLoaderViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = ProgressLoaderViewHolder(
        ItemLoaderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: ProgressLoaderViewHolder,
        loadState: LoadState
    ) {
        holder.bind(loadState)
    }

    class ProgressLoaderViewHolder(private val binding: ItemLoaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            binding.progressBar.isVisible = loadState == LoadState.Loading
        }
    }
}
