import org.junit.jupiter.api.Test;

class MainTest
{
    String path = "tests/text/";
    @Test
    void run()
    {
        String[] files = new String[]{path + "edgelist1", path + "mindomset.txt"};

        Main.runRandomRoot(files, false);
    }

    @Test
    void sandbox()
    {
        String[] files = new String[]{path + "randomList.txt", path + "mindomset.txt"};
        Main.runAllRoots(files, false);
    }

    @Test
    void openIrredundant()
    {
        String[] files = new String[]{path + "edgelist1", path + "minOpenIrr.txt"};

        Main.run(files, true);
    }

}