package practice_1

fun main() {
    var money = readLine()?.toIntOrNull() ?: 0
    val numbers = listOf(8, 4, 2, 1)
    val counts = mutableListOf<Int>()

    for (number in numbers) {
        val count = money / number
        counts.add(count)
        money %= number
    }

    println(counts)
}