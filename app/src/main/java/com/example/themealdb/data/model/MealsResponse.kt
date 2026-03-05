package com.example.themealdb.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MealsResponse(
    //Each item in the list is the Meal data class
    val meals: List<Meal>
)

