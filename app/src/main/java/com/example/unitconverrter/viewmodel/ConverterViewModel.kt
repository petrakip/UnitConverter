package com.example.unitconverrter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.unitconverrter.data.ConverterCategory
import com.example.unitconverrter.data.UnitItem
import com.example.unitconverrter.engine.ConversionEngine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConverterViewModel :  ViewModel() {

    private val _uiState = MutableStateFlow(ConverterUiState())
    val uiState: StateFlow<ConverterUiState> = _uiState.asStateFlow()

    fun selectCategory(category: ConverterCategory) {
        val defaultFromUnit = category.units.first()

        val defaultToUnit =
            if (category.units.size > 1) {
                category.units[1]
            } else {
                category.units.first()
            }

        _uiState.value = _uiState.value.copy(
            selectedCategory = category,
            fromUnit = defaultFromUnit,
            toUnit = defaultToUnit,
            inputValue = "",
            result = "",
            errorMessage = null

        )
    }

    fun onInputChange(value: String) {
        _uiState.value = _uiState.value.copy(
            inputValue = value,
            errorMessage = null
        )

        calculateResult()
    }

    private fun calculateResult() {
        val state = _uiState.value

        if (state.inputValue.isBlank()) {
            _uiState.value = state.copy(
                result = "",
                errorMessage = null
            )
            return
        }

        val inputNumber = state.inputValue.toDoubleOrNull()

        if (inputNumber == null) {
            _uiState.value = state.copy(
                result = "",
                errorMessage = "Invalid Number"
            )
            return
        }

        val category = state.selectedCategory
        val fromUnit = state.fromUnit
        val toUnit = state.toUnit

        if (category == null || fromUnit == null || toUnit == null) return

        val convertedValue = ConversionEngine.convert(
            value = inputNumber,
            fromUnit = fromUnit,
            toUnit = toUnit,
            converterType = category.converterType
        )

        _uiState.value = state.copy(
            result = ConversionEngine.formatResult(convertedValue),
            errorMessage = null
        )
    }

    fun selectFromUnit(unit: UnitItem) {
        _uiState.value = _uiState.value.copy(
            fromUnit = unit,
            errorMessage = null
        )

        calculateResult()
    }

    fun selectToUnit(unit: UnitItem) {
        _uiState.value = _uiState.value.copy(
            toUnit = unit,
            errorMessage = null
        )

        calculateResult()
    }

    fun swapUnits() {
        val state = _uiState.value

        val currentFromUnit = state.fromUnit
        val currentToUnit = state.toUnit

        if (currentToUnit == null || currentFromUnit == null) return

        _uiState.value = state.copy(
            fromUnit = currentToUnit,
            toUnit = currentFromUnit,
            errorMessage = null
        )

        calculateResult()
    }

    fun clearInput() {
        _uiState.value = _uiState.value.copy(
            inputValue = "",
            result = "",
            errorMessage = null
        )
    }

}