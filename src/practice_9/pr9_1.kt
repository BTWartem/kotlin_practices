package practice_9

interface MoodState {
    var hunger: Int
    var energy: Int
    var happiness: Int
    fun updateState()
}

interface Birthable { fun wayOfBirth() }
interface Flying { fun fly() }
interface Swimming { fun swim() }

abstract class Animal(val name: String) : MoodState, Birthable {
    override var hunger = 30
    override var energy = 80
    override var happiness = 50

    fun eat() {
        hunger = (hunger - 30).coerceAtLeast(0)
        energy += 10
        println("$name ест")
    }

    fun sleep() {
        energy = (energy + 40).coerceAtMost(100)
        hunger += 10
        println("$name спит")
    }

    fun play() {
        happiness = (happiness + 20).coerceAtMost(100)
        energy -= 15
        println("$name играет")
    }

    override fun updateState() {
        hunger = (hunger + 5).coerceAtMost(100)
        energy = (energy - 3).coerceAtLeast(0)
        happiness = when {
            hunger > 70 || energy < 20 -> happiness - 10
            else -> happiness + 2
        }.coerceIn(0, 100)
    }

    fun showStatus() = println("$name: голод $hunger%, энергия $energy%, счастье $happiness%")
}

class Bat : Animal("Летучая мышь"), Flying {
    override fun wayOfBirth() = println("Живородящая")
    override fun fly() { energy -= 10; println("Медленно летает") }
}

class Dolphin : Animal("Дельфин"), Swimming {
    override fun wayOfBirth() = println("Живородящий")
    override fun swim() { energy -= 15; println("Быстро плавает") }
}

class GoldFish : Animal("Золотая рыбка"), Swimming {
    override fun wayOfBirth() = println("Мечет икру")
    override fun swim() { energy -= 5; println("Медленно плавает") }
}

class Eagle : Animal("Орел"), Flying {
    override fun wayOfBirth() = println("Откладывает яйца")
    override fun fly() { energy -= 20; println("Быстро летает") }
}

fun main() {
    val animals = listOf(Bat(), Dolphin(), GoldFish(), Eagle())

    while (true) {
        println("\n=== СИСТЕМА УПРАВЛЕНИЯ ЖИВОТНЫМИ ===")
        println("1.Список животных")
        println("2.Взаимодействовать с животным")
        println("3.Показать статусы всех")
        println("4.Выход")
        print("Выберите действие: ")

        when (readLine()) {
            "1" -> animals.forEachIndexed { i, a -> println("${i+1}. ${a.name}") }
            "2" -> {
                println("\nВыберите животное:")
                animals.forEachIndexed { i, a -> println("${i+1}. ${a.name}") }
                val animal = animals.getOrNull(readLine()!!.toInt()-1) ?: continue

                println("\n1.Кормить 2.Спать 3.Играть 4.Рождение 5.Движение")
                when (readLine()) {
                    "1" -> animal.eat()
                    "2" -> animal.sleep()
                    "3" -> animal.play()
                    "4" -> animal.wayOfBirth()
                    "5" -> when(animal) {
                        is Flying -> animal.fly()
                        is Swimming -> animal.swim()
                    }
                }
                animal.updateState()
            }
            "3" -> animals.forEach { it.showStatus() }
            "4" -> return
            else -> println("Неверный выбор!")
        }
    }
}
