import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AdjacencyList
{
    private ArrayList<LinkedList<Integer>> adjList;

    public AdjacencyList(int size)
    {
        adjList  = new ArrayList<LinkedList<Integer>>(size);
    }

    public void add(int a, int b)
    {
        adjList.get(a).addFirst(b);
        adjList.get(b).addFirst(a);
    }

    public Iterator<Integer> getIterator(int index)
    {
        return adjList.get(index).iterator();
    }

}
