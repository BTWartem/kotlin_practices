package practice_6

class TimeMeasure(private var hours: Int, private var minutes: Int = 0, private var seconds: Int = 0) {

    init {
        require(hours in 0..23) { "Часы должны быть 0-23" }
        require(minutes in 0..59) { "Минуты должны быть 0-59" }
        require(seconds in 0..59) { "Секунды должны быть 0-59" }
    }

    fun display24HF() = println(String.format("%02d:%02d:%02d", hours, minutes, seconds))

    fun display12HF() {
        val NorD = if (hours < 12)"AM" else "PM"
        val displayHours = when (hours) {
            0 -> 12
            in 1..12 -> hours
            else -> hours - 12
        }
        println(String.format("%02d:%02d:%02d %s", displayHours, minutes, seconds, NorD))
    }

    fun addTime(addHours: Int, addMinutes: Int, addSeconds: Int) {
        require(addHours >= 0 && addMinutes >= 0 && addSeconds >= 0) { "Время не может быть отрицательным" }

        var totalSeconds = seconds + addSeconds
        seconds = totalSeconds % 60
        var totalMinutes = minutes + addMinutes + totalSeconds / 60
        minutes = totalMinutes % 60
        hours = (hours + addHours + totalMinutes / 60) % 24
    }
}


fun main() {
    val time1 = TimeMeasure(14, 30, 45)
    val time2 = TimeMeasure(9, 15)
    val time3 = TimeMeasure(23)
    time1.display24HF()
    time1.display12HF()
    time2.display12HF()
    time3.addTime(2, 500, 0)
    time3.display24HF()
}