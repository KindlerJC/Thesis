public class Vector
{
    public VectorEntry[] list;
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

}
