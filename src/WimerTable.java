import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class WimerTable
{
    public static final int BAD_CASE = -1;

    private boolean isMax;
    private ArrayList<LinkedList<Composition>> table;

    public WimerTable(File inFile)
    {
        Scanner input = null;
        try {
            input = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        String max = input.nextLine(); //First line determines max or min
        isMax = max.toLowerCase().contains("max");
        int classes = input.nextInt();
        table = new ArrayList<>(classes);

        for (int i = 0; i < classes; i++)
            table.add(new LinkedList<>());

        for (int i = 0; i < classes; i++) //rows of table, parent case
        {
            for (int j = 0; j < classes; j++) //columns of table, child case
            {
                int compCase = input.nextInt();
                var row = table.get(compCase);
                var comp = new Composition(i, j);
                row.add(comp);
            }
        }
    }

    public Vector compose(Vector parent, Vector child)
    {
        for (var caseList : table)
        {

        }
        return null;
    }

}
