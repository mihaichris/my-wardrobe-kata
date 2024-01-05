class Wardrobe(private var elements: MutableList<Element>) {
    companion object {
        const val WALL_LENGTH = 250
    }

    fun addElement(element: Element) {
        elements.add(element)
    }

    fun isFull(): Boolean {
        return elements.sumOf { it.getSize() } == WALL_LENGTH;
    }
}