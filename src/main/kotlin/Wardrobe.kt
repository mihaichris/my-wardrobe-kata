class Wardrobe(private var elements: MutableList<Element>) {
    val availableSizes: List<Int> = listOf(50, 75, 100)

    companion object {
        const val WALL_LENGTH = 250
    }

    fun addElement(element: Element) {
        elements.add(element)
    }

    fun findWardrobeCombinations(wardrobeSizes: List<Int>): List<List<Element>> {
        val combinations = mutableListOf<List<Element>>()

        fun generateCombinations(currCombination: List<Element>, index: Int, sum: Int) {
            if (sum == WALL_LENGTH) {
                combinations.add(currCombination)
                return
            }
            if (sum > WALL_LENGTH || index == wardrobeSizes.size) {
                return
            }
            generateCombinations(currCombination, index + 1, sum)
            val newCombination = currCombination.toMutableList()
            newCombination.add(Element(wardrobeSizes[index]))
            generateCombinations(newCombination, index, sum + wardrobeSizes[index])
        }

        generateCombinations(emptyList(), 0, 0)
        return combinations
    }

    fun getElements(): List<Element> {
        return elements.toList()
    }

    fun isFull(): Boolean {
        return elements.sumOf { it.getSize() } == WALL_LENGTH;
    }
}