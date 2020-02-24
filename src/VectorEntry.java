public class VectorEntry
{
    public static final int BAD_CASE = -1;

    private int size;
    private Composition entry;
    private VectorEntry prev;

    public VectorEntry(int size)
    {
        this.size = size;
    }

    public VectorEntry(int size, Composition entry, VectorEntry other)
    {
        this.size = size;
        this.entry = entry;
        prev = other.prev;
    }

    public int getSize()
    {
        return size;
    }

    public Composition getComp()
    {
        return entry;
    }


}
