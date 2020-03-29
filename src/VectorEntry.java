public class VectorEntry
{
    public static final int BAD_CASE = -1;

    private int size;
    private Composition composition;

    public VectorEntry(int size)
    {
        this.size = size;
    }

    public VectorEntry(int size, Composition entry)
    {
        this.size = size;
        this.composition = entry;
    }

    public int getSize()
    {
        return size;
    }

    public Composition getComp()
    {
        return composition;
    }

    public int getParentCase() {
        return composition.getParent();
    }

    public int getChildCase() {
        return composition.getChild();
    }

    public int getCompCase() {
        return composition.getCase();
    }

    @Override
    public String toString()
    {
        return "" + size;
    }


}
