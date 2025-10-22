package practice_8

open class Animal {
    open fun speak() = "Some sound"
}

class Cat : Animal() {
    override fun speak() = "Meow!"
}

fun main() {
    val cat = Cat()
    println(cat.speak())
}