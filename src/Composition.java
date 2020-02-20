public class Composition
{
    private int parent;
    private int child;

    public Composition(int parent, int child)
    {
        this.parent = parent;
        this.child = child;
    }

    public Composition(Composition original)
    {
        parent = original.parent;
        child = original.child;
    }

    public boolean equals(Composition other)
    {
        return parent == other.parent && child == other.child;
    }

    public boolean equals(int otherParent, int otherChild)
    {
        return parent == otherParent && child == otherChild;
    }
    public int getParent()
    {
        return parent;
    }

    public int getChild()
    {
        return child;
    }
}
