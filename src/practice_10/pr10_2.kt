package practice_10

class User(val name: String, val age: Int, val friends: List<String>)

fun main() {
    val usersData = object {
        val users = listOf(
            User("Вася", 17, listOf("Петя", "Маша")),
            User("Петя", 18, listOf("Вася", "Саша")),
            User("Маша", 19, listOf("Вася", "Даша")),
            User("Саша", 20, listOf("Петя", "Маша", "Даша")),
            User("Даша", 21, listOf("Маша", "Саша"))
        )

        fun findOldest() = users.maxByOrNull { it.age }

        fun showUser(user: User) {
            println("Имя: ${user.name}")
            println("Возраст: ${user.age}")
            println("Друзья: ${user.friends.joinToString(" ")}")
            println("---")
        }

        fun findByName(name: String) = users.filter { it.name.contains(name) }
    }

    println("=== Все пользователи ===")
    usersData.users.forEach { usersData.showUser(it) }

    println("=== Самый старший пользователь ===")
    usersData.findOldest()?.let { oldest ->
        println("Самый старший: ${oldest.name}, возраст: ${oldest.age}")
        usersData.showUser(oldest)
    }

    println("=== Статистика ===")
    println("Всего пользователей: ${usersData.users.size}")
    println("Средний возраст: ${usersData.users.map { it.age }.average().toInt()}")

    println("\n=== Кто с кем дружит ===")
    usersData.users.forEach { user ->
        println("${user.name} дружит с: ${user.friends.joinToString(" ")}")
    }
}