public class Solver
{
    private Vector[] tree;
    private boolean[] finalSet;
    public AdjacencyList adjList;
    public WimerTable wimerTable;

    private Vector initialVector;

    public Solver(String edgeFile, String tableFile, boolean isList)
    {
        adjList = new AdjacencyList(edgeFile);
        wimerTable = new WimerTable(tableFile, isList);
        initialVector = wimerTable.getInitialVector();
        tree = new Vector[adjList.getSize()];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Vector(initialVector, i);
        finalSet = new boolean[adjList.getSize()];
    }

    public void run(boolean listFormat)
    {
        runRoot(listFormat, 0);
    }

    public void runRoot(boolean listFormat, int root)
    {
        var finalVector = getFinalVector(root);
        var bestEntry = listFormat ? wimerTable.getBestEntryList(finalVector) : wimerTable.getBestEntry(finalVector);
        int setSize = bestEntry.getSize();
        System.out.println("Root: " + root);
        if (setSize == -1)
        {
            System.out.println("No valid set returned.");
            return;
        }
        System.out.println("Set size: " + bestEntry.getSize());
        findSet(finalVector, bestEntry.getComp().getCase());
        printSet();
    }

    private void printSet()
    {
        for (int i = 0; i < finalSet.length; i++)
            if (finalSet[i])
                System.out.printf("%d is in the set\n", i);
    }

    public Vector getFinalVector(int root)
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

    void findSet(Vector ptr, int comp)
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

