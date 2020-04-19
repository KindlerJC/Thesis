import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class WimerTable
{
    public static final int BAD_CASE = -1;
    private Vector initialVector;

    private boolean isMax;
    protected int classes;
    private int validClasses;
    private LinkedList<Composition>[] table;

    /**
     * Constructs the Wimer table. Calls loadFromFile to parse text in the filename file.
     *
     * @param fileName Name of text file that contains the table.
     */

    public WimerTable(String fileName)
    {
        loadFromFile(fileName);
    }

    /**
     * Processes the file to generate the algorithm table.
     *
     * @param fileName Name of file that outlines the algorithm.
     */

    protected void loadFromFile(String fileName)
    {
        Scanner input = getScanner(fileName);
        String max = input.next(); //First line determines max or min
        isMax = max.toLowerCase().contains("max");
        input.nextLine();

        classes = input.nextInt(); // Second line has number of classes
        input.nextLine();
        validClasses = input.nextInt();
        input.nextLine();
        var vectArr = new int[classes];
        for (int i = 0; i < classes; i++) {
            vectArr[i] = input.nextInt();
        }
        input.nextLine();

        initialVector = new Vector(vectArr);
        table = new LinkedList[classes];
        for (int i = 0; i < classes; i++)
            table[i] = new LinkedList<>();

        LinkedList<Composition> row;
        Composition comp;
        int compCase;

        for (int i = 0; i < classes; i++) //rows of table, parent case
        {
            for (int j = 0; j < classes; j++) //columns of table, child case
            {
                compCase = input.nextInt();
                if (compCase != BAD_CASE)
                {
                    row = table[compCase];
                    comp = new Composition(compCase, i, j);
                    row.add(comp);
                }
            }
            if (input.hasNextLine())
                 input.nextLine();
        }
        input.close();
    }

    /**
     * Attempts to get a Scanner to read the text file outlining the tabular algorithm.
     *
     * @param fileName Name of text file with the algorithm.
     * @return Scanner to read the text file with the algorithm table.
     */

    private Scanner getScanner(String fileName)
    {
        Scanner input = null;
        File inFile = new File(fileName);
        try
        {
            input = new Scanner(inFile);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
        return input;
    }

    /**
     * Accessor for the initial vector, which is specified in the input file.
     *
     * @return the initial vector.
     */

    public Vector getInitialVector()
    {
        return initialVector;
    }

    /**
     * Composes two vectors and returns the result.
     * Uses Wimer's method with the table to determine results.
     * The returned vector keeps references to its parent and child vectors, used to determine the final set.
     *
     * @param parent The parent to be composed
     * @param child The child to be composed
     * @return The composition of the parent with the child, which replaces the parent in the tree.
     */

    public Vector compose(Vector parent, Vector child)
    {

        var parentList = parent.getList();
        var childList = child.getList();
        var newList = new VectorEntry[parentList.length];

        int bestTotal, parentSize, childSize, totalSize = 0;
        int parentCase, childCase;
        Iterator<Composition> iter;
        Composition into, bestComp = null;

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

            bestTotal = bestTotal == Integer.MAX_VALUE || bestTotal == Integer.MIN_VALUE ? BAD_CASE : bestTotal;
            newList[i] = new VectorEntry(bestTotal, bestComp);

        }
        return new Vector(newList, parent, child);
    }

    /**
     * Whether the algorithm should seek the largest or smallest possible final set.
     *
     * @return True if largest, false if smallest.
     */
    public boolean isMax()
    {
        return isMax;
    }

    /**
     * Get number of valid classes for the final root vector
     *
     * i.e. If there are 5 classes and 2 valid classes, 0 and 1 are valid, while 2-4 are not.
     *
     * @return Number of valid final classes
     */
    public int getValidClasses()
    {
        return validClasses;
    }

}
