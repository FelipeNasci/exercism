object CryptoSquare {

    private fun String.toList(column: Int): List<String> {
        var normalized = this
        val list = ArrayList<String>()

        do {
            val substring = normalized.substring(0, column)
            normalized = normalized.removeRange(0, column )
            list.add(substring)
        } while (normalized.length > column)

        val amountWhiteSpaces = column - normalized.length
        val whiteSpaces = Array(amountWhiteSpaces) { " " }

        val concatenated = normalized + whiteSpaces.joinToString("")
        list.add(concatenated)

        return list
    }

    private fun List<String>.shuffle(column: Int): List<String>{
        val words = Array(column) { "" }

        this.forEach {
            var word = it
            var index = 0

            while (word.isNotEmpty()) {
                val character = word.firstOrNull()
                val cipheredWord = words.get(index) + character
                words.set(index, cipheredWord)
                word = word.removeRange(0, 1)
                index++
            }

        }

        return words.map { it }
    }

    private val pattern = Regex("[,.;@%! ]")

    private fun Double.round(): Double = Math.ceil(this)
    private fun Double.squareRadix(): Double = Math.sqrt(this.toDouble() )

    private fun String.normalize(): String = this.replace(pattern, "").lowercase()

    private fun String.toChunk(column: Int): List<String> {
        if(this.isEmpty()) return emptyList()
        return this.chunked(column).map { it.padEnd(column, padChar = ' ') }
    }

    private fun List<String>.shuffler(column: Int): List<String> {
        val words = MutableList(column) { "" }

        this.forEach {
            it.forEachIndexed {
                index, character ->
                    val word = words.get(index) + character
                    words.set(index, word)
            }
        }

        return words
    }

    fun ciphertext(plaintext: String): String {
        val normalized =  plaintext.normalize()
        val amountChar = normalized.length.toDouble()
        val column = amountChar.squareRadix().round().toInt()
        val chunks = normalized.toChunk(column)
        val shuffles = chunks.shuffler(column)

        return shuffles.joinToString(" ")
    }

}

fun main(){
    val text = "If man was meant to stay on the ground, god would have given us roots."
    println(CryptoSquare.ciphertext(text))

}