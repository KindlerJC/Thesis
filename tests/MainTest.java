import org.junit.jupiter.api.Test;

class MainTest
{
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

        Main.makeTables(files);
        WimerTable wimerTable = Main.wimerTable;
        boolean isMax = wimerTable.isMax();
        int validClasses = wimerTable.getValidClasses();

        var result = Main.getFinalVector(0);

        printRec(result);


    }

    void printRec(Vector ptr)
    {
        if (ptr.getLeft() == null)
        {
            System.out.println(ptr);
            return;
        }
        printRec(ptr.getLeft());
        System.out.println(ptr);
        printRec(ptr.getRight());
    }

}