package com.example.unitconverrter.data

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ConverterCategory(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val units: List<UnitItem>,
    val converterType: ConverterType
)
