package practice_1

fun main() {
    val dnk = readLine() ?: ""
    val aCount = dnk.count { it == 'A' }
    val tCount = dnk.count { it == 'T' }
    val gCount = dnk.count { it == 'G' }
    val cCount = dnk.count { it == 'C' }
    println("$aCount $tCount $gCount $cCount")
}