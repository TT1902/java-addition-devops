import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionTest {

    @Test
    void testAddition() {
        assertEquals(30, Addition.add(10, 20));
    }
}