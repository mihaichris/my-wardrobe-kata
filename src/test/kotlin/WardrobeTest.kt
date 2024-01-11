import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class WardrobeTest {

    private var wardrobe: Wardrobe = Wardrobe(mutableListOf());
    @BeforeEach
    fun init() {
        wardrobe = Wardrobe(mutableListOf())
    }

    @Test
    fun fit5ElementsUntilWardrobeIsFull() {
        while (!wardrobe.isFull()) {
            wardrobe.addElement(Element(50))
        }
        assertEquals(5, wardrobe.getElements().size)
    }

    @Test
    fun fitElementsUntilWardrobeIsFull() {
        while (!wardrobe.isFull()) {
            wardrobe.addElement(Element(50))
        }
        assertEquals(listOf(Element(50), Element(50), Element(50), Element(50), Element(50)), wardrobe.getElements())
    }

    @Test
    fun fitOnlyOneCombination() {
        var availableElements = listOf(50)
        val combinations = wardrobe.findWardrobeCombinations(availableElements)
        assertEquals(listOf(listOf(Element(50), Element(50), Element(50), Element(50), Element(50))), combinations)
    }

    @Test
    fun fitTwoCombination() {
        var availableElements = listOf(50, 75)
        val combinations = wardrobe.findWardrobeCombinations(availableElements)
        val expectedCombinations = listOf(
            listOf(Element(50), Element(50), Element(75), Element(75)),
            listOf(Element(50), Element(50), Element(50), Element(50), Element(50))
        )
        assertEquals(expectedCombinations, combinations)
    }

    @Test
    fun fitAllCombination() {
        val combinations = wardrobe.findWardrobeCombinations(wardrobe.availableSizes)
        val expectedCombinations = listOf(
            listOf(Element(75), Element(75), Element(100)),
            listOf(Element(50), Element(100), Element(100)),
            listOf(Element(50), Element(50), Element(75), Element(75)),
            listOf(Element(50), Element(50), Element(50), Element(100)),
            listOf(Element(50), Element(50), Element(50), Element(50), Element(50))
        )
        assertEquals(expectedCombinations, combinations)
    }
}