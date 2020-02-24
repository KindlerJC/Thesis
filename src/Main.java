public class Main
{
    private static Vector[] tree;
    public static void main(String[] args)
    {
        var adjList = new AdjacencyList(args[0]);
        var wimerTable = new WimerTable(args[1]);
        Vector initialVector = wimerTable.getInitialVector();
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Vector(initialVector);

        var parentArray = adjList.getParentArray(0);
        for (int i = parentArray.length - 1; i >= 0; i--)
        {

        }

    }

}
