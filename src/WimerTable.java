import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class WimerTable
{
    //TODO: Have input provide acceptable end cases
    public static final int BAD_CASE = -1;
    private Vector initialVector;

    private boolean isMax;
    private LinkedList<Composition>[] table;

    public WimerTable(String fileName)
    {
        Scanner input = getScanner(fileName);
        String max = input.nextLine(); //First line determines max or min
        isMax = max.toLowerCase().contains("max");

        int classes = input.nextInt();
        var vectArr = new int[classes];
        for (int i = 0; i < classes; i++)
        {
            vectArr[i] = input.nextInt();
        }
        initialVector = new Vector(vectArr);
        table = new LinkedList[classes];
        for (int i = 0; i < classes; i++)
            table[i] = new LinkedList<>();

        for (int i = 0; i < classes; i++) //rows of table, parent case
        {
            for (int j = 0; j < classes; j++) //columns of table, child case
            {
                int compCase = input.nextInt();
                if (compCase != -1) {
                    var row = table[compCase];
                    var comp = new Composition(i, j);
                    row.add(comp);
                }
            }
        }

        input.close();
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
        var parentList = parent.getList();
        var childList = child.getList();
        Iterator<Composition> iter;
        int caseA, caseB;
        Composition into;

        for (int i = 0; i < parentList.length; i++)
        {
            iter = table[i].iterator();
            caseA = parentList[i].getSize();
            caseB = childList[i].getSize();
            while (iter.hasNext())
            {
                into = iter.next();
                if (into.equals(caseA, caseB))
                {
//                    int caseSize =
//                    if(into.g)
                }


            }
        }
        return null;
    }

    public Iterator<Composition> getIterator(int index)
    {
        return table[index].iterator();
    }

}
