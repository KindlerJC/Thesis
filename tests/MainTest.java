import org.junit.jupiter.api.Test;

class MainTest
{
    String path = "tests/text/";
    @Test
    void run()
{
    String[] files = new String[]{path + "edgelist1.txt", path + "indyDomSet.txt"};

    Main.run(files, false);
}

    @Test
    void runimal()
    {
        String[] files = new String[]{path + "edgelist1.txt", path + "minimalDomSet.txt"};

        Main.runRandomRoot(files, false);
    }

    @Test
    void sandbox()
    {
        String[] files = new String[]{path + "edgelist1.txt", path + "minPairVertexCover.txt"};
        Main.runRandomRoot(files, false);
    }

    @Test
    void openIrredundant()
    {
        String[] files = new String[]{path + "edgelist2.txt", path + "maxIrr.txt"};

        for (int i = 0; i < 15; i++)
            Main.runRoot(files, true, i);
    }

}