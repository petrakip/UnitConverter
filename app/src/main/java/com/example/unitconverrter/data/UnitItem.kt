package com.example.unitconverrter.data

import androidx.annotation.StringRes

data class UnitItem(
    val id: String,
    @StringRes val name: Int,
    val symbol: String,
    val factorToBase: Double
)