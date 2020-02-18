import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListTest
{

    private static AdjacencyList al;
    static Iterator<Integer> iter;
    private final String fileName = "tests/edgelist1";

    @BeforeEach
    void setUp()
    {
        al = new AdjacencyList(fileName);
    }

//    @org.junit.jupiter.api.AfterEach
//    void tearDown()
//    {
//    }

    @Test
    void constructor()
    {
        assertNotNull(al);

    }

    @Test
    void add()
    {

        al.add(0,1);
        iter = al.getIterator(0);
        int expected = 1;
        int actual = iter.next();
        assertEquals(expected, actual);
        assertFalse(iter.hasNext());

        iter = al.getIterator(1);
        expected = 0;
        actual = iter.next();
        assertEquals(expected, actual);
    }

    @Test
    void getIterator()
    {
        for (int i = 0; i < 10; i++)
            al.add(i, i+1);
    }

    @Test
    void getParentArray()
    {
        var expected = new int[]{-1, 0, 0, 1, 1, 2, 2};
        var actual = al.getParentArray(0);
        assertArrayEquals(expected, actual);
    }
}