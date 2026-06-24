package com.example.unitconverrter.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unitconverrter.screens.ConverterScreen
import com.example.unitconverrter.screens.HomeScreen
import com.example.unitconverrter.viewmodel.ConverterViewModel

@Composable
fun UnitConverterApp(
    viewModel: ConverterViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onCategoryClick = { category ->
                    viewModel.selectCategory(category)
                    navController.navigate("converter")
                }
            )
        }

        composable("converter") {
            ConverterScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}