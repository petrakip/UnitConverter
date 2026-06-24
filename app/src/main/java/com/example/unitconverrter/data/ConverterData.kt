package com.example.unitconverrter.data

import com.example.unitconverrter.R

object ConverterData {
    val categories = listOf(

        ConverterCategory(
            title = R.string.length,
            icon = R.drawable.length,
            converterType = ConverterType.LENGTH,
            units = listOf(
                UnitItem("meter", R.string.meter, "m", 1.0),
                UnitItem("kilometer", R.string.kilometer, "km", 1000.0),
                UnitItem("centimeter", R.string.centimeter, "cm", 0.01),
                UnitItem("millimeter", R.string.millimeter, "mm", 0.001),
                UnitItem("inch", R.string.inch, "in", 0.0254),
                UnitItem("foot", R.string.foot, "ft", 0.3048),
                UnitItem("mile", R.string.mile, "mi", 1609.34)
            )
        ),

        ConverterCategory(
            title = R.string.mass,
            icon = R.drawable.mass,
            converterType = ConverterType.MASS,
            units = listOf(
                UnitItem("gram", R.string.gram, "g", 1.0),
                UnitItem("kilogram", R.string.kilogram, "kg", 1000.0),
                UnitItem("milligram", R.string.milligram, "mg", 0.001),
                UnitItem("ton", R.string.ton, "t", 1_000_000.0),
                UnitItem("pound", R.string.pound, "lb", 453.592),
                UnitItem("ounce", R.string.ounce, "oz", 28.3495)
            )
        ),

        ConverterCategory(
            title = R.string.temperature,
            icon = R.drawable.temperature,
            converterType = ConverterType.TEMPERATURE,
            units = listOf(
                UnitItem("celsius", R.string.celsius, "°C", 1.0),
                UnitItem("fahrenheit", R.string.fahrenheit, "°F", 1.0),
                UnitItem("kelvin", R.string.kelvin, "K", 1.0)
            )
        ),

        ConverterCategory(
            title = R.string.area,
            icon = R.drawable.area,
            converterType = ConverterType.AREA,
            units = listOf(
                UnitItem("square_meter", R.string.square_meter, "m²", 1.0),
                UnitItem("square_kilometer", R.string.square_kilometer, "km²", 1_000_000.0),
                UnitItem("square_centimeter", R.string.square_centimeter, "cm²", 0.0001),
                UnitItem("hectare", R.string.hectare, "ha", 10_000.0),
                UnitItem("acre", R.string.acre, "ac", 4046.86)
            )
        ),

        ConverterCategory(
            title = R.string.volume,
            icon = R.drawable.volume,
            converterType = ConverterType.VOLUME,
            units = listOf(
                UnitItem("liter", R.string.liter, "L", 1.0),
                UnitItem("milliliter", R.string.milliliter, "mL", 0.001),
                UnitItem("cubic_meter", R.string.cubic_meter, "m³", 1000.0),
                UnitItem("gallon", R.string.gallon, "gal", 3.78541),
                UnitItem("cup", R.string.cup, "cup", 0.236588)
            )
        ),

        ConverterCategory(
            title = R.string.speed,
            icon = R.drawable.speed,
            converterType = ConverterType.SPEED,
            units = listOf(
                UnitItem("meter_per_second", R.string.meter_per_second, "m/s", 1.0),
                UnitItem("kilometer_per_hour", R.string.kilometer_per_hour, "km/h", 0.277778),
                UnitItem("mile_per_hour", R.string.mile_per_hour, "mph", 0.44704),
                UnitItem("knot", R.string.knot, "kn", 0.514444)
            )
        ),

        ConverterCategory(
            title = R.string.time,
            icon = R.drawable.time,
            converterType = ConverterType.TIME,
            units = listOf(
                UnitItem("second", R.string.second, "s", 1.0),
                UnitItem("minute", R.string.minute, "min", 60.0),
                UnitItem("hour", R.string.hour, "h", 3600.0),
                UnitItem("day", R.string.day, "d", 86400.0)
            )
        ),

        ConverterCategory(
            title = R.string.energy,
            icon = R.drawable.energy,
            converterType = ConverterType.ENERGY,
            units = listOf(
                UnitItem("joule", R.string.joule, "J", 1.0),
                UnitItem("kilojoule", R.string.kilojoule, "kJ", 1000.0),
                UnitItem("calorie", R.string.calorie, "cal", 4.184),
                UnitItem("kilowatt_hour", R.string.kilowatt_hour, "kWh", 3_600_000.0)
            )
        ),

        ConverterCategory(
            title = R.string.power,
            icon = R.drawable.power,
            converterType = ConverterType.POWER,
            units = listOf(
                UnitItem("watt", R.string.watt, "W", 1.0),
                UnitItem("kilowatt", R.string.kilowatt, "kW", 1000.0),
                UnitItem("horsepower", R.string.horsepower, "hp", 745.7)
            )
        ),

        ConverterCategory(
            title = R.string.data_storage,
            icon = R.drawable.data_stotage,
            converterType = ConverterType.DATA_STORAGE,
            units = listOf(
                UnitItem("byte", R.string.byte_unit, "B", 1.0),
                UnitItem("kilobyte", R.string.kilobyte, "KB", 1024.0),
                UnitItem("megabyte", R.string.megabyte, "MB", 1_048_576.0),
                UnitItem("gigabyte", R.string.gigabyte, "GB", 1_073_741_824.0)
            )
        ),

        ConverterCategory(
            title = R.string.fuel_consumption,
            icon = R.drawable.fuel_consumption,
            converterType = ConverterType.FUEL_CONSUMPTION,
            units = listOf(
                UnitItem("liter_per_100km", R.string.liter_per_100km, "L/100km", 1.0),
                UnitItem("kilometer_per_liter", R.string.kilometer_per_liter, "km/L", 1.0),
                UnitItem("mile_per_gallon", R.string.mile_per_gallon, "mpg", 1.0)
            )
        ),

        ConverterCategory(
            title = R.string.angle,
            icon = R.drawable.angle,
            converterType = ConverterType.ANGLE,
            units = listOf(
                UnitItem("degree", R.string.degree, "°", 1.0),
                UnitItem("radian", R.string.radian, "rad", 57.2958)
            )
        ),

        ConverterCategory(
            title = R.string.astronomy,
            icon = R.drawable.astronomy,
            converterType = ConverterType.ASTRONOMY,
            units = listOf(
                UnitItem("astronomical_unit", R.string.astronomical_unit, "AU", 1.496e+11),
                UnitItem("light_year", R.string.light_year, "ly", 9.461e+15),
                UnitItem("parsec", R.string.parsec, "pc", 3.086e+16),
                UnitItem("kilometer", R.string.kilometer, "km", 1000.0)
            )
        ),

        ConverterCategory(
            title = R.string.density,
            icon = R.drawable.density,
            converterType = ConverterType.DENSITY,
            units = listOf(
                UnitItem("kilogram_per_cubic_meter", R.string.kilogram_per_cubic_meter, "kg/m³", 1.0),
                UnitItem("gram_per_cubic_centimeter", R.string.gram_per_cubic_centimeter, "g/cm³", 1000.0),
                UnitItem("gram_per_liter", R.string.gram_per_liter, "g/L", 1.0),
                UnitItem("pound_per_cubic_foot", R.string.pound_per_cubic_foot, "lb/ft³", 16.0185)
            )
        ),

        ConverterCategory(
            title = R.string.frequency,
            icon = R.drawable.frequency,
            converterType = ConverterType.FREQUENCY,
            units = listOf(
                UnitItem("hertz", R.string.hertz, "Hz", 1.0),
                UnitItem("kilohertz", R.string.kilohertz, "kHz", 1000.0),
                UnitItem("megahertz", R.string.megahertz, "MHz", 1_000_000.0),
                UnitItem("gigahertz", R.string.gigahertz, "GHz", 1_000_000_000.0)
            )
        ),

        ConverterCategory(
            title = R.string.screen_resolution,
            icon = R.drawable.screen_resolution,
            converterType = ConverterType.SCREEN_RESOLUTION,
            units = listOf(
                UnitItem("pixel", R.string.pixel, "px", 1.0),
                UnitItem("point", R.string.point, "pt", 1.333),
                UnitItem("density_independent_pixel", R.string.density_independent_pixel, "dp", 1.0),
                UnitItem("scale_independent_pixel", R.string.scale_independent_pixel, "sp", 1.0)
            )
        ),

        ConverterCategory(
            title = R.string.sound,
            icon = R.drawable.sound,
            converterType = ConverterType.SOUND,
            units = listOf(
                UnitItem("decibel", R.string.decibel, "dB", 1.0),
                UnitItem("bel", R.string.bel, "B", 10.0),
                UnitItem("neper", R.string.neper, "Np", 8.686)
            )
        ),

        ConverterCategory(
            title = R.string.typography,
            icon = R.drawable.typography,
            converterType = ConverterType.TYPOGRAPHY,
            units = listOf(
                UnitItem("pixel", R.string.pixel, "px", 1.0),
                UnitItem("point", R.string.point, "pt", 1.333),
                UnitItem("em", R.string.em, "em", 16.0),
                UnitItem("rem", R.string.rem, "rem", 16.0),
                UnitItem("scale_independent_pixel", R.string.scale_independent_pixel, "sp", 1.0)
            )
        )
    )
}