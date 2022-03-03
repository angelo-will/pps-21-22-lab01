import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    void testSizeAddingOneElement(){
        circularList.add(5);
        assertEquals(1, circularList.size());
    }

    @Test
    void testSizeAddingMoreElement(){
        int elementAdded = 4;
        addToListCrescentNumbers(1, elementAdded);
        assertEquals(elementAdded, circularList.size());
    }


    @Test
    void testInitialEmptyList(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testNextWithEmptyList() {
        assertTrue(circularList.next().isEmpty());
    }

    @Test
    void testNextWithOneElement(){
        circularList.add(5);
        assertEquals(5, (int) circularList.next().get());
    }
    
    @Test
    void testNextWithMoreElement(){
        int numberElementsToAdd = 10;
        addToListCrescentNumbers(1, numberElementsToAdd);
        IntStream.range(1,numberElementsToAdd).forEach(value -> assertEquals(value,circularList.next().get()));
    }
    
    private void addToListCrescentNumbers(int firstNumberToAdd, int lastNumberToAdd) {
        IntStream.range(firstNumberToAdd, lastNumberToAdd +1).forEach(e->circularList.add(e));
    }
}
