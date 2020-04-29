import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @BeforeEach
    void setUp()
    {
    }

    @Test
    void run()
    {
        slv = new Solver(e1, idSet, false);
        slv.run(false);
    }

    @Test
    void runRoot()
    {
    }

    @Test
    void getFinalVector()
    {
    }

    @Test
    void findSet()
    {
    }
}