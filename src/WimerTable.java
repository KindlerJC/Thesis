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
    private int validClasses;
    private LinkedList<Composition>[] table;

    public WimerTable(String fileName)
    {
        Scanner input = getScanner(fileName);
        String max = input.nextLine(); //First line determines max or min
        isMax = max.toLowerCase().contains("max");

        int classes = input.nextInt(); // Second line has number of classes
        input.nextLine();
        validClasses = input.nextInt(); // Third line has number of valid classes
        input.nextLine();
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
                if (compCase != BAD_CASE) {
                    var row = table[compCase];
                    var comp = new Composition(compCase, i, j);
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
        var newList = new VectorEntry[parentList.length];
        Iterator<Composition> iter;
        int bestTotal, parentSize, childSize, totalSize = 0;
        Composition into;
        Composition bestComp = null;
        int parentCase, childCase;

        for (int i = 0; i < parentList.length; i++) // i = case #, index in vectorList
        {
            iter = table[i].iterator();
            bestTotal = isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (iter.hasNext()) // Iterate through list of possible compositions
            {
                into = iter.next();

                parentCase = into.getParent();
                childCase = into.getChild();

                parentSize = parentList[parentCase].getSize();
                childSize = childList[childCase].getSize();

                if (parentSize == BAD_CASE || childSize == BAD_CASE)
                    continue;

                totalSize = parentSize + childSize;

                if ((isMax && totalSize > bestTotal) || (!isMax && totalSize < bestTotal))
                {
                    bestComp = into;
                    bestTotal = totalSize;
                }

            }

            bestTotal = bestTotal == Integer.MAX_VALUE || bestTotal == Integer.MIN_VALUE ? -1 : bestTotal;
            newList[i] = new VectorEntry(bestTotal, bestComp, parentList[i]);

        }
        return new Vector(newList, parent, child);
    }

    public Iterator<Composition> getIterator(int index)
    {
        return table[index].iterator();
    }

    public boolean isMax()
    {
        return isMax;
    }

    public int getValidClasses()
    {
        return validClasses;
    }

}
