import org.junit.jupiter.api.Test;

class MainTest
{
    static Vector initialVector;
    @Test
    void run()
    {
        String[] files = new String[]{"tests/edgelist1", "tests/mindomset.txt"};

        Vector result;
        Main.makeTables(files);
        WimerTable wimerTable = Main.wimerTable;
        boolean isMax = wimerTable.isMax();
        int validClasses = wimerTable.getValidClasses();

        for (int i = 0; i < 7; i++) {
            result = Main.getFinalVector(i);
            assert result.getBest(isMax, validClasses).getSize() == 2;
        }
    }
        @Test
    void runOnce()
    {
        String[] files = new String[] {"tests/edgelist1", "tests/mindomset.txt"};
        Main.main(files);

    }

    @Test
    void minimal()
    {
        String[] files = new String[]{"tests/edgelist1", "tests/minimalDomSet"};
        Main.main(files);

    }

}