import java.util.Arrays;

public class Vector
{
    public static final int BAD_COMP = -1;

    private VectorEntry[] list;
    private Vector left;
    private Vector right;
    public int position;

    public Vector(VectorEntry[] list, Vector left, Vector right)
    {
        this.list = list;
        this.left = left;
        this.right = right;
    }

    public Vector(Vector initial, int position)
    {
        list = initial.list.clone();
        this.position = position;
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

    public Vector getLeft() {
        return left;
    }

    public Vector getRight() {
        return right;
    }

    public VectorEntry entryAt(int index)
    {
        return list[index];
    }

    @Override
    public String toString()
    {
        return position + ": " + Arrays.toString(list);
    }


}
