import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListTest
{

    static AdjacencyList al;
    static Iterator<Integer> iter;
    @org.junit.jupiter.api.BeforeEach
    void setUp()
    {
        al = new AdjacencyList(10);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown()
    {
    }

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
    void getIterator()
    {
    }
}