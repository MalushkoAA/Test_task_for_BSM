package ru.malushko.testtaskforbsm.screenhome.presentation.adapters.categoriesadapters

import androidx.recyclerview.widget.DiffUtil
import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category

object CategoriesDiffCallback : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}