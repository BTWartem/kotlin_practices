package practice_2

fun main() {
    val n = readln().toInt()
    val numbers = DoubleArray(n)
    var sum = 0.0

    for (i in 1..n){
        numbers[i-1] = readln().toDouble()
        sum += numbers[i-1]
    }

    print(sum / n)
}