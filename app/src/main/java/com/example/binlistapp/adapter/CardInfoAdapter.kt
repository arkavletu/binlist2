package com.example.binlistapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.binlistapp.databinding.CardInfoBinding
import com.example.binlistapp.dto.CardInfo

class CardInfoAdapter(): ListAdapter<CardInfo, CardInfoViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardInfoViewHolder {
        val binding = CardInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardInfoViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}
class CardInfoViewHolder(
    private val binding: CardInfoBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post:CardInfo){
        binding.apply {
            bin.text = post.number.length.toString()
        }
    }
}
class DiffCallback : DiffUtil.ItemCallback<CardInfo>() {
    override fun areItemsTheSame(oldItem: CardInfo, newItem: CardInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CardInfo, newItem: CardInfo): Boolean {
        return oldItem == newItem
    }
}