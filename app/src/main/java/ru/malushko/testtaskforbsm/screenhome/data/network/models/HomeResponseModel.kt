package ru.malushko.testtaskforbsm.screenhome.data.network.models

import com.squareup.moshi.Json


data class HomeResponseModel(
    @Json(name = "best_seller") val bestSeller: List<BestSellerDto>,
    @Json(name = "home_store") val homeStore: List<HomeStoreDto>
)





