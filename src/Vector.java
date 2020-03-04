public class Vector
{
    public static final int BAD_COMP = -1;

    private VectorEntry[] list;
    private Vector left;
    private Vector right;
    private int label; //TODO Fully implement
    private static int[] initial;

    public Vector(Vector left, Vector right)
    {
        this.left = left;
        this.right = right;
    }

    public Vector(VectorEntry[] list, Vector left, Vector right)
    {
        this.list = list;
        this.left = left;
        this.right = right;
    }

    public Vector(Vector initial)
    {
        list = initial.list.clone();
    }

    public Vector(int[] initialVector)
    {
        int size = initialVector.length;

        list = new VectorEntry[size];
        for (int i = 0; i < size; i++)
            list[i] = new VectorEntry(initialVector[i]);

    }

    public VectorEntry[] getList()
    {
        return list;
    }

    public VectorEntry getBest(WimerTable algorithm)
    {
        boolean isMax = algorithm.isMax();
        int validClasses = algorithm.getValidClasses();
        VectorEntry current, best = null;
        int bestSize = isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentSize;
        for (int i = 0; i < validClasses; i++)
        {
            current = list[i];
            currentSize = current.getSize();
            if (best == null || ((isMax && currentSize > bestSize) || (!isMax && currentSize < bestSize) && currentSize != BAD_COMP))
            {
                best = current;
                bestSize = currentSize;
            }
        }

        return best;
    }



}
