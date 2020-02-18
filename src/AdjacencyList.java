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
     * @param fileName
     * @return
     */
    public AdjacencyList(String fileName)
    {
        File inFile = new File(fileName);
        Scanner edgeFile = null;

        try
        {
            edgeFile = new Scanner(inFile);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }

        size = edgeFile.nextInt();
        adjList  = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
        {
            adjList.add(i, new LinkedList<>());
        }

        int a, b;
        while(edgeFile.hasNextInt())
        {
            a = edgeFile.nextInt();
            b = edgeFile.nextInt();
            add(a, b);
        }

        edgeFile.close();

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
}
