public class Composition
{
    private int parent;
    private int child;
    private int caseNum;

    public Composition(int caseNum, int parent, int child)
    {
        this.caseNum = caseNum;
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

    public int getCase()
    {
        return caseNum;
    }
}
