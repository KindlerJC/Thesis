public class Main
{
    private static Vector[] tree;
    public static AdjacencyList adjList;
    public static WimerTable wimerTable;

    static boolean isMax;
    static int validClasses;
    static Vector initialVector;

    public static void main(String[] args)
    {
        initFields(args);
        var finalVector = getFinalVector(0);
        var bestEntry = finalVector.getBest(isMax, validClasses);
        System.out.println("Set size: " + bestEntry.getSize());
        printRec(finalVector, bestEntry.getComp().getCase());


    }

    public static void initFields(String[] args)
    {
        adjList = new AdjacencyList(args[0]);
        wimerTable = new WimerTable(args[1]);
        isMax = wimerTable.isMax();
        validClasses = wimerTable.getValidClasses();
        initialVector = wimerTable.getInitialVector();
    }

    public static Vector getFinalVector(int root)
    {
        Vector initialVector = wimerTable.getInitialVector();
        tree = new Vector[adjList.getSize()];
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
