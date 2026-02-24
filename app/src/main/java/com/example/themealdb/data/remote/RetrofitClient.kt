package com.example.themealdb.data.remote


import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    private val json = Json {
        ignoreUnknownKeys = true          // important for TheMealDB (extra fields)
        coerceInputValues = true
    }

    val api: MealApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            // .client(OkHttpClient with logging if you have it)
            .build()
            .create(MealApiService::class.java)
    }
}