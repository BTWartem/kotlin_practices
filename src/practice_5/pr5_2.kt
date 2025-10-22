package practice_5

class Student {
    private var firstName: String = ""
    private var lastName: String = ""
    private var scores: IntArray = IntArray(10) { 0 }

    fun getFirstName(): String {
        return firstName.replaceFirstChar { it.uppercase() }
    }

    fun setFirstName(value: String) {
        firstName = value.trim()
    }

    fun getLastName(): String {
        return lastName.replaceFirstChar { it.uppercase() }
    }

    fun setLastName(value: String) {
        lastName = value.trim()
    }

    fun getScores(): IntArray {
        return scores.copyOf()
    }

    fun setScores(newScores: IntArray) {
        if (newScores.size == 10) {
            scores = newScores.copyOf()
        } else {
            throw IllegalArgumentException("Массив оценок должен содержать ровно 10 элементов")
        }
    }

    fun addScore(newScore: Int) {
        for (i in 0 until scores.size - 1) {
            scores[i] = scores[i + 1]
        }
        scores[scores.size - 1] = newScore
    }

    fun getAverageScore(): Double {
        if (scores.isEmpty()) return 0.0
        return scores.average()
    }
}


fun main() {
    val student = Student()

    student.setFirstName("  john  ")
    student.setLastName("  doe  ")

    student.setScores(intArrayOf(5, 4, 3, 5, 4, 3, 5, 4, 3, 5))

    student.addScore(4)

    println("Студент: ${student.getFirstName()} ${student.getLastName()}")
    println("Оценки: ${student.getScores().joinToString()}")
    println("Средний балл: ${student.getAverageScore()}")
}
