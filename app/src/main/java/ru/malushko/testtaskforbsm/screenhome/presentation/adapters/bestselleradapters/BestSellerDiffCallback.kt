package ru.malushko.testtaskforbsm.screenhome.presentation.adapters.bestselleradapters

import androidx.recyclerview.widget.DiffUtil
import ru.malushko.testtaskforbsm.screenhome.domain.entities.BestSeller

object BestSellerDiffCallback : DiffUtil.ItemCallback<BestSeller>() {

    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}