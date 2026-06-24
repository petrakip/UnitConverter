package com.example.unitconverrter

import com.example.unitconverrter.data.ConverterCategory
import com.example.unitconverrter.data.ConverterType
import com.example.unitconverrter.data.UnitItem
import com.example.unitconverrter.viewmodel.ConverterViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class ConverterViewModelTest {

    private lateinit var viewModel: ConverterViewModel

    private fun unit(id: String, symbol: String, factor: Double) = UnitItem(id, 0, symbol, factor)

    private val lengthCategory = ConverterCategory(
        title = 0,
        icon = 0,
        converterType = ConverterType.LENGTH,
        units = listOf(
            unit("meter", "m", 1.0),
            unit("kilometer", "km", 1000.0),
            unit("centimeter", "cm", 0.01)
        )
    )

    private val temperatureCategory = ConverterCategory(
        title = 0,
        icon = 0,
        converterType = ConverterType.TEMPERATURE,
        units = listOf(
            unit("celsius", "°C", 1.0),
            unit("fahrenheit", "°F", 1.0),
            unit("kelvin", "K", 1.0)
        )
    )

    private val timeCategory = ConverterCategory(
        title = 0,
        icon = 0,
        converterType = ConverterType.TIME,
        units = listOf(
            unit("second", "s", 1.0),
            unit("minute", "min", 60.0),
            unit("hour", "h", 3600.0)
        )
    )

    @Before
    fun setup() {
        viewModel = ConverterViewModel()
    }

    // ==================== initial state ====================

    @Test
    fun initialState_isDefault() {
        val state = viewModel.uiState.value
        assertNull(state.selectedCategory)
        assertNull(state.fromUnit)
        assertNull(state.toUnit)
        assertEquals("", state.inputValue)
        assertEquals("", state.result)
        assertNull(state.errorMessage)
    }

    // ==================== selectCategory ====================

    @Test
    fun selectCategory_setsFirstUnitAsFrom() {
        viewModel.selectCategory(lengthCategory)
        assertEquals(lengthCategory.units[0], viewModel.uiState.value.fromUnit)
    }

    @Test
    fun selectCategory_setsSecondUnitAsTo() {
        viewModel.selectCategory(lengthCategory)
        assertEquals(lengthCategory.units[1], viewModel.uiState.value.toUnit)
    }

    @Test
    fun selectCategory_setsSelectedCategory() {
        viewModel.selectCategory(lengthCategory)
        assertEquals(lengthCategory, viewModel.uiState.value.selectedCategory)
    }

    @Test
    fun selectCategory_clearsInputAndResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("1000")
        viewModel.selectCategory(temperatureCategory)

        val state = viewModel.uiState.value
        assertEquals("", state.inputValue)
        assertEquals("", state.result)
    }

    @Test
    fun selectCategory_clearsErrorMessage() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("abc")
        assertNotNull(viewModel.uiState.value.errorMessage)

        viewModel.selectCategory(temperatureCategory)
        assertNull(viewModel.uiState.value.errorMessage)
    }

    @Test
    fun selectCategory_withSingleUnit_setsFromAndToSameUnit() {
        val singleUnitCategory = ConverterCategory(
            title = 0,
            icon = 0,
            converterType = ConverterType.LENGTH,
            units = listOf(unit("meter", "m", 1.0))
        )
        viewModel.selectCategory(singleUnitCategory)

        val state = viewModel.uiState.value
        assertEquals(singleUnitCategory.units[0], state.fromUnit)
        assertEquals(singleUnitCategory.units[0], state.toUnit)
    }

    // ==================== onInputChange ====================

    @Test
    fun onInputChange_validNumber_updatesInputValue() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("1000")
        assertEquals("1000", viewModel.uiState.value.inputValue)
    }

    @Test
    fun onInputChange_validNumber_calculatesResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("1000")
        // 1000m → km = 1
        assertEquals("1", viewModel.uiState.value.result)
    }

    @Test
    fun onInputChange_validDecimal_calculatesResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("0.5")
        // 0.5m → km = 0.0005
        assertEquals("0.0005", viewModel.uiState.value.result)
    }

    @Test
    fun onInputChange_blankInput_clearsResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("1000")
        viewModel.onInputChange("")

        val state = viewModel.uiState.value
        assertEquals("", state.inputValue)
        assertEquals("", state.result)
    }

    @Test
    fun onInputChange_blankInput_noErrorMessage() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("")
        assertNull(viewModel.uiState.value.errorMessage)
    }

    @Test
    fun onInputChange_invalidText_setsErrorMessage() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("abc")
        assertNotNull(viewModel.uiState.value.errorMessage)
    }

    @Test
    fun onInputChange_invalidText_clearsResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("1000")
        viewModel.onInputChange("abc")
        assertEquals("", viewModel.uiState.value.result)
    }

    @Test
    fun onInputChange_afterError_validInput_clearsError() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("xyz")
        assertNotNull(viewModel.uiState.value.errorMessage)

        viewModel.onInputChange("100")
        assertNull(viewModel.uiState.value.errorMessage)
    }

    @Test
    fun onInputChange_temperature_celsiusToFahrenheit() {
        viewModel.selectCategory(temperatureCategory)
        viewModel.onInputChange("100")
        // 100°C → °F = 212
        assertEquals("212", viewModel.uiState.value.result)
    }

    @Test
    fun onInputChange_time_hoursToMinutes() {
        viewModel.selectCategory(timeCategory)
        // default: second → minute
        viewModel.selectToUnit(unit("minute", "min", 60.0))
        viewModel.selectFromUnit(unit("hour", "h", 3600.0))
        viewModel.onInputChange("2")
        // 2h → min = 120
        assertEquals("120", viewModel.uiState.value.result)
    }

    // ==================== selectFromUnit ====================

    @Test
    fun selectFromUnit_updatesFromUnit() {
        viewModel.selectCategory(lengthCategory)
        viewModel.selectFromUnit(unit("centimeter", "cm", 0.01))
        assertEquals("centimeter", viewModel.uiState.value.fromUnit?.id)
    }

    @Test
    fun selectFromUnit_recalculatesResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("100")
        // Change from meter to centimeter
        viewModel.selectFromUnit(unit("centimeter", "cm", 0.01))
        // 100cm → km = 100 * 0.01 / 1000 = 0.001
        assertEquals("0.001", viewModel.uiState.value.result)
    }

    @Test
    fun selectFromUnit_invalidInputRemains_errorPersists() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("bad")

        viewModel.selectFromUnit(unit("centimeter", "cm", 0.01))

        // calculateResult() re-validates the input and re-sets the error
        assertNotNull(viewModel.uiState.value.errorMessage)
    }

    // ==================== selectToUnit ====================

    @Test
    fun selectToUnit_updatesToUnit() {
        viewModel.selectCategory(lengthCategory)
        viewModel.selectToUnit(unit("centimeter", "cm", 0.01))
        assertEquals("centimeter", viewModel.uiState.value.toUnit?.id)
    }

    @Test
    fun selectToUnit_recalculatesResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("100")
        // Change toUnit from km to cm
        viewModel.selectToUnit(unit("centimeter", "cm", 0.01))
        // 100m → cm = 100 / 0.01 = 10000
        assertEquals("10000", viewModel.uiState.value.result)
    }

    @Test
    fun selectToUnit_invalidInputRemains_errorPersists() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("bad")

        viewModel.selectToUnit(unit("centimeter", "cm", 0.01))

        // calculateResult() re-validates the input and re-sets the error
        assertNotNull(viewModel.uiState.value.errorMessage)
    }

    // ==================== swapUnits ====================

    @Test
    fun swapUnits_swapsFromUnitToToUnit() {
        viewModel.selectCategory(lengthCategory)
        val originalFrom = viewModel.uiState.value.fromUnit

        viewModel.swapUnits()

        assertEquals(originalFrom, viewModel.uiState.value.toUnit)
    }

    @Test
    fun swapUnits_swapsToUnitToFromUnit() {
        viewModel.selectCategory(lengthCategory)
        val originalTo = viewModel.uiState.value.toUnit

        viewModel.swapUnits()

        assertEquals(originalTo, viewModel.uiState.value.fromUnit)
    }

    @Test
    fun swapUnits_recalculatesResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("1000")
        // Before: 1000m → km = 1
        assertEquals("1", viewModel.uiState.value.result)

        viewModel.swapUnits()
        // After swap: 1000km → m = 1,000,000
        assertEquals("1000000", viewModel.uiState.value.result)
    }

    @Test
    fun swapUnits_invalidInputRemains_errorPersists() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("bad")

        viewModel.swapUnits()

        // calculateResult() re-validates the input and re-sets the error
        assertNotNull(viewModel.uiState.value.errorMessage)
    }

    @Test
    fun swapUnits_withNullUnits_doesNotCrash() {
        // No category selected → fromUnit and toUnit are null
        viewModel.swapUnits()

        val state = viewModel.uiState.value
        assertNull(state.fromUnit)
        assertNull(state.toUnit)
    }

    @Test
    fun swapUnits_twiceRestoresOriginalOrder() {
        viewModel.selectCategory(lengthCategory)
        val originalFrom = viewModel.uiState.value.fromUnit
        val originalTo = viewModel.uiState.value.toUnit

        viewModel.swapUnits()
        viewModel.swapUnits()

        assertEquals(originalFrom, viewModel.uiState.value.fromUnit)
        assertEquals(originalTo, viewModel.uiState.value.toUnit)
    }

    // ==================== clearInput ====================

    @Test
    fun clearInput_clearsInputValue() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("1000")
        viewModel.clearInput()
        assertEquals("", viewModel.uiState.value.inputValue)
    }

    @Test
    fun clearInput_clearsResult() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("1000")
        viewModel.clearInput()
        assertEquals("", viewModel.uiState.value.result)
    }

    @Test
    fun clearInput_clearsErrorMessage() {
        viewModel.selectCategory(lengthCategory)
        viewModel.onInputChange("bad")
        assertNotNull(viewModel.uiState.value.errorMessage)

        viewModel.clearInput()
        assertNull(viewModel.uiState.value.errorMessage)
    }

    @Test
    fun clearInput_doesNotClearSelectedCategory() {
        viewModel.selectCategory(lengthCategory)
        viewModel.clearInput()
        assertEquals(lengthCategory, viewModel.uiState.value.selectedCategory)
    }

    @Test
    fun clearInput_doesNotClearUnits() {
        viewModel.selectCategory(lengthCategory)
        val fromUnit = viewModel.uiState.value.fromUnit
        val toUnit = viewModel.uiState.value.toUnit

        viewModel.clearInput()

        assertEquals(fromUnit, viewModel.uiState.value.fromUnit)
        assertEquals(toUnit, viewModel.uiState.value.toUnit)
    }
}
