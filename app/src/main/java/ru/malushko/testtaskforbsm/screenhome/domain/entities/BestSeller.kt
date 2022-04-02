package ru.malushko.testtaskforbsm.screenhome.domain.entities

data class BestSeller(
    val discountPrice: Int?,
    val id: Int?,
    val isFavorites: Boolean?,
    val picture: String?,
    val priceWithoutDiscount: Int?,
    val title: String?
)
