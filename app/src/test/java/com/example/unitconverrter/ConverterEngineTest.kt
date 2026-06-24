package com.example.unitconverrter

import com.example.unitconverrter.data.ConverterType
import com.example.unitconverrter.data.UnitItem
import com.example.unitconverrter.engine.ConversionEngine
import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterEngineTest {

    private fun unit(id: String, symbol: String, factor: Double) = UnitItem(id, 0, symbol, factor)

    // ==================== convertGeneric ====================

    @Test
    fun convertGeneric_meterToKilometer() {
        val result = ConversionEngine.convertGeneric(
            1000.0,
            unit("meter", "m", 1.0),
            unit("kilometer", "km", 1000.0)
        )
        assertEquals(1.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_kilometerToMeter() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("kilometer", "km", 1000.0),
            unit("meter", "m", 1.0)
        )
        assertEquals(1000.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_inchToCentimeter() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("inch", "in", 0.0254),
            unit("centimeter", "cm", 0.01)
        )
        assertEquals(2.54, result, 0.0001)
    }

    @Test
    fun convertGeneric_mileToKilometer() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("mile", "mi", 1609.34),
            unit("kilometer", "km", 1000.0)
        )
        assertEquals(1.60934, result, 0.0001)
    }

    @Test
    fun convertGeneric_sameUnit_returnsIdentity() {
        val result = ConversionEngine.convertGeneric(
            42.0,
            unit("meter", "m", 1.0),
            unit("meter", "m", 1.0)
        )
        assertEquals(42.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_kilogramToGram() {
        val result = ConversionEngine.convertGeneric(
            2.5,
            unit("kilogram", "kg", 1000.0),
            unit("gram", "g", 1.0)
        )
        assertEquals(2500.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_poundToKilogram() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("pound", "lb", 453.592),
            unit("kilogram", "kg", 1000.0)
        )
        assertEquals(0.453592, result, 0.0001)
    }

    @Test
    fun convertGeneric_hourToSecond() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("hour", "h", 3600.0),
            unit("second", "s", 1.0)
        )
        assertEquals(3600.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_dayToMinute() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("day", "d", 86400.0),
            unit("minute", "min", 60.0)
        )
        assertEquals(1440.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_megabyteToKilobyte() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("megabyte", "MB", 1_048_576.0),
            unit("kilobyte", "KB", 1024.0)
        )
        assertEquals(1024.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_gigabyteToMegabyte() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("gigabyte", "GB", 1_073_741_824.0),
            unit("megabyte", "MB", 1_048_576.0)
        )
        assertEquals(1024.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_gigahertzToMegahertz() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("gigahertz", "GHz", 1_000_000_000.0),
            unit("megahertz", "MHz", 1_000_000.0)
        )
        assertEquals(1000.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_kilowattToWatt() {
        val result = ConversionEngine.convertGeneric(
            3.0,
            unit("kilowatt", "kW", 1000.0),
            unit("watt", "W", 1.0)
        )
        assertEquals(3000.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_horsepowerToWatt() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("horsepower", "hp", 745.7),
            unit("watt", "W", 1.0)
        )
        assertEquals(745.7, result, 0.01)
    }

    @Test
    fun convertGeneric_kilowattHourToJoule() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("kilowatt_hour", "kWh", 3_600_000.0),
            unit("joule", "J", 1.0)
        )
        assertEquals(3_600_000.0, result, 0.1)
    }

    @Test
    fun convertGeneric_calorieToJoule() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("calorie", "cal", 4.184),
            unit("joule", "J", 1.0)
        )
        assertEquals(4.184, result, 0.0001)
    }

    @Test
    fun convertGeneric_hectareToSquareMeter() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("hectare", "ha", 10_000.0),
            unit("square_meter", "m²", 1.0)
        )
        assertEquals(10_000.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_acreToSquareMeter() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("acre", "ac", 4046.86),
            unit("square_meter", "m²", 1.0)
        )
        assertEquals(4046.86, result, 0.01)
    }

    @Test
    fun convertGeneric_literToMilliliter() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("liter", "L", 1.0),
            unit("milliliter", "mL", 0.001)
        )
        assertEquals(1000.0, result, 0.0001)
    }

    @Test
    fun convertGeneric_gallonToLiter() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("gallon", "gal", 3.78541),
            unit("liter", "L", 1.0)
        )
        assertEquals(3.78541, result, 0.0001)
    }

    @Test
    fun convertGeneric_meterPerSecondToKilometerPerHour() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("meter_per_second", "m/s", 1.0),
            unit("kilometer_per_hour", "km/h", 0.277778)
        )
        assertEquals(3.6, result, 0.0001)
    }

    @Test
    fun convertGeneric_radianToDegree() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("radian", "rad", 57.2958),
            unit("degree", "°", 1.0)
        )
        assertEquals(57.2958, result, 0.0001)
    }

    @Test
    fun convertGeneric_kilogramPerCubicMeterToGramPerLiter() {
        val result = ConversionEngine.convertGeneric(
            1.0,
            unit("kilogram_per_cubic_meter", "kg/m³", 1.0),
            unit("gram_per_liter", "g/L", 1.0)
        )
        assertEquals(1.0, result, 0.0001)
    }

    // ==================== convertTemperature ====================

    @Test
    fun convertTemperature_celsiusToFahrenheit_freezing() {
        val result = ConversionEngine.convertTemperature(
            0.0,
            unit("celsius", "°C", 1.0),
            unit("fahrenheit", "°F", 1.0)
        )
        assertEquals(32.0, result, 0.0001)
    }

    @Test
    fun convertTemperature_celsiusToFahrenheit_boiling() {
        val result = ConversionEngine.convertTemperature(
            100.0,
            unit("celsius", "°C", 1.0),
            unit("fahrenheit", "°F", 1.0)
        )
        assertEquals(212.0, result, 0.0001)
    }

    @Test
    fun convertTemperature_fahrenheitToCelsius_freezing() {
        val result = ConversionEngine.convertTemperature(
            32.0,
            unit("fahrenheit", "°F", 1.0),
            unit("celsius", "°C", 1.0)
        )
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun convertTemperature_fahrenheitToCelsius_boiling() {
        val result = ConversionEngine.convertTemperature(
            212.0,
            unit("fahrenheit", "°F", 1.0),
            unit("celsius", "°C", 1.0)
        )
        assertEquals(100.0, result, 0.0001)
    }

    @Test
    fun convertTemperature_celsiusToKelvin() {
        val result = ConversionEngine.convertTemperature(
            0.0,
            unit("celsius", "°C", 1.0),
            unit("kelvin", "K", 1.0)
        )
        assertEquals(273.15, result, 0.0001)
    }

    @Test
    fun convertTemperature_kelvinToCelsius() {
        val result = ConversionEngine.convertTemperature(
            273.15,
            unit("kelvin", "K", 1.0),
            unit("celsius", "°C", 1.0)
        )
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun convertTemperature_fahrenheitToKelvin() {
        val result = ConversionEngine.convertTemperature(
            32.0,
            unit("fahrenheit", "°F", 1.0),
            unit("kelvin", "K", 1.0)
        )
        assertEquals(273.15, result, 0.0001)
    }

    @Test
    fun convertTemperature_kelvinToFahrenheit_boiling() {
        val result = ConversionEngine.convertTemperature(
            373.15,
            unit("kelvin", "K", 1.0),
            unit("fahrenheit", "°F", 1.0)
        )
        assertEquals(212.0, result, 0.0001)
    }

    @Test
    fun convertTemperature_sameUnit_returnsIdentity() {
        val result = ConversionEngine.convertTemperature(
            25.0,
            unit("celsius", "°C", 1.0),
            unit("celsius", "°C", 1.0)
        )
        assertEquals(25.0, result, 0.0001)
    }

    @Test
    fun convertTemperature_negativeFortyIsSameInCelsiusAndFahrenheit() {
        val result = ConversionEngine.convertTemperature(
            -40.0,
            unit("celsius", "°C", 1.0),
            unit("fahrenheit", "°F", 1.0)
        )
        assertEquals(-40.0, result, 0.0001)
    }

    @Test
    fun convertTemperature_absoluteZeroInCelsius() {
        val result = ConversionEngine.convertTemperature(
            0.0,
            unit("kelvin", "K", 1.0),
            unit("celsius", "°C", 1.0)
        )
        assertEquals(-273.15, result, 0.0001)
    }

    // ==================== convertFuelConsumption ====================

    @Test
    fun convertFuelConsumption_literPer100KmToKmPerLiter() {
        val result = ConversionEngine.convertFuelConsumption(
            10.0,
            unit("liter_per_100km", "L/100km", 1.0),
            unit("kilometer_per_liter", "km/L", 1.0)
        )
        assertEquals(10.0, result, 0.0001)
    }

    @Test
    fun convertFuelConsumption_kmPerLiterToLiterPer100Km() {
        val result = ConversionEngine.convertFuelConsumption(
            10.0,
            unit("kilometer_per_liter", "km/L", 1.0),
            unit("liter_per_100km", "L/100km", 1.0)
        )
        assertEquals(10.0, result, 0.0001)
    }

    @Test
    fun convertFuelConsumption_literPer100KmToMpg() {
        val result = ConversionEngine.convertFuelConsumption(
            10.0,
            unit("liter_per_100km", "L/100km", 1.0),
            unit("mile_per_gallon", "mpg", 1.0)
        )
        assertEquals(23.5214, result, 0.001)
    }

    @Test
    fun convertFuelConsumption_mpgToLiterPer100Km() {
        val result = ConversionEngine.convertFuelConsumption(
            23.5214583,
            unit("mile_per_gallon", "mpg", 1.0),
            unit("liter_per_100km", "L/100km", 1.0)
        )
        assertEquals(10.0, result, 0.001)
    }

    @Test
    fun convertFuelConsumption_mpgToKmPerLiter() {
        // 20 mpg → L/100km = 235.214583/20 = 11.7607 → km/L = 100/11.7607 ≈ 8.503
        val result = ConversionEngine.convertFuelConsumption(
            20.0,
            unit("mile_per_gallon", "mpg", 1.0),
            unit("kilometer_per_liter", "km/L", 1.0)
        )
        assertEquals(8.503, result, 0.01)
    }

    @Test
    fun convertFuelConsumption_kmPerLiterToMpg() {
        val result = ConversionEngine.convertFuelConsumption(
            10.0,
            unit("kilometer_per_liter", "km/L", 1.0),
            unit("mile_per_gallon", "mpg", 1.0)
        )
        assertEquals(23.5214, result, 0.001)
    }

    @Test
    fun convertFuelConsumption_zeroValue_returnsZero() {
        val result = ConversionEngine.convertFuelConsumption(
            0.0,
            unit("liter_per_100km", "L/100km", 1.0),
            unit("kilometer_per_liter", "km/L", 1.0)
        )
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun convertFuelConsumption_sameUnit_returnsIdentity() {
        val result = ConversionEngine.convertFuelConsumption(
            8.0,
            unit("liter_per_100km", "L/100km", 1.0),
            unit("liter_per_100km", "L/100km", 1.0)
        )
        assertEquals(8.0, result, 0.0001)
    }

    // ==================== convertSound ====================

    @Test
    fun convertSound_decibelToBel() {
        val result = ConversionEngine.convertSound(
            10.0,
            unit("decibel", "dB", 1.0),
            unit("bel", "B", 10.0)
        )
        assertEquals(1.0, result, 0.0001)
    }

    @Test
    fun convertSound_belToDecibel() {
        val result = ConversionEngine.convertSound(
            1.0,
            unit("bel", "B", 10.0),
            unit("decibel", "dB", 1.0)
        )
        assertEquals(10.0, result, 0.0001)
    }

    @Test
    fun convertSound_fiveBelToDecibel() {
        val result = ConversionEngine.convertSound(
            5.0,
            unit("bel", "B", 10.0),
            unit("decibel", "dB", 1.0)
        )
        assertEquals(50.0, result, 0.0001)
    }

    @Test
    fun convertSound_sameUnit_decibel_returnsIdentity() {
        val result = ConversionEngine.convertSound(
            50.0,
            unit("decibel", "dB", 1.0),
            unit("decibel", "dB", 1.0)
        )
        assertEquals(50.0, result, 0.0001)
    }

    @Test
    fun convertSound_sameUnit_bel_returnsIdentity() {
        val result = ConversionEngine.convertSound(
            3.0,
            unit("bel", "B", 10.0),
            unit("bel", "B", 10.0)
        )
        assertEquals(3.0, result, 0.0001)
    }

    // ==================== convert (dispatch) ====================

    @Test
    fun convert_routesTemperatureCorrectly() {
        val result = ConversionEngine.convert(
            100.0,
            unit("celsius", "°C", 1.0),
            unit("fahrenheit", "°F", 1.0),
            ConverterType.TEMPERATURE
        )
        assertEquals(212.0, result, 0.0001)
    }

    @Test
    fun convert_routesFuelConsumptionCorrectly() {
        val result = ConversionEngine.convert(
            0.0,
            unit("liter_per_100km", "L/100km", 1.0),
            unit("kilometer_per_liter", "km/L", 1.0),
            ConverterType.FUEL_CONSUMPTION
        )
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun convert_routesSoundCorrectly() {
        val result = ConversionEngine.convert(
            20.0,
            unit("decibel", "dB", 1.0),
            unit("bel", "B", 10.0),
            ConverterType.SOUND
        )
        assertEquals(2.0, result, 0.0001)
    }

    @Test
    fun convert_routesGenericForLength() {
        val result = ConversionEngine.convert(
            1.0,
            unit("kilometer", "km", 1000.0),
            unit("meter", "m", 1.0),
            ConverterType.LENGTH
        )
        assertEquals(1000.0, result, 0.0001)
    }

    @Test
    fun convert_routesGenericForMass() {
        val result = ConversionEngine.convert(
            1.0,
            unit("kilogram", "kg", 1000.0),
            unit("gram", "g", 1.0),
            ConverterType.MASS
        )
        assertEquals(1000.0, result, 0.0001)
    }

    @Test
    fun convert_routesGenericForTime() {
        val result = ConversionEngine.convert(
            1.0,
            unit("hour", "h", 3600.0),
            unit("second", "s", 1.0),
            ConverterType.TIME
        )
        assertEquals(3600.0, result, 0.0001)
    }

    @Test
    fun convert_routesGenericForEnergy() {
        val result = ConversionEngine.convert(
            1.0,
            unit("kilojoule", "kJ", 1000.0),
            unit("joule", "J", 1.0),
            ConverterType.ENERGY
        )
        assertEquals(1000.0, result, 0.0001)
    }

    @Test
    fun convert_routesGenericForFrequency() {
        val result = ConversionEngine.convert(
            1.0,
            unit("megahertz", "MHz", 1_000_000.0),
            unit("hertz", "Hz", 1.0),
            ConverterType.FREQUENCY
        )
        assertEquals(1_000_000.0, result, 0.0001)
    }

    // ==================== formatResult ====================

    @Test
    fun formatResult_wholeNumber_returnsNoDecimal() {
        assertEquals("5", ConversionEngine.formatResult(5.0))
    }

    @Test
    fun formatResult_zero_returnsZero() {
        assertEquals("0", ConversionEngine.formatResult(0.0))
    }

    @Test
    fun formatResult_largeWholeNumber() {
        assertEquals("1000", ConversionEngine.formatResult(1000.0))
    }

    @Test
    fun formatResult_decimalWithTrailingZeros_trimmed() {
        assertEquals("1.5", ConversionEngine.formatResult(1.5000))
    }

    @Test
    fun formatResult_twoDecimalPlaces() {
        assertEquals("1.25", ConversionEngine.formatResult(1.25))
    }

    @Test
    fun formatResult_fourDecimalPlaces() {
        assertEquals("1.2345", ConversionEngine.formatResult(1.2345))
    }

    @Test
    fun formatResult_smallDecimal() {
        assertEquals("0.0254", ConversionEngine.formatResult(0.0254))
    }

    @Test
    fun formatResult_smallDecimalWithTrailingZeros_trimmed() {
        assertEquals("0.001", ConversionEngine.formatResult(0.001))
    }
}
