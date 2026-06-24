package com.example.unitconverrter.engine

import com.example.unitconverrter.data.ConverterType
import com.example.unitconverrter.data.UnitItem

object ConversionEngine {

    fun convertGeneric(value: Double, fromUnit: UnitItem, toUnit: UnitItem): Double {
        val baseValue = value * fromUnit.factorToBase
        return baseValue / toUnit.factorToBase
    }

    fun convertTemperature(value: Double, fromUnit: UnitItem, toUnit: UnitItem): Double {
        val celsiusValue = when (fromUnit.id) {
            "celsius" -> value
            "fahrenheit" -> {
                (value - 32) * 5.0 /9.0
            }
            "kelvin" -> {
                value - 273.15
            }
            else -> value
        }
        return when (toUnit.id) {
            "celsius" -> celsiusValue
            "fahrenheit" -> {
                celsiusValue * 9.0 / 5.0 + 32
            }
            "kelvin" -> {
                celsiusValue + 273.15
            }
            else -> celsiusValue
        }
    }

    fun convertFuelConsumption(value: Double, fromUnit: UnitItem, toUnit: UnitItem): Double {
        if (value == 0.0) return 0.0

        val litersPer100Km = when (fromUnit.id) {
            "liter_per_100km" -> value
            "kilometer_per_liter" -> {
                100.0 / value
            }
            "mile_per_gallon" -> {
                235.214583 / value
            }
            else -> value
        }

        return when (toUnit.id) {
            "liter_per_100km" -> litersPer100Km
            "kilometer_per_liter" -> {
                100.0 / litersPer100Km
            }
            "mile_per_gallon" -> {
                235.214583 / litersPer100Km
            }
            else -> litersPer100Km
        }
    }

    fun convertSound(
        value: Double,
        fromUnit: UnitItem,
        toUnit: UnitItem
    ): Double {

        val decibelValue = when (fromUnit.id) {
            "decibel" -> value
            "bel" -> value * 10.0
            else -> value
        }

        return when (toUnit.id) {
            "decibel" -> decibelValue
            "bel" -> decibelValue / 10.0
            else -> decibelValue
        }
    }

    fun convert(
        value: Double,
        fromUnit: UnitItem,
        toUnit: UnitItem,
        converterType: ConverterType
    ): Double {
        return when (converterType) {
            ConverterType.TEMPERATURE -> convertTemperature(value, fromUnit, toUnit)
            ConverterType.FUEL_CONSUMPTION -> convertFuelConsumption(value, fromUnit, toUnit)
            ConverterType.SOUND -> { convertSound(value, fromUnit, toUnit)
            }
            else -> convertGeneric(value, fromUnit, toUnit)
        }
    }

    fun formatResult(value: Double): String {

        return if (value % 1.0 == 0.0) {
            value.toLong().toString()
        } else {
            "%.4f".format(value)
                .trimEnd('0')
                .trimEnd('.')
        }
    }

}