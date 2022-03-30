package ru.malushko.testtaskforbsm.screenhome.data.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class BestSellerDto(
    @Json(name = "discount_price") val discountPrice: Int,
    val id: Int,
    @Json(name = "is_favorites") val isFavorites: Boolean,
    val picture: String,
    @Json(name = "price_without_discount") val priceWithoutDiscount: Int,
    val title: String
) : Parcelable
