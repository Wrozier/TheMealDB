package com.example.themealdb.ui.screens.meal_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themealdb.data.model.Meal
import com.example.themealdb.util.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealDetailViewModel : ViewModel() {

    private val _meal = MutableStateFlow<Meal?>(null)
    val meal = _meal.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    fun loadMeal(id: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitClient.api.getMealDetails(id)
                _meal.value = response.meals?.firstOrNull()
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}