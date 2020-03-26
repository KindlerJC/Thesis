public class VectorEntry
{
    public static final int BAD_CASE = -1;

    private int size;
    private Composition entry;

    public VectorEntry(int size)
    {
        this.size = size;
    }

    public VectorEntry(int size, Composition entry)
    {
        this.size = size;
        this.entry = entry;
    }

    public int getSize()
    {
        return size;
    }

    public Composition getComp()
    {
        return entry;
    }

    public int getCompCase() {
        return entry.getCase();
    }

    @Override
    public String toString()
    {
        return "" + size;
    }


}
