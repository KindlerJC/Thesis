import java.io.File;
import java.io.FileNotFoundException;
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
}
