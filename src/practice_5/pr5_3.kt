package practice_5

class StudentService {
    fun findBestStudent(students: Array<Student>): Student? {
        if (students.isEmpty()) return null

        var bestStudent = students[0]
        var maxAverage = bestStudent.getAverageScore()

        for (i in 1 until students.size) {
            val currentAverage = students[i].getAverageScore()
            if (currentAverage > maxAverage) {
                maxAverage = currentAverage
                bestStudent = students[i]
            }
        }

        return bestStudent
    }
    fun sortStudentsByLastName(students: Array<Student>): Array<Student> {
        return students.sortedBy { it.getLastName() }.toTypedArray()
    }
}



fun main() {
    val service = StudentService()

    val student1 = Student().apply {
        setFirstName("John")
        setLastName("Smith")
        setScores(intArrayOf(5, 5, 5, 5, 5, 5, 5, 5, 5, 5))
    }

    val student2 = Student().apply {
        setFirstName("Alice")
        setLastName("Johnson")
        setScores(intArrayOf(4, 4, 4, 4, 4, 4, 4, 4, 4, 4))
    }

    val student3 = Student().apply {
        setFirstName("Bob")
        setLastName("Adams")
        setScores(intArrayOf(5, 5, 5, 5, 5, 5, 5, 5, 5, 4))
    }

    val students = arrayOf(student1, student2, student3)

    val bestStudent = service.findBestStudent(students)
    println("Лучший студент: ${bestStudent?.getFirstName()} ${bestStudent?.getLastName()}")

    val sortedStudents = service.sortStudentsByLastName(students)
    println("Студенты отсортированные по фамилии:")
    sortedStudents.forEach {
        println("${it.getLastName()} ${it.getFirstName()}")
    }
}
