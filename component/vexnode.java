// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   vexnode.java

package strulib;


// Referenced classes of package strulib:
//            MyObject, vertex, linkedlist

public class vexnode extends MyObject
{

    public vexnode(MyObject label)
    {
        gv = new vertex(label);
        adjlist = new linkedlist();
    }

    public vexnode(vertex vv)
    {
        gv = vv;
        adjlist = new linkedlist();
    }

    public int compareTo(Object that)
    {
        return 0;
    }

    vertex gv;
    linkedlist adjlist;
}
