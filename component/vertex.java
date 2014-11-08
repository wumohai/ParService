// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   vertex.java

package strulib;

import java.io.PrintStream;

// Referenced classes of package strulib:
//            MyObject, Newinteger

public class vertex extends MyObject
{

    public vertex()
    {
    }

    public vertex(MyObject label)
    {
        d = label;
        f = false;
    }

    public vertex copy()
    {
        vertex temp = new vertex();
        temp.d = d;
        temp.f = f;
        return temp;
    }

    public void clear()
    {
        d = null;
    }

    public vertex replaceby(vertex u)
    {
        vertex v = u;
        return v;
    }

    public boolean isempty()
    {
        return d == null;
    }

    public int compareTo(Object that)
    {
        if(that instanceof vertex)
            return d.compareTo(((vertex)that).d);
        else
            return d.compareTo(that);
    }

    public MyObject get_d()
    {
        return d;
    }

    public boolean get_f()
    {
        return f;
    }

    public void set_d(MyObject lab)
    {
        d = lab;
    }

    public void set_f(boolean flat)
    {
        f = flat;
    }

    public boolean equals(Object obj)
    {
        return d.compareTo(((vertex)obj).d) == 0;
    }

    public static void main(String args[])
    {
        vertex v = new vertex(new Newinteger(5));
        System.out.println(v.isempty());
        v = v.replaceby(new vertex());
        System.out.println(v.isempty());
    }

    MyObject d;
    boolean f;
}
