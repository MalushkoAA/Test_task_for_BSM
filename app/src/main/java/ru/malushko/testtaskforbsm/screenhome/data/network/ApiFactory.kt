package ru.malushko.testtaskforbsm.screenhome.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {

    var interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var client=OkHttpClient.Builder().addInterceptor(interceptor).build()

    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    val apiService = retrofit.create(ApiService::class.java)

}