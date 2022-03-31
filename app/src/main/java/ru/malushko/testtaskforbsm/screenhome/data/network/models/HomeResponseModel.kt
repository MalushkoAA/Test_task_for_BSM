package ru.malushko.testtaskforbsm.screenhome.data.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeResponseModel(
    @Json(name = "best_seller") val bestSeller: List<BestSellerDto>,
    @Json(name = "home_store") val homeStore: List<HomeStoreDto>
) : Parcelable





