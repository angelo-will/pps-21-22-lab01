import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
        IntStream.range(1,elementAdded+1).forEach(e->circularList.add(e));
        assertEquals(elementAdded, circularList.size());
    }

    @Test
    void testEmpyList(){
        assertTrue(circularList.isEmpty());
    }

    //TODO: test implementation
    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

}
