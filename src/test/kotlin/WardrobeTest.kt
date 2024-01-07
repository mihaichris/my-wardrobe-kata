import org.junit.jupiter.api.Test

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

    }

}