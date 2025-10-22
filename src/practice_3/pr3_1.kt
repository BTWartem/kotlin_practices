package practice_3

import java.util.Random

fun main() {
    game()
}

fun game(){
    val random = Random()
    val secretNumber = random.nextInt(1001)

    println("Угадай число от 0 до 1000. Для выхода введи отрицательное число.")

    while (true) {
        print("Твоя догадка: ")
        val number = readLine()?.toIntOrNull() ?: continue

        when {
            number < 0 -> {
                println("Выход. Загаданное число: $secretNumber")
                return
            }
            number == secretNumber -> {
                println("Победа!")
                return
            }
            number < secretNumber -> println("Это число меньше загаданного.")

            else -> println("Это число больше загаданного.")
        }
    }
}