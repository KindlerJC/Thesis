import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    void run()
    {
        String[] files = new String[] {"tests/edgelist1", "tests/mindomset.txt"};
        var actual = Main.run(files);
        System.out.println(actual.getSize());
        System.out.println(actual.);

    }

}