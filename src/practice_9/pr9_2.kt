package practice_9

class BestRepairEver {
    fun canRepair(device: String): Boolean {
        val lowerDevice = device.lowercase()
        return lowerDevice.contains("computer") ||
                lowerDevice.contains("phone") ||
                lowerDevice.contains("компьютер") ||
                lowerDevice.contains("телефон") ||
                lowerDevice.contains("ноутбук") ||
                lowerDevice.contains("laptop") ||
                lowerDevice.contains("смартфон") ||
                lowerDevice.contains("macbook")
    }
}

fun main() {
    val workshop = BestRepairEver()
    val devices = listOf(
        "iPhone 13",
        "Samsung Galaxy Phone",
        "Dell Laptop Computer",
        "Apple MacBook Pro",
        "iPad Tablet",
        "Xiaomi Smartphone",
        "Игровой компьютер",
        "Мобильный телефон",
        "Smartwatch",
        "Наушники"
    )

    println("=== ТЕСТИРОВАНИЕ МАСТЕРСКОЙ BEST REPAIR EVER ===")
    devices.forEach { device ->
        val result = workshop.canRepair(device)
        println("$device: ${if (result) "Можем починить" else "Не ремонтируем"}")
    }
}