package practice_3

import kotlin.random.Random

fun main() {
    create_password()
}

fun create_password() {
    var n: Int
    do {
        print("Длина пароля: ")
        n = readLine()?.toIntOrNull() ?: 0
        if (n < 8) println("Пароль с $n символами небезопасен")
    } while (n < 8)

    val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lower = "abcdefghijklmnopqrstuvwxyz"
    val digits = "0123456789"
    val special = "_*-"
    val all = upper + lower + digits + special

    val password = buildString {
        append(upper.random())
        append(lower.random())
        append(digits.random())
        append(special.random())
        repeat(n - 4) { append(all.random()) }
    }

    println("Пароль: ${password.toString()}")
}
