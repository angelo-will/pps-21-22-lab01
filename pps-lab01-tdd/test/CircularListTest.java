import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
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
    void testSizeAddingMoreElements(){
        int lastNumberToAdd = 4;
        addToListCrescentNumbers(1, lastNumberToAdd);
        assertEquals(lastNumberToAdd-1, circularList.size());
    }


    @Test
    void testInitialEmptyList(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testNextWithEmptyList() {
        assertTrue(circularList.next().isEmpty());
        assertTrue(circularList.next().isEmpty());
    }

    @Test
    void testNextWithOneElement(){
        circularList.add(5);
        assertEquals(5, (int) circularList.next().get());
    }
    
    @Test
    void testNextWithMoreElements(){
        int numberElementsToAdd = 4;
        addToListCrescentNumbers(0, numberElementsToAdd);
        IntStream.range(0,numberElementsToAdd).forEach(value -> assertEquals(value,circularList.next().get()));
        IntStream.range(0,numberElementsToAdd).forEach(value -> assertEquals(value,circularList.next().get()));
    }

    @Test
    void testPreviousWithEmptyList(){
        assertTrue(circularList.previous().isEmpty());
        assertTrue(circularList.previous().isEmpty());
    }

    @Test
    void testPreviousWithOneElement(){
        circularList.add(5);
        assertEquals(5,circularList.previous().get());
    }

    @Test
    void testPreviousWithMoreElements() {
        int numberElementsToAdd = 5;
        addToListCrescentNumbers(0, numberElementsToAdd);
        IntStream.range(0, numberElementsToAdd)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(value -> assertEquals(value, circularList.previous().get()));
        IntStream.range(0, numberElementsToAdd)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(value -> assertEquals(value, circularList.previous().get()));
    }

    private void addToListCrescentNumbers(int firstNumberToAdd, int lastNumberToAdd) {
        IntStream.range(firstNumberToAdd, lastNumberToAdd).forEach(e->circularList.add(e));
    }
}
