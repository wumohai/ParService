// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Bag.java

package strulib;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Vector;

public class Bag extends Vector
    implements Collection
{

    public Bag()
    {
    }

    public void insert(Object obj)
    {
        super.addElement(obj);
    }

    public Bag union(Bag p, Bag q)
    {
        int i = 0;
        Bag sq = new Bag();
        sq = p.copy();
        for(; i < q.size(); i++)
            sq.add(q.elementData[i]);

        return sq;
    }

    public Bag delete()
    {
        remove(0);
        return this;
    }

    public boolean is_a_number(Object x)
    {
        return contains(x);
    }

    public boolean is_empty()
    {
        return super.isEmpty();
    }

    public Object get_a_value()
    {
        return elementData[0];
    }

    public void clear()
    {
        removeAllElements();
    }

    public Bag copy()
    {
        int i = 0;
        Bag sq = new Bag();
        for(; i < size(); i++)
            sq.add(elementData[i]);

        return sq;
    }

    public Bag diffent(Bag b, Bag c)
    {
        Bag a = new Bag();
        a = b.copy();
        for(int i = 0; i < c.size(); i++)
            if(a.contains(c.elementData[i]))
                a.removeElement(c.elementData[i]);

        return a;
    }

    public Bag intersection(Bag b, Bag c)
    {
        Bag c1 = new Bag();
        Bag a = new Bag();
        c1 = c.copy();
        for(int i = 0; i < b.size(); i++)
        {
            if(c1.contains(b.elementData[i]))
                c1.removeElement(b.elementData[i]);
            a.add(b.elementData[i]);
        }

        return a;
    }

    public static boolean is_subBag(Bag p, Bag q)
    {
        boolean result = true;
        int i = 0;
        if(p.size() > q.size())
            result = false;
        Bag qq = new Bag();
        for(; i < p.size() && result && p.size() < q.size(); i++)
            if(!qq.contains(p.elementData[i]))
                result = false;
            else
                qq.removeElement(p.elementData[i]);

        if(p.size() == 0)
            result = true;
        return result;
    }

    public static boolean is_equal(Bag p, Bag q)
    {
        boolean result = false;
        if(is_subBag(p, q) && is_subBag(q, p))
            result = true;
        return result;
    }

    public void print()
    {
        for(int i = 0; i < size(); i++)
            System.out.print(elementData[i]);

    }
}
