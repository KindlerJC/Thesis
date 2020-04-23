public class Main
{
    private static Vector[] tree;
    public static AdjacencyList adjList;
    public static WimerTable wimerTable;

    static Vector initialVector;

    public static void main(String[] args)
    {

    }

    public static void run(String[] args, boolean listFormat)
    {
        initFields(args, listFormat);
        var finalVector = getFinalVector(0);
        var bestEntry = listFormat? wimerTable.getBestEntryList(finalVector) : wimerTable.getBestEntry(finalVector);
        System.out.println("Set size: " + bestEntry.getSize());
        printRec(finalVector, bestEntry.getComp().getCase());
    }

    public static void runRandomRoot(String[] args, boolean listFormat)
    {
        initFields(args, listFormat);
        int root = (int) (Math.random() * adjList.getSize());
        System.out.println("Randomly selected root: " + root);
        var finalVector = getFinalVector(root);
        var bestEntry = listFormat? wimerTable.getBestEntryList(finalVector) : wimerTable.getBestEntry(finalVector);
        System.out.println("Set size: " + bestEntry.getSize());
        printRec(finalVector, bestEntry.getComp().getCase());
    }

    public static void runAllRoots(String[] args, boolean listFormat)
    {
        initFields(args, listFormat);
        Vector finalVector;
        VectorEntry bestEntry;

        finalVector = getFinalVector(0);
        bestEntry = wimerTable.getBestEntry(finalVector);
        int currentSize, rightSize = bestEntry.getSize();
        int iter = adjList.getSize();
        System.out.printf("Set size when root = 0 : %d\n", rightSize);
        for (int i = 1; i < iter; i++)
        {
            initFields(args, listFormat);
            finalVector = getFinalVector(i);
            currentSize = listFormat? wimerTable.getBestEntryList(finalVector).getSize() : wimerTable.getBestEntry(finalVector).getSize();
            if (currentSize != rightSize)
            {
                System.out.printf("Expected size of %d but got %d when root was %d\n", rightSize, currentSize, i);
                System.exit(-1);
            }

        }
        System.out.println("Congratulations! Result set is the same size regardless of root position.");

    }
    public static void initFields(String[] args, boolean isList)
    {
        adjList = new AdjacencyList(args[0]);
        wimerTable = new WimerTable(args[1], isList);
        initialVector = wimerTable.getInitialVector();
        tree = new Vector[adjList.getSize()];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Vector(initialVector, i);
    }

    public static Vector getFinalVector(int root)
    {
        var parents = adjList.getParentArray(root);
        var order = adjList.getTraversalOrder(root);

        Vector a, b;
        int parent, current;

        for (int i = 0; i < order.length - 1; i++)
        {
            current = order[i];
            parent = parents[current];
            a = tree[parent];
            b = tree[current];
            tree[parent] = wimerTable.compose(a, b);
            tree[parent].position = parent;
        }

        return tree[root];
    }

    static void printRec(Vector ptr, int comp)
    {
        var currentComp = ptr.entryAt(comp);
        if (ptr.getLeft() == null)  // If the vector has no left component it has no right component either
        {
            var size = initialVector.entryAt(comp).getSize();
            if (size == 1)
                System.out.println(ptr.position + " is in the set");
            return;
        }

        printRec(ptr.getLeft(), currentComp.getParentCase());
        printRec(ptr.getRight(), currentComp.getChildCase());
    }

}
