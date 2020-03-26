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
//        Main.makeTables(files);
//        WimerTable wimerTable = Main.wimerTable;
//        boolean isMax = wimerTable.isMax();
//        int validClasses = wimerTable.getValidClasses();
//
//        var result = Main.getFinalVector(0);
//        initialVector = wimerTable.getInitialVector();
//
//        printRec(result, result.getBest(isMax, validClasses).getCompCase());


    }

//    void printRec(Vector ptr, int comp)
//    {
//        var currentComp = ptr.entryAt(comp);
//        if (ptr.getLeft() == null)
//        {
//            var size = initialVector.entryAt(comp).getSize();
//            if (size == 1)
//                System.out.println(ptr.position + " is in the set.");
//            return;
//        }
//
//        printRec(ptr.getLeft(), currentComp.getComp().getParent());
//        printRec(ptr.getRight(), currentComp.getComp().getChild());
//    }

}