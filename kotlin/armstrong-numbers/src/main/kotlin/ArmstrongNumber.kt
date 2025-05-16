import kotlin.math.pow

object ArmstrongNumber {

    private fun parseNumberToList(input: Int): List<Int> {
        var aux = input
        val list = ArrayList<Int>()
        val divisor = 10
        
        do {
            list.add(aux.mod(divisor))
            aux /= divisor
        } while(aux > 0)
        
        list.reverse()
        
        return list
    }

    private fun power(base: Int, exponent: Int): Int{
        var aux = 1
        var count = 0
        
        do {
            aux *= base
            count++
        } while (count < exponent)

        return aux
    }

    private fun Int.toList(): List<Int> = this.toString().map { it.toString().toInt() }

    private fun Int.pow(exponent: Int): Int = this.toDouble().pow(exponent).toInt()

    fun check(input: Int): Boolean {
        val numbers = input.toList()
        val exponent = numbers.size

        val result = numbers.sumOf { it.pow(exponent) }

        return input == result
    }
}
