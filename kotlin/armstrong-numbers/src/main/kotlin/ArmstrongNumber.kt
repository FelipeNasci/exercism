import kotlin.math.pow

object ArmstrongNumber {

    private fun Int.toList(): List<Int> = this.toString().map { it.toString().toInt() }

    private fun Int.pow(exponent: Int): Int = this.toDouble().pow(exponent).toInt()

    fun check(input: Int): Boolean {
        val numbers = input.toList()
        val exponent = numbers.size

        val result = numbers.sumOf { it.pow(exponent) }

        return input == result
    }
}
