package practice_3

fun main() {
    val text = readLine() ?: ""
    morse(text)
}

fun morse(text: String) {
    val alph = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"

    val morse_alph = arrayOf(
        ".-", "-...", ".--", "--.", "-..", ".", "...-", "--..", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", ".-.", "...", "-", "..-",
        "..-.", "....", "-.-.", "---.", "----", "--.-", "--.--", "-.--",
        "-..-", "..-..", "..--", ".-.-"
    )

    val result = StringBuilder()

    for (char in text) {
        val index = alph.indexOf(char)
        if (index != -1) {
            result.append(morse_alph[index]).append(" ")
        }
    }

    println(result.toString().trim())
}