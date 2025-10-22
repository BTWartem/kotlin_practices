package practice_4

import kotlin.random.Random

fun main() {
    while (true) {
        print("Введите XdY+Z: ")
        val input = readLine()?.trim() ?: break
        if (input == "exit") break

        try {
            val parts = input.split('d')
            val c = parts.getOrNull(0) ?: ""
            val rest = parts.getOrNull(1) ?: throw Exception("Ошибка формата")

            val modIndex = rest.indexOfAny(charArrayOf('+', '-'))
            val s = if (modIndex == -1) rest else rest.substring(0, modIndex)
            val m = if (modIndex == -1) "" else rest.substring(modIndex)

            val count = if (c.isEmpty()) 1 else c.toInt()
            val sides = s.toInt()
            val mod = if (m.isEmpty()) 0 else m.toInt()

            val rolls = List(count) { Random.nextInt(1, sides + 1) }
            val total = rolls.sum() + mod

            println("Броски: ${rolls.joinToString()} | Итог: $total")

        } catch (e: Exception) {
            println("Ошибка: неверный формат")
        }
    }
}