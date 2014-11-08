// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   arraybag.java

package strulib;

import java.io.PrintStream;

public class arraybag
{

    public arraybag(int i)
    {
        size = 0;
        capacity = i;
        data = new Object[i];
    }

    public arraybag(Object b)
    {
        size = 1;
        capacity = 10;
        data = new Object[10];
        data[0] = b;
    }

    public int size()
    {
        return size;
    }

    public Object get_a_value(int i)
    {
        if(i >= 0 && i <= size - 1)
            return data[i];
        else
            throw new ArrayIndexOutOfBoundsException(i);
    }

    public void modify(int i, Object obj)
    {
        if(i > size - 1 || i < 0)
        {
            throw new ArrayIndexOutOfBoundsException(i);
        } else
        {
            data[i] = obj;
            return;
        }
    }

    public void modify(int i, int obj)
    {
        if(i > size - 1 || i < 0)
        {
            throw new ArrayIndexOutOfBoundsException(i);
        } else
        {
            data[i] = new Integer(obj);
            return;
        }
    }

    public arraybag clear()
    {
        for(int i = 0; i < size; i++)
            data[i] = null;

        size = 0;
        return this;
    }

    public synchronized void copyInto(Object anArray[])
    {
        System.arraycopy(((Object) (data)), 0, ((Object) (anArray)), 0, size);
    }

    public boolean is_subbag(arraybag a, arraybag b)
    {
        if(a.size() == 0)
            return true;
        for(int i = 0; i < a.size(); i++)
            if(!b.is_contains(b, a.data[i]))
                return false;

        return true;
    }

    public arraybag intersection(arraybag b, arraybag c)
    {
        arraybag c1 = new arraybag(c.capacity);
        arraybag a = new arraybag(b.capacity + c.capacity);
        c1 = c.copy();
        for(int i = 0; i < b.size(); i++)
        {
            if(c1.is_contains(c1, b.data[i]))
                c1.removeelement(b.data[i]);
            a = a.union(a, new arraybag(b.data[i]));
        }

        a.size = a.size();
        a.capacity = b.capacity + c.capacity;
        return a;
    }

    public arraybag union(arraybag a, arraybag b)
    {
        arraybag newset = a.copy(a.capacity + b.capacity);
        int position = 0;
        for(int i = 0; i < b.size(); i++)
        {
            newset.data[a.size() + position] = b.data[i];
            position++;
        }

        newset.size = a.size() + position;
        newset.capacity = a.capacity + b.capacity;
        return newset;
    }

    public arraybag different(arraybag b, arraybag c)
    {
        arraybag newbag = b.copy(c.capacity + b.capacity);
        for(int i = 0; i < c.size(); i++)
            if(newbag.is_contains(newbag, c.data[i]))
                newbag.removeelement(c.data[i]);

        newbag.size = b.size() + c.size();
        newbag.capacity = c.capacity + b.capacity;
        return newbag;
    }

    public void removeelement(Object elem)
    {
        int i;
        if(elem == null)
            for(i = 0; i < size && data[i] != null; i++);
        else
            for(i = 0; i < size && !elem.equals(data[i]); i++);
        int j = size - i - 1;
        if(j > 0)
            System.arraycopy(((Object) (data)), i + 1, ((Object) (data)), i, j);
        size--;
        data[size] = null;
    }

    public boolean is_realsubbag(arraybag a, arraybag b)
    {
        return is_subbag(a, b) && a.size() < b.size();
    }

    public boolean is_equal(arraybag a, arraybag b)
    {
        return is_subbag(a, b) && is_subbag(b, a);
    }

    public boolean is_empty()
    {
        return size() == 0;
    }

    public arraybag copy(int capacity)
    {
        Object temp[] = new Object[size];
        copyInto(temp);
        arraybag sq = new arraybag(capacity);
        for(int i = 0; i < size; i++)
            sq.data[i] = temp[i];

        sq.size = size;
        sq.capacity = capacity;
        return sq;
    }

    public arraybag copy()
    {
        return copy(capacity);
    }

    public boolean is_contains(arraybag a, Object elem)
    {
        if(elem == null)
        {
            for(int i = 0; i < a.size(); i++)
                if(a.data[i] == null)
                    return true;

        } else
        {
            for(int i = 0; i < size; i++)
                if(elem.equals(a.data[i]))
                    return true;

        }
        return false;
    }

    public void print()
    {
        for(int i = 0; i < size; i++)
            System.out.print(data[i]);

    }

    int size;
    int capacity;
    Object data[];
}
