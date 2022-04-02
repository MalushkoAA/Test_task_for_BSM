package ru.malushko.testtaskforbsm.screenhome.data.datasource


import ru.malushko.testtaskforbsm.R
import ru.malushko.testtaskforbsm.screenhome.data.datasource.model.CategoriesDataModel

object DataSource {

    val categoriesDsList: MutableList<CategoriesDataModel> = mutableListOf(
        CategoriesDataModel(
            0,
            "Phones",
            R.drawable.ic_category_phone,
            true,
            R.color.black,
            R.drawable.ic_circle_whie
        ),
        CategoriesDataModel(
            1,
            "Computer",
            R.drawable.ic_category_computer,
            false,
            R.color.black,
            R.drawable.ic_circle_whie
        ),
        CategoriesDataModel(
            2,
            "Health",
            R.drawable.ic_category_health,
            false,
            R.color.black,
            R.drawable.ic_circle_whie
        ),
        CategoriesDataModel(
            3,
            "Books",
            R.drawable.ic_category_books,
            false,
            R.color.black,
            R.drawable.ic_circle_whie
        ),
        CategoriesDataModel(
            4,
            "Pets",
            R.drawable.ic_category_pets,
            false,
            R.color.black,
            R.drawable.ic_circle_whie
        ),

    )
}