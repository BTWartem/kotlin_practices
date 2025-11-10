package practice_10

enum class Gender { Male, Female }

class NameError(msg: String) : Exception(msg)
class DateError(msg: String) : Exception(msg)
class GenderError(msg: String) : Exception(msg)
class WeightError(msg: String) : Exception(msg)

class FormValidator {
    fun checkName(name: String) {
        if (name.length < 2 || name.length > 20) throw NameError("Имя должно быть от 2 до 20 символов")
    }

    fun checkBirthDate(dateStr: String) {
        try {
            val (day, month, year) = dateStr.split(".").map { it.toInt() }
            if (year < 1900) throw DateError("Год должен быть не меньше 1900")
            if (year > 2025) throw DateError("Год должен быть не больше 2025")
            if (month !in 1..12 || day !in 1..31) throw DateError("Неверная дата")
        } catch (e: Exception) {
            throw DateError("Неверный формат даты")
        }
    }

    fun checkGender(genderStr: String) {
        if (genderStr !in Gender.values().map { it.name }) throw GenderError("Пол должен быть Male или Female")
    }

    fun checkWeight(weightStr: String) {
        val weight = weightStr.toDoubleOrNull() ?: throw WeightError("Вес должен быть числом")
        if (weight <= 0) throw WeightError("Вес должен быть положительным")
    }

    fun validateAll(name: String, birthDate: String, gender: String, weight: String): Boolean {
        return try {
            checkName(name)
            checkBirthDate(birthDate)
            checkGender(gender)
            checkWeight(weight)
            println("Всё ок! Можно отправлять")
            true
        } catch (e: Exception) {
            println("Ошибка: ${e.message}")
            false
        }
    }
}

fun main() {
    val validator = FormValidator()

    val tests = listOf(
        arrayOf("Иван", "15.05.1990", "Male", "75.5"),
        arrayOf("Иван", "01.01.1800", "Оно", "-5"),
        arrayOf("А", "15.05.2025", "Female", "Б")
    )

    tests.forEachIndexed { i, test ->
        println("--- Тест ${i + 1} ---")
        val result = validator.validateAll(test[0], test[1], test[2], test[3])
        println("Результат: $result\n")
    }
}