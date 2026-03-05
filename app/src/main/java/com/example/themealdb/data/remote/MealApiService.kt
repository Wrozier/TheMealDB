package com.example.themealdb.data.remote

import com.example.themealdb.data.model.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query
//Tells  Retrofit what HTTP requests to make to DB
//Retrofit uses an interface to define API endpoints
interface MealApiService {

    @GET("search.php")
    suspend fun searchMealsByLetter(
        @Query("f") letter: String
    ): MealsResponse

    @GET("lookup.php")
    suspend fun getMealDetails(
        @Query("i") id: String
    ): MealsResponse
}

