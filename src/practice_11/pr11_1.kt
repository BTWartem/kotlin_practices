package practice_11

// Базовые классы
data class Product(
    val id: Int,
    val name: String,
    var price: Double, // var для возможности изменения цены
    val category: String
)

class Order {
    var products: MutableList<Product> = mutableListOf()
    var totalPrice: Double = 0.0
    var status: String = "CREATED"
    var discount: Double = 0.0

    fun calculateFinalPrice(): Double = totalPrice * (1 - discount)
}

// Scope-функции для управления заказами
fun main() {
    // 1. apply - инициализация заказа
    val order = Order().apply {
        products.addAll(listOf(
            Product(1, "Laptop", 1000.0, "Electronics"),
            Product(2, "Mouse", 25.0, "Electronics"),
            Product(3, "Book", 15.0, "Education")
        ))
        totalPrice = products.sumOf { it.price }
        status = "PROCESSING"
    }

    // 2. let - расчет скидки (возвращаем результат)
    val finalPrice = order.let {
        it.discount = if (it.totalPrice > 500) 0.1 else 0.05
        it.calculateFinalPrice()
    }

    // 3. also - применение скидки к категории
    order.applyDiscount("Electronics", 0.05)

    // 4. run - обработка и вывод информации
    order.run {
        if (products.any { it.category == "Electronics" }) {
            status = "NEEDS_SHIPPING_INSURANCE"
        }
        println("Order status: $status, Final price: ${calculateFinalPrice()}")
    }

    // 5. with - вывод итоговой информации
    with(order) {
        println("=== ORDER SUMMARY ===")
        println("Products: ${products.joinToString { it.name }}")
        println("Total: $totalPrice")
        println("Discount: ${discount * 100}%")
        println("Final: ${calculateFinalPrice()}")
        println("Status: $status")
    }

    // 6. let с пересчетом после изменений
    val updatedFinalPrice = order.let {
        it.totalPrice = it.products.sumOf { product -> product.price }
        it.calculateFinalPrice()
    }
    println("Updated final price: $updatedFinalPrice")
}

// Функции расширения с scope-функциями
fun Order.applyDiscount(category: String, discountPercent: Double) = apply {
    products.filter { it.category == category }
        .forEach { it.price *= (1 - discountPercent) }
    totalPrice = products.sumOf { it.price }
    println("Applied $discountPercent discount to $category category")
}

fun Order.updateStatus(newStatus: String) = apply {
    status = newStatus
    println("Order status changed to: $newStatus")
}

// Дополнительная функция для создания заказа
fun createOrder(vararg products: Product): Order = Order().apply {
    this.products.addAll(products)
    totalPrice = this.products.sumOf { it.price }
    discount = if (totalPrice > 1000) 0.15 else 0.0
    status = "CREATED"
}