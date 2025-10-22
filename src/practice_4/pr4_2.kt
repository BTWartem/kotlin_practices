package practice_4

fun main(){
    val words1 =arrayOf("banana", "apple", "agg", "agg", "agg", "banana")
    println(top(words1, 2))
}

fun top(words: Array<String>, k: Int): List<String> {
    require(k > 0) { "k должно быть положительным числом" }

    val Map = HashMap<String, Int>()
    for (word in words) {
        Map[word] = Map.getOrDefault(word, 0) + 1
    }

    val wordList = Map.keys.toList()
    val sortedWords = wordList.sortedByDescending { it }
        .sortedByDescending { Map[it] }

    return sortedWords.take(k)
}