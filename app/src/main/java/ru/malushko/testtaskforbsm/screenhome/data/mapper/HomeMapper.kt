package ru.malushko.testtaskforbsm.screenhome.data.mapper

import ru.malushko.testtaskforbsm.screenhome.data.datasource.model.CategoriesDataModel
import ru.malushko.testtaskforbsm.screenhome.data.network.models.BestSellerDto
import ru.malushko.testtaskforbsm.screenhome.data.network.models.HomeStoreDto
import ru.malushko.testtaskforbsm.screenhome.domain.entities.BestSeller
import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category
import ru.malushko.testtaskforbsm.screenhome.domain.entities.HomeStore

class HomeMapper {

    fun mapDtoToEntity(dto: BestSellerDto) = BestSeller(
        discountPrice = convertPrice(dto.discountPrice ?: 0),
        id = dto.id,
        isFavorites = dto.isFavorites,
        picture = dto.picture,
        priceWithoutDiscount = convertPrice(dto.priceWithoutDiscount ?: 0),
        title = dto.title
    )

    fun mapDtoToEntity(dto: HomeStoreDto) = HomeStore(
        id = dto.id,
        isBuy = dto.isBuy,
        isNew = dto.isNew,
        picture = dto.picture,
        subtitle = dto.subtitle,
        title = dto.title
    )

    fun mapDsToEntity(ds: CategoriesDataModel) = Category(
        id = ds.id,
        name = ds.name,
        image = ds.image,
        isSelected = ds.isSelected,
        textColor = ds.textColor,
        circleColor = ds.circleColor
    )

    private fun convertPrice(price: Int): String {
        val bufferPrice = StringBuilder(price.toString())
        val convertedPrice =
            if (price >= 1000) {
                bufferPrice.insert(1, ",")
            } else if (price >= 10000) {
                bufferPrice.insert(2, ",")
            } else {
                price.toString()
            }
        return "$convertedPrice"
    }







}