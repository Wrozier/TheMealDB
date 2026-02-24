package com.example.themealdb.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MealsResponse(
    val meals: List<Meal>
)

