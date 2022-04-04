package ru.malushko.testtaskforbsm.screenhome.presentation.adapters.homestoreadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import ru.malushko.testtaskforbsm.databinding.ItemHotSaleBinding
import ru.malushko.testtaskforbsm.screenhome.domain.entities.HomeStore


class HomeStoreAdapter : ListAdapter<HomeStore, HomeStoreViewHolder>(HomeStoreDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoreViewHolder {
        val binding = ItemHotSaleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeStoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeStoreViewHolder, position: Int) {
        val homeStoreItems = getItem(position)
        with(holder.binding) {
            fun labelNew(homeStoreItem: HomeStore) {
                if (homeStoreItem.isNew != null) {
                    rvHotSalesLabelNewImage.visibility = View.VISIBLE
                    rvHotSalesLabelNewText.visibility = View.VISIBLE
                } else {
                    rvHotSalesLabelNewImage.visibility = View.GONE
                    rvHotSalesLabelNewText.visibility = View.GONE
                }
            }
            with(homeStoreItems) {
                rvHotSalesTvTitle.text = title
                rvHotSalesTvSubtitle.text = subtitle
                Glide.with(rvHotSalesImage.context).load(picture).into(rvHotSalesImage)
                labelNew(this)
            }
        }
    }

}









