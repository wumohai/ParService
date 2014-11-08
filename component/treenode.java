// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   treenode.java

package strulib;


// Referenced classes of package strulib:
//            MyObject, btree

public class treenode extends MyObject
    implements Cloneable
{

    public treenode()
    {
    }

    public treenode(MyObject value)
    {
        key = value;
        left = null;
        right = null;
        parent = null;
    }

    public Object clone()
    {
        treenode t = null;
        try
        {
            t = (treenode)super.clone();
        }
        catch(CloneNotSupportedException e) { }
        return t;
    }

    public int compareTo(Object that)
    {
        return 0;
    }

    protected btree parent;
    public btree left;
    public btree right;
    protected MyObject key;
}
