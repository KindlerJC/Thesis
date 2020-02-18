public class Vector
{
    private VectorEntry[] list;
    private Vector left;
    private Vector right;

    public Vector(int size)
    {
        list = new VectorEntry[size];
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
