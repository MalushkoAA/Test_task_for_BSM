package ru.malushko.testtaskforbsm.screenhome.domain.entities

import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    @DrawableRes val image: Int,
    var isSelected: Boolean = false
)
