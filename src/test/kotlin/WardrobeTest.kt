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

}