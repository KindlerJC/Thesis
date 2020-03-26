public class Main
{
    private static Vector[] tree;
    public static AdjacencyList adjList;
    public static WimerTable wimerTable;

    static boolean isMax;
    static int validClasses;

    public static void main(String[] args)
    {
        makeTables(args);
        isMax = wimerTable.isMax();
        validClasses = wimerTable.getValidClasses();
        var finalVector = getFinalVector(0);



    }

    public static void makeTables(String[] args)
    {
        adjList = new AdjacencyList(args[0]);
        wimerTable = new WimerTable(args[1]);
    }

    public static Vector getFinalVector(int root)
    {
        Vector initialVector = wimerTable.getInitialVector();
        tree = new Vector[adjList.getSize()]; // TODO: Add case label to each VectorEntry
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Vector(initialVector, i);

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

        var result = tree[root];
        return result;
    }

    public static void printSet(Vector initialVector, Vector finalVector)
    {
        var inVec = initialVector.getList();
        VectorEntry best = finalVector.getBest(isMax, validClasses);
        int currentCase = best.getCompCase();
        if (inVec[currentCase].getSize() == 1)
        {
            System.out.println();
        }


    }

}
