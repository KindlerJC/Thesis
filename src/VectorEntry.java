public class VectorEntry
{
    public static final int BAD_CASE = -1;

    private int size;
    private Composition entry;
    private Composition prev;

    public VectorEntry(int size, Composition entry, Composition prev)
    {
        this.size = size;
        this.entry = entry;
        this.prev = prev;
    }

    public int getSize()
    {
        return size;
    }


}
