public class Main
{
    private static Vector[] tree;
    private static boolean[] finalSet;
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
        findSet(finalVector, bestEntry.getComp().getCase());
        for (int i = 0; i < finalSet.length; i++)
            if (finalSet[i])
                System.out.printf("%d is in the set\n", i);
    }

    public static void runRandomRoot(String[] args, boolean listFormat)
    {
        initFields(args, listFormat);
        int root = (int) (Math.random() * adjList.getSize());
        System.out.println("Randomly selected root: " + root);
        var finalVector = getFinalVector(root);
        var bestEntry = listFormat? wimerTable.getBestEntryList(finalVector) : wimerTable.getBestEntry(finalVector);
        System.out.println("Set size: " + bestEntry.getSize());
        findSet(finalVector, bestEntry.getComp().getCase());
        for (int i = 0; i < finalSet.length; i++)
            if (finalSet[i])
                System.out.printf("%d is in the set\n", i);
    }

    public static void runRoot(String[] args, boolean listFormat, int root)
    {
        System.out.println("Root: " + root);
        initFields(args, listFormat);
        var finalVector = getFinalVector(root);
        var bestEntry = listFormat ? wimerTable.getBestEntryList(finalVector) : wimerTable.getBestEntry(finalVector);
        System.out.println("Set size: " + bestEntry.getSize());
        findSet(finalVector, bestEntry.getComp().getCase());
        for (int i = 0; i < finalSet.length; i++)
            if (finalSet[i])
                System.out.printf("%d is in the set\n", i);
    }


    public static void initFields(String[] args, boolean isList)
    {
        adjList = new AdjacencyList(args[0]);
        wimerTable = new WimerTable(args[1], isList);
        initialVector = wimerTable.getInitialVector();
        tree = new Vector[adjList.getSize()];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Vector(initialVector, i);
        finalSet = new boolean[adjList.getSize()];
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

    static void findSet(Vector ptr, int comp)
    {
        var currentComp = ptr.entryAt(comp);
        if (ptr.getLeft() == null)  // If the vector has no left component it has no right component either
        {
            var size = initialVector.entryAt(comp).getSize();
            if (size == 1)
                finalSet[ptr.position] = true;
            return;
        }

        findSet(ptr.getLeft(), currentComp.getParentCase());
        findSet(ptr.getRight(), currentComp.getChildCase());
    }

}
