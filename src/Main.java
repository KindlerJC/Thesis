import java.util.HashSet;
import java.util.LinkedList;

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




    private static int[] makeParentArray(AdjacencyList adjList, int root)
    {
        int[] parents = new int[adjList.getSize()];
        parents[root] = -1;
        var queue = new LinkedList<Integer>();
        var visited = new HashSet<Integer>();

        queue.add(root);
        do {
            int parent = queue.getFirst();
            var iter = adjList.getIterator(parent);
            while (iter.hasNext())
            {
                int child = iter.next();
                if (visited.contains(child))
                    continue;
                visited.add(child);
                parents[child] = parent;
                queue.addLast(child);
            }
        } while (!queue.isEmpty());

        return parents;
    }


}
