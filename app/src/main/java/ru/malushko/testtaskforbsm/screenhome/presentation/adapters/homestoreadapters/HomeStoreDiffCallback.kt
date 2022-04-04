package ru.malushko.testtaskforbsm.screenhome.presentation.adapters.homestoreadapters

import androidx.recyclerview.widget.DiffUtil
import ru.malushko.testtaskforbsm.screenhome.domain.entities.HomeStore

object HomeStoreDiffCallback : DiffUtil.ItemCallback<HomeStore>() {

    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem == newItem
    }
}