import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    void run()
    {
        String[] files = new String[] {"tests/edgelist1", "tests/mindomset.txt"};

        for (int i = 0; i < 7; i++)
        {
            var actual = Main.run(files, i);
            assertEquals(2, actual.getSize());
        }


    }

}