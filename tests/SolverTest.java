import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolverTest
{
    static Solver slv;
    static final String PATH = "tests/text/";

    String e1 = PATH + "edgelist1.txt";
    String e2 = PATH + "edgelist2.txt";
    String eRand = PATH + "randomList.txt";

    String idSet = PATH + "indyDomSet.txt";
    String idSetList = PATH + "mindomsetlist.txt"; // listFormat = true
    String sixClass = PATH + "minimalDomSet.txt";
    String bigChart = PATH + "maxIrr.txt"; // listFormat = true
    String ioir = PATH + "ioir.txt";

    @BeforeEach
    void setUp()
    {
    }

    @Test
    void run()
    {
        slv = new Solver(e2, ioir, false);
        slv.run(false);
        slv.printSet();

    }

    @Test
    void runNp()
    {
        slv = new Solver(e2, PATH + "oneMaxNearlyPerfect.txt", false);
        slv.run(false);
    }

    @Test
    void runLots()
    {
        for (int i = 0; i < 200; i++)
        {
            slv = new Solver(eRand, ioir, false);
            slv.runRoot(false, i);
        }
    }
    
}