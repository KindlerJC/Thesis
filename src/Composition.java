public class Composition
{
    int parent;
    int child;

    public Composition(int parent, int child)
    {
        this.parent = parent;
        this.child = child;
    }

    public boolean equals(Composition other)
    {
        return parent == other.parent && child == other.child;
    }
}
