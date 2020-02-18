import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjacencyList
{
    private ArrayList<LinkedList<Integer>> adjList;
    private int size;

    /**
     * Creates an AdjacencyList from the file input.
     * File format: First integer is the number of nodes in the tree
     * Following the size, there should be pairs of integers to indicate edges.
     * All numbers should be separated with whitespace.
     * Tree will be zero-indexed, so the max node value is size - 1.
     *
     * @param fileName
     * @return
     */
    public AdjacencyList(String fileName)
    {
        Scanner edgeFile = getScanner(fileName);
        size = edgeFile.nextInt();
        adjList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjList.add(i, new LinkedList<>());
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
        adjList.get(a).addFirst(b);
        adjList.get(b).addFirst(a);
    }

    public Iterator<Integer> getIterator(int index)
    {
        return adjList.get(index).iterator();
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
        do {
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
        while (!queue.isEmpty());

        return parents;
    }
}
