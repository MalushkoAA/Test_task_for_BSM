package ru.malushko.testtaskforbsm.screenhome.domain.entities

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Category(
    val id: Int,
    var name:String,
    @DrawableRes var image:Int,
    var isSelected:Boolean,
    @ColorRes var textColor:Int,
    @DrawableRes var circleColor:Int
)
