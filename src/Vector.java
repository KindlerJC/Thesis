public class Vector
{
    private VectorEntry[] list;
    private Vector left;
    private Vector right;
    private int label; //TODO Fully implement

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

}
