package ru.malushko.testtaskforbsm.screenhome.data.datasource.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class CategoriesDataModel(
    val id: Int,
    var name:String,
    @DrawableRes var image:Int,
    var isSelected:Boolean,
    @ColorRes var textColor:Int,
    @DrawableRes var circleColor:Int
)
