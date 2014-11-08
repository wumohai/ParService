// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   edge.java

package strulib;


// Referenced classes of package strulib:
//            MyObject, vertex

public class edge extends MyObject
{

    public edge()
    {
    }

    public edge(int weight, MyObject begin, MyObject end)
    {
        w = weight;
        h = new vertex(begin);
        t = new vertex(end);
        f = false;
    }

    public edge(int weight, vertex begin, vertex end)
    {
        w = weight;
        h = begin;
        t = end;
        f = false;
    }

    public edge copy()
    {
        edge temp = new edge();
        temp.w = w;
        temp.h = h.copy();
        temp.t = t.copy();
        temp.f = f;
        return temp;
    }

    public int compareTo(Object that)
    {
        int c = 0;
        if(that instanceof edge)
            if(h.compareTo(((edge)that).h) == 0 && t.compareTo(((edge)that).t) == 0)
                c = 0;
            else
                c = 1;
        return c;
    }

    public int get_w()
    {
        return w;
    }

    public vertex get_h()
    {
        return h;
    }

    public vertex get_t()
    {
        return t;
    }

    public boolean get_f()
    {
        return f;
    }

    public void set_w(int weight)
    {
        w = weight;
    }

    public void set_f(boolean flat)
    {
        f = flat;
    }

    public void set_h(vertex v)
    {
        h = v;
    }

    public void set_t(vertex v)
    {
        t = v;
    }

    public void set_h(MyObject d)
    {
        h.d = d;
    }

    public void set_t(MyObject d)
    {
        t.d = d;
    }

    int w;
    vertex h;
    vertex t;
    boolean f;
}
