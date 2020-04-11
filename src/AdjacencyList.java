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
        loadFromFile(fileName);
    }

    /**
     * Used for Testing AdjacencyLists built manually, rather than from files.
     * @param size Length of array of Linkedlists.
     */
    public AdjacencyList(int size)
    {
        this.size = size;
        adjList = new LinkedList[size];
        for (int i = 0; i < size; i++)
            adjList[i] = new LinkedList<>();
    }

    /**
     * Loads the adjacency list from the edgelist file
     *
     * @param fileName Name of the text file containing the edge list.
     */
    private void loadFromFile(String fileName)
    {
        Scanner edgeFile = getScanner(fileName);
        size = edgeFile.nextInt();
        adjList = new LinkedList[size];

        for (int i = 0; i < size; i++)
            adjList[i] = new LinkedList<>();

        int a, b;
        while (edgeFile.hasNextInt())
        {
            a = edgeFile.nextInt();
            b = edgeFile.nextInt();
            add(a, b);
        }
        edgeFile.close();
    }

    /**
     * Attempts to get a Scanner to read the edgelist text file
     *
     * @param fileName Name of text file with edge list
     * @return Scanner for reading edgelist file
     */
    private Scanner getScanner(String fileName)
    {
        File inFile = new File(fileName);
        Scanner edgeFile = null;

        try {
            edgeFile = new Scanner(inFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return edgeFile;
    }

    /**
     * Adds an edge to the AdjacencyList
     *
     * @param a Starting vertex of given edge
     * @param b Destination vertex of given edge
     */

    public void add(int a, int b)
    {
        adjList[a].addFirst(b);
        adjList[b].addFirst(a);
    }

    /**
     * Gets an iterator through list of all vertices adjacent to index
     *
     * @param index Vertex that adjacency list pertains to
     * @return Iterator through all vertices adjacent to vertex at index
     */

    public Iterator<Integer> getIterator(int index)
    {
        return adjList[index].iterator();
    }

    /**
     * Gets the size of the graph
     *
     * @return Length of adjlist[] array, which equals the number of vertices in corresponding graph
     */

    public int getSize()
    {
        return size;
    }

    /**
     * Represents the graph with int[] array of each vertex's parent
     *
     * i.e. For parent array parents[], and vertex i, parents[i] contains vertex number of i's parent
     * Because the root has no parent, the root's parent is set to -1
     *
     * @param root The (arbitrarily chosen) root of the tree
     * @return Parent array representation of the graph
     */

    public int[] getParentArray(int root)
    {
        int[] parents = new int[size];
        var queue = new LinkedList<Integer>();
        var visited = new boolean[size];

        visited[root] = true;
        parents[root] = -1;
        queue.add(root);

        int parent, child;
        Iterator<Integer> iter;

        while (!queue.isEmpty())
        {
            parent = queue.pollFirst();
            iter = getIterator(parent);
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
     * Determines the order of compositions.
     * In the main method, this array is traversed in order.
     *
     * i.e. If order[0] is 4, then the first composition is 4's parent with 4
     * 
     * @param root Vertex to use as the root of the tree
     * @return Order of compositions
     */
    public int[] getTraversalOrder(int root)
    {
        var queue = new LinkedList<Integer>();
        var visited = new boolean[size];
        var order = new int[size];
        int i = size - 1;

        queue.add(root);
        visited[root] = true;
        order[i--] = root;

        int current;
        Iterator<Integer> iter;

        while (!queue.isEmpty())
        {
            current = queue.pollFirst();
            iter = getIterator(current);
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
