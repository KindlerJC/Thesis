
public class Main
{
    private static Vector[] tree;
    public static void main(String[] args)
    {
        var yeet = run(args);

    }

    public static VectorEntry run(String[] args)
    {
        int root = 0;

        var adjList = new AdjacencyList(args[0]);
        var wimerTable = new WimerTable(args[1]);
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

        var result = tree[root].getBest(wimerTable.isMax(), wimerTable.getValidClasses());
        return result;
    }

}
