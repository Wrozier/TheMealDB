package com.example.themealdb.data.repository

import com.example.themealdb.data.remote.MealApiService
import com.example.themealdb.data.remote.RetrofitClient

class MealRepository(private val mealApiService: MealApiService = RetrofitClient.api) {

    suspend fun getMealById(id: String) = mealApiService.getMealDetails(id)

}