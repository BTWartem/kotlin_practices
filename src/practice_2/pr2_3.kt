package practice_2

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln() }

    for (i in 0..n-1){
        for(j in i+1..n-1){
            if (arr[i] == arr[j]){
                println(arr[j])
                return
            }
        }
    }
}