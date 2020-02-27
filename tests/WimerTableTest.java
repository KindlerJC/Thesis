import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WimerTableTest
{
    private static WimerTable wimerTable;
    private static String fileName = "tests/mindomset.txt";
    @BeforeEach
    void setUp()
    {
        wimerTable = new WimerTable(fileName);
    }

    @Test
    void getInitialVector()
    {
        var expected = new int[]{1, -1, 0};
        var iv = wimerTable.getInitialVector().getList();
        var actual = new int[3];
        for (int i = 0; i < iv.length; i++)
            actual[i] = iv[i].getSize();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getIterator()
    {
        var iter = wimerTable.getIterator(0);
        var comp = iter.next();
        compareCompositions(0, 1, comp);
        comp = iter.next();
        compareCompositions(0, 2, comp);

        iter = wimerTable.getIterator(1);
        comp = iter.next();
        compareCompositions(1, 0, comp);
        comp = iter.next();
        compareCompositions(1, 1, comp);
        comp = iter.next();
        compareCompositions(2, 0, comp);

        iter = wimerTable.getIterator(2);
        comp = iter.next();
        compareCompositions(2, 1, comp);

    }

    void compareCompositions(int parent, int child, Composition comp)
    {
        assertTrue(parent == comp.getParent() && child == comp.getChild());
    }



    @Test
    void compose()
    {
        var init = wimerTable.getInitialVector();
        var a = new Vector(init);
        var b = new Vector(init);

        var composition = wimerTable.compose(a, b);
        var actual = composition.getList();
        System.out.println(Arrays.toString(actual));

        assertEquals(1, actual[0].getSize());
        assertEquals(1, actual[1].getSize());
        assertEquals(-1, actual[2].getSize());

        assertTrue(actual[0].getComp().equals(0, 2));
        assertTrue(actual[1].getComp().equals(2, 0));
//        assertTrue(actual[2].getComp().equals(2, 1));


    }


}