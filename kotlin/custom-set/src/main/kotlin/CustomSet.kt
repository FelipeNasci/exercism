class CustomSet(vararg values: Int) {

    private val collection: MutableMap<Int, Int> = emptyMap<Int, Int>().toMutableMap()

    init {
        values.forEach { this.collection[it] = it }
    }

    fun print() = println(collection)


    fun values(): List<Int> = collection.keys.toList()


    override fun toString(): String {
        if (collection.isEmpty()) return ""

        return collection.map { it.toString() }.joinToString("")
    }

    override fun equals(other: Any?): Boolean {
        if (other !is CustomSet) return false
        return collection == other.collection
    }

    fun isEmpty(): Boolean {
        return collection.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        val collection = this.toString()
        val otherCollection = other.toString()

        this.print()
        other.print()

        if (collection.isEmpty()) return true
        if (otherCollection.isEmpty()) return false

        return otherCollection.contains(collection)
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return this.values().filter { it in other.values() }.isEmpty()
    }

    fun contains(other: Int): Boolean {
        return this.toString().contains(other.toString())
    }

    fun intersection(other: CustomSet): CustomSet {
        TODO()
    }

    fun add(other: Int) {
        collection.put(other, other)
    }

    operator fun plus(other: CustomSet): CustomSet {
        TODO("Implement this function to complete the task")
    }

    operator fun minus(other: CustomSet): CustomSet {
        TODO("Implement this function to complete the task")
    }


}

fun main (){

    val set1 = CustomSet(1, 2)
    val set2 = CustomSet(2, 1)

    println(set2.equals(set1))


}