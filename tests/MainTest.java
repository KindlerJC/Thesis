import org.junit.jupiter.api.Test;

class MainTest
{
    @Test
    void run()
    {
        String[] files = new String[] {"tests/edgelist1", "tests/mindomset.txt"};
        var actual = Main.run(files);
        System.out.println(actual.getSize());

    }

}