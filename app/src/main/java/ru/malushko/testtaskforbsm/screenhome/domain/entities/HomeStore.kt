package ru.malushko.testtaskforbsm.screenhome.domain.entities

import com.squareup.moshi.Json

data class HomeStore(
    val id: Int? = null,
    val isBuy: Boolean? = null,
    val isNew: Boolean? = null,
    val picture: String? = null,
    val subtitle: String? = null,
    val title: String? = null
)
