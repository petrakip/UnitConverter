package com.example.unitconverrter.viewmodel

import com.example.unitconverrter.data.ConverterCategory
import com.example.unitconverrter.data.UnitItem

data class ConverterUiState(
    val selectedCategory: ConverterCategory? = null,
    val inputValue: String = "",
    val fromUnit: UnitItem? = null,
    val toUnit: UnitItem? = null,
    val result: String = "",
    val errorMessage: String? = null
)