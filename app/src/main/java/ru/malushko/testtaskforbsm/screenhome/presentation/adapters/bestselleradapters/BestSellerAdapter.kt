package ru.malushko.testtaskforbsm.screenhome.presentation.adapters.bestselleradapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import ru.malushko.testtaskforbsm.R
import ru.malushko.testtaskforbsm.databinding.ItemBestSellerBinding
import ru.malushko.testtaskforbsm.screenhome.domain.entities.BestSeller

class BestSellerAdapter : ListAdapter<BestSeller, BestSellerViewHolder>(BestSellerDiffCallback) {

    var onBestSellerClickListener: OnBestSellerClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val binding = ItemBestSellerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val bestSellerItems = getItem(position)
        with(holder.binding) {
            with(bestSellerItems) {
                tvBestSellerDiscountPrice.text = priceWithoutDiscount.toString()
                rvBestSellerTvPrice.text = discountPrice.toString()
                rvBestSellerTvDescription.text = title
                Glide.with(rvBestSellerIvPhone.context).load(picture).into(rvBestSellerIvPhone)
                if (isFavorites != true) rvBestSellerFavorite.setImageResource(R.drawable.ic_favorite_not)
                if (isFavorites == true) rvBestSellerFavorite.setImageResource(R.drawable.ic_favorite)
                rvBestSellerFavorite.setOnClickListener {
                    onBestSellerClickListener?.onFavoriteClick(this, holder.binding)
                }
            }
        }

    }

    interface OnBestSellerClickListener {
        fun onFavoriteClick(bestSellerItem: BestSeller, hg: ItemBestSellerBinding)
    }

}