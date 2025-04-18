object Acronym {
    private fun clearPhrase(phrase: String) = phrase.replace(Regex("[,.;_-]"), " ")

    private fun getAcronym(phrase: String) = phrase
        .split(" ")
        .filter { it.isNotEmpty() }
        .map{ it.first() }
        .joinToString(separator = "")

    fun generate(phrase: String) : String {
        val clearedPhrase = clearPhrase(phrase);
        val acronym = getAcronym(clearedPhrase).uppercase()
        return acronym;
    }
}
