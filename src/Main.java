public class Main
{
    public static void main(String[] args)
    {
        if (args.length == 0)
            usage();
        String edgeFile = "", tableFile = "";
        boolean listFormat = false;
        boolean random = false;
        int root = 0;
        int i = 0;
        while (i < args.length)
        {
            switch(args[i])
            {
                case "-e":
                    edgeFile = args[++i];
                    break;
                case "-t":
                    tableFile = args[++i];
                    break;
                case "-list":
                    listFormat = true;
                    break;
                case "-root":
                    i++;
                    if (args[i].equals("random"))
                        random = true;
                    else
                        root = Integer.parseInt(args[i]);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + args[i]);
            }
            i++;
        }

        Solver slv = new Solver(edgeFile, tableFile, listFormat);
        if (random)
            root = (int)(Math.random() * slv.adjList.getSize());
        slv.runRoot(listFormat, root);
        slv.printSet();

    }

    public static void usage()
    {
        System.out.println("Usage: java Main -e <edgefile> -t <tablefile>");
        System.out.println("Optional: -list used if valid classes are in list format");
        System.out.println("Optional: -root <root> Where root is an integer, or 'random.'");
        System.exit(-1);
    }

}
