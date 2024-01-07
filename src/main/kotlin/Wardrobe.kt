class Wardrobe(private var elements: MutableList<Element>) {
    val availableSizes: List<Int> = listOf(50, 75, 100)

    companion object {
        const val WALL_LENGTH = 250
    }

    fun addElement(element: Element) {
        elements.add(element)
    }

    fun getElements(): List<Element> {
        return elements.toList()
    }

    fun isFull(): Boolean {
        return elements.sumOf { it.getSize() } == WALL_LENGTH;
    }
}