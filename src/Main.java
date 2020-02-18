public class Main
{
    private static Vector[] tree;
    public static void main(String[] args)
    {
        var adjList = new AdjacencyList(args[0]);
        var wimerTable = new WimerTable(args[1]);
        var initialVector = wimerTable.initialVector;
        tree = new Vector[initialVector.list.length];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Vector(initialVector);
    }

}
