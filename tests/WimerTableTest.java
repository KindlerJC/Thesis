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


    void compareCompositions(int parent, int child, Composition comp)
    {
        assertTrue(parent == comp.getParent() && child == comp.getChild());
    }



    @Test
    void compose()
    {
        var init = wimerTable.getInitialVector();
        var a = new Vector(init, 0);
        var b = new Vector(init, 1);
        var c = new Vector(init, 2);

        var composition = wimerTable.compose(a, b);
        var actual = composition.getList();
        System.out.println(Arrays.toString(actual));

        assertEquals(1, actual[0].getSize());
        assertEquals(1, actual[1].getSize());
        assertEquals(-1, actual[2].getSize());

        assertTrue(actual[0].getComp().equals(0, 2));
        assertTrue(actual[1].getComp().equals(2, 0));
        assertTrue(actual[2].getComp().equals(2, 0));

        var composition2 = wimerTable.compose(c, composition);
        actual = composition2.getList();
        System.out.println(Arrays.toString(actual));

        assertEquals(2, actual[0].getSize());
        assertEquals(1, actual[1].getSize());
        assertEquals(1, actual[2].getSize());

//        assertTrue(actual[0].getComp().equals(0, 2));
//        assertTrue(actual[1].getComp().equals(2, 0));
//        assertTrue(actual[2].getComp().equals(2, 0));


    }


}