import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class WimerTable
{
    public static final int BAD_CASE = -1;
    private Vector initialVector;

    private boolean isMax;
    private ArrayList<LinkedList<Composition>> table;

    public WimerTable(String fileName)
    {
        Scanner input = getScanner(fileName);
        String max = input.nextLine(); //First line determines max or min
        isMax = max.toLowerCase().contains("max");

        int classes = input.nextInt();
        initialVector = new Vector(classes);

        for (int i = 0; i < classes; i++)
        {
            int size = input.nextInt();
            initialVector.list[i] = new VectorEntry(size);
        }
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

    private Scanner getScanner(String fileName)
    {
        Scanner input = null;
        File inFile = new File(fileName);
        try {
            input = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return input;
    }

    public Vector getInitialVector()
    {
        return initialVector;
    }

    public Vector compose(Vector parent, Vector child)
    {
        for (var caseList : table)
        {
            
        }
        return null;
    }

}
