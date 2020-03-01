import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;

public class AdjacencyList
{
    private int size;
    private LinkedList<Integer>[] adjList;

    /**
     * Creates an AdjacencyList from the file input.
     * File format: First integer is the number of nodes in the tree
     * Following the size, there should be pairs of integers to indicate edges.
     * All numbers should be separated with whitespace.
     * Tree will be zero-indexed, so the max node value is size - 1.
     *
     * @param fileName Name of file with edgelist
     */
    public AdjacencyList(String fileName)
    {
        Scanner edgeFile = getScanner(fileName);
        size = edgeFile.nextInt();
        adjList = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }

        int a, b;
        while (edgeFile.hasNextInt())
        {
            a = edgeFile.nextInt();
            b = edgeFile.nextInt();
            add(a, b);
        }

        edgeFile.close();

    }

    public AdjacencyList(int size)
    {
        this.size = size;
        adjList = new LinkedList[size];
        for (int i = 0; i < size; i++)
            adjList[i] = new LinkedList<>();
    }

    private Scanner getScanner(String fileName)
    {
        File inFile = new File(fileName);
        Scanner edgeFile = null;

        try {
            edgeFile = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return edgeFile;
    }

    public void add(int a, int b)
    {
        adjList[a].addFirst(b);
        adjList[b].addFirst(a);
    }

    public Iterator<Integer> getIterator(int index)
    {
        return adjList[index].iterator();
    }

    public int getSize()
    {
        return size;
    }

    public int[] getParentArray(int root)
    {
        int[] parents = new int[size];
        var queue = new LinkedList<Integer>();
        var visited = new boolean[size];

        visited[root] = true;
        parents[root] = -1;
        queue.add(root);

        int parent, child;
        while (!queue.isEmpty())
        {
            parent = queue.pollFirst();
            var iter = getIterator(parent);
            while (iter.hasNext())
            {
                child = iter.next();
                if (!visited[child])
                {
                    visited[child] = true;
                    parents[child] = parent;
                    queue.addLast(child);
                }
            }
        }

        return parents;
    }

    /**
     * 
     * @param root
     * @return
     */
    public int[] getTraversalOrder(int root)
    {
        var queue = new LinkedList<Integer>();
        var visited = new boolean[size];
        var order = new int[size];

        queue.add(root);
        visited[root] = true;
        int i = size - 1;
        order[i--] = root;
        int current;

        while (!queue.isEmpty())
        {
            current = queue.pollFirst();
            var iter = getIterator(current);
            while (iter.hasNext())
            {
                current = iter.next();
                if (!visited[current])
                {
                    visited[current] = true;
                    order[i--] = current;
                    queue.addLast(current);
                }

            }
        }
        return order;
    }
}
