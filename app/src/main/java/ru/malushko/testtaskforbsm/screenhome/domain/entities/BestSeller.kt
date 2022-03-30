package ru.malushko.testtaskforbsm.screenhome.domain.entities

import com.squareup.moshi.Json

data class BestSeller(
    val discountPrice: Int,
    val id: Int,
    val isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: Int,
    val title: String
)
