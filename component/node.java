// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   node.java

package strulib;


// Referenced classes of package strulib:
//            MyObject

class node extends MyObject
{

    public node()
    {
    }

    public node(MyObject value)
    {
        data = value;
        next = null;
    }

    public int compareTo(Object that)
    {
        return 0;
    }

    public Object Clone()
    {
        node n = new node(data);
        return n;
    }

    MyObject data;
    node next;
}
