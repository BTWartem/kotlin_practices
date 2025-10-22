package practice_6

class UniqueString(private var chars: CharArray) {
    constructor(str: String) : this(str.toCharArray())

    fun getChar(i: Int): Char{
        return chars[i]
    }

    fun length(): Int{
        return chars.size
    }

    fun display(){
        println(chars)
    }

    fun contains(sub: String): Boolean{
        if (chars.joinToString("").contains(sub)) return true else return false
    }

    fun contains(sub: CharArray): Boolean {
        if (chars.joinToString("").contains(sub.joinToString(""))) return true else return false
    }

    fun trimSpace(): UniqueString {
        var startIndex = 0
        while (startIndex < chars.size && chars[startIndex].isWhitespace()) {
            startIndex++
        }
        return UniqueString(chars.copyOfRange(startIndex, chars.size))
    }

    fun reverse(): UniqueString{
        return UniqueString(chars.reversedArray())
    }

    fun toCharArray(): CharArray = chars.copyOf()
}


fun main() {
    val str1 = UniqueString("   Hello World")
    val str2 = UniqueString(charArrayOf('K', 'o', 't', 'l', 'i', 'n'))

    str1.display()
    println("Длина: ${str1.length()}")
    println("3-й символ: ${str1.getChar(3)}")
    println("Содержит 'World': ${str1.contains("World")}")
    println("Содержит 'Java': ${str1.contains(charArrayOf('J', 'a', 'v', 'a'))}")

    val trimmed = str1.trimSpace()
    println("Без пробелов: '${String(trimmed.toCharArray())}'")

    val reversed = str2.reverse()
    println("Развернутая: '${String(reversed.toCharArray())}'")
}