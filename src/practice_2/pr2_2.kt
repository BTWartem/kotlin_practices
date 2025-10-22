package practice_2

fun main() {
    val n = readln().toInt()
    var cnt = 1
    val numbers = IntArray(n) { readln().toInt()}

    for (i in 1..n-1) {
        if (numbers[i] == numbers[i - 1]) {
            cnt++
        } else {
            println("$cnt ${numbers[i - 1]}")
            cnt = 1
        }
    }
    println("$cnt ${numbers[n - 1]}")
}
