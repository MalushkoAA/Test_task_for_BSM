package ru.malushko.testtaskforbsm.screenhome.data.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeStoreDto(
    val id: Int,
    @Json(name = "is_buy") val isBuy: Boolean,
    @Json(name = "is_favorites") val isFavorites: Boolean,
    @Json(name = "is_new") val isNew: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
) : Parcelable
