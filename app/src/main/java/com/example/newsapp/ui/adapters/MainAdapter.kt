package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.domain.entity.Article
import com.example.newsapp.databinding.NewItemBinding

class MainAdapter(
    private val actionListener: ForwardClick
): ListAdapter<Article, MainAdapter.MainViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = NewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class MainViewHolder(private val binding: NewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) = with(binding) {

                Glide.with(itemView.context)
                    .load(article.urlToImage)
                    .centerCrop()
                    .error(R.drawable.ic_image_not_found)
                    .placeholder(R.drawable.ic_image_not_found)
                    .into(itemImage)

            itemTitle.text = article.title
            itemDescription.text = article.description
            itemData.text = article.publishedAt

            itemView.setOnClickListener {
                actionListener.onDetails(article)
            }
        }
    }

    class DiffCallBack: DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }
}