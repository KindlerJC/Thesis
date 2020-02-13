import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String fileName;
        Scanner keyboard = new Scanner(System.in);
        if (args.length == 0)
        {
            System.out.print("Enter name of edge list file: ");
            fileName = keyboard.nextLine();
        }
        else {
            fileName = args[0];
        }
        keyboard.close();
        AdjacencyList adjList = makeAdjacencyList(fileName);
    }

    /**
     * Creates an AdjacencyList from the file input.
     * File format: First integer is the number of nodes in the tree.
     * Following the size, there should be pairs of integers to indicate edges.
     * All numbers should be separated with whitespace.
     * Tree will be zero-indexed, so the max node value is size - 1.
     * @param fileName
     * @return
     */
    private static AdjacencyList makeAdjacencyList(String fileName)
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

        int size = edgeFile.nextInt();
        int a, b;
        AdjacencyList adjList = new AdjacencyList(size);

        while(edgeFile.hasNextInt())
        {
            a = edgeFile.nextInt();
            b = edgeFile.nextInt();
            adjList.add(a, b);
        }

        edgeFile.close();
        return adjList;
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

    private static int[] mpa(int[] parents, int current)
    {
        return null;
    }


}
