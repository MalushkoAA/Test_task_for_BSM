package ru.malushko.testtaskforbsm.screenhome.presentation.adapters.categoriesadapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.malushko.testtaskforbsm.databinding.ItemCategoryBinding
import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category

class CategoriesAdapter : ListAdapter<Category, CategoriesViewHolder>(CategoriesDiffCallback) {

    var onCategoryClickListener: OnCategoryClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoriesViewHolder(binding)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categories = getItem(position)
        with(holder.binding){
            with(categories){
                rvCategoryIvCircle.setImageResource(circleColor)
                rvCategoryIvCategory.setImageResource(image)
                rvCategoryTvCategory.text = name
                rvCategoryTvCategory.setTextColor(root.resources.getColor(textColor))

                root.setOnClickListener {
                    onCategoryClickListener?.onCategoryClick(this)
                }
            }
        }
    }


    interface OnCategoryClickListener {
        fun onCategoryClick(category: Category)
    }


}