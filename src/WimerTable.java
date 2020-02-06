import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class WimerTable
{
    public static final int BAD_CASE = -1;

    private boolean isMax;
    private ArrayList<LinkedList<Integer>> table;

    public WimerTable(File inFile)
    {

    }

    public Vector compose(Vector parent, Vector child)
    {

    }

    public void populate(File inFile)
    {
        Scanner input = new Scanner(infile);
        int classes = input.nextInt();
        table = new ArrayList<>(classes);

        for (int i = 0; i < classes; i++)
            table.add(new LinkedList<>());

        for (int i = 0; i < classes; i++)
        {
            for (int k = 0; k < classes; k++)
            {
                int resultCase = input.nextInt();

            }
        }
    }
}
