package ru.malushko.testtaskforbsm.screenhome.domain.entities

import com.squareup.moshi.Json

data class HomeStore(
    val id: Int,
    val isBuy: Boolean,
    val isFavorites: Boolean,
    val isNew: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
)
