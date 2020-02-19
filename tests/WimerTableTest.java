import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
            actual[i] = iv[i].size;
        assertArrayEquals(expected, actual);
    }

    @Test
    void compose()
    {
    }
}