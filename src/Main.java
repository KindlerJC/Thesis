public class Main
{
    private static Vector[] tree;
    private static AdjacencyList adjList;
    private static WimerTable wimerTable;
    public static void main(String[] args)
    {
        var yeet = getFinalVector(args, 0);


    }

    public static Vector getFinalVector(String[] args, int root)
    {
        adjList = new AdjacencyList(args[0]);
        wimerTable = new WimerTable(args[1]);
        Vector initialVector = wimerTable.getInitialVector();
        tree = new Vector[adjList.getSize()]; // TODO: Add case label to each VectorEntry
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Vector(initialVector);

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
        }

        var result = tree[root];
        return result;
    }

    public static void printSet()
    {
            
    }

}
