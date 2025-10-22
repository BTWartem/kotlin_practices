package practice_8

enum class DrinkType(
    private val volumeMl: Int,
    private val temperatureCelsius: Int
) {
    COFFEE(250, 85) {
        override fun getDisplayName(): String = "Кофе"
    },
    TEA(300, 75) {
        override fun getDisplayName(): String = "Чай"
    },
    JUICE(200, 5) {
        override fun getDisplayName(): String = "Сок"
    },
    WATER(500, 10) {
        override fun getDisplayName(): String = "Вода"
    },
    COCOA(200, 65) {
        override fun getDisplayName(): String = "Какао"
    };

    abstract fun getDisplayName(): String
    fun getVolume(): Int = volumeMl
    fun isHot(): Boolean = temperatureCelsius > 60
    fun getTemperature(): Int = temperatureCelsius
}

fun main() {
    // Вывод информации о каждом напитке
    DrinkType.values().forEach { drink ->
        println("Напиток: ${drink.getDisplayName()}")
        println("Объем: ${drink.getVolume()} мл")
        println("Температура: ${drink.getTemperature()}°C")
        println("Горячий: ${if (drink.isHot()) "Да" else "Нет"}")
        println("---")
    }
}