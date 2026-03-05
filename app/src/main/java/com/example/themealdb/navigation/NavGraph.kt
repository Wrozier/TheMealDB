package com.example.themealdb.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.themealdb.ui.screens.meals.MealsScreen
import com.example.themealdb.ui.screens.meal_detail.MealDetailScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "meals") {
        composable("meals") {
            MealsScreen(
                onMealClick = { mealId ->
                    navController.navigate("meal/$mealId")
                }
            )
        }

        composable("meal/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId") ?: ""
            MealDetailScreen(  onBackClick = { navController.popBackStack() }, mealId = mealId)
        }
    }
}