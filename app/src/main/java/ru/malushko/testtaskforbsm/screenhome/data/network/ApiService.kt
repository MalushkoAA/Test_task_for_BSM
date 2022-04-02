package ru.malushko.testtaskforbsm.screenhome.data.network

import retrofit2.http.GET
import ru.malushko.testtaskforbsm.screenhome.data.network.models.HomeResponseModel

interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomeResponse() : HomeResponseModel

}