// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   arrayseq.java

package strulib;

import java.io.PrintStream;

public class arrayseq
{

    public arrayseq(int i)
    {
        size = 0;
        capacity = i;
        data = new Object[i];
        h = 0;
        t = 0;
    }

    public arrayseq(Object b)
    {
        size = 1;
        capacity = 10;
        data = new Object[10];
        data[0] = b;
        h = 1;
        t = 1;
    }

    public int get_h()
    {
        return h;
    }

    public int get_t()
    {
        return t;
    }

    public arrayseq clear()
    {
        for(int i = 0; i < size; i++)
            data[i] = null;

        size = 0;
        h = 0;
        t = 0;
        return this;
    }

    public boolean is_empty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public Object get_a_value(int i)
    {
        if(i > t || i < h)
            throw new ArrayIndexOutOfBoundsException(i);
        else
            return data[i - 1];
    }

    public synchronized void copyInto(Object anArray[], int sfrom, int dfrom, int len)
    {
        System.arraycopy(((Object) (data)), sfrom, ((Object) (anArray)), dfrom, len);
    }

    public synchronized void copyInto(Object anArray[])
    {
        System.arraycopy(((Object) (data)), 0, ((Object) (anArray)), 0, size);
    }

    public arrayseq subseq(int i, int j)
    {
        i--;
        j--;
        if(i <= j)
        {
            Object temp[] = new Object[(j - i) + 1];
            copyInto(temp, i, 0, (j - i) + 1);
            arrayseq sq = new arrayseq(capacity);
            for(int k = 0; k < (j - i) + 1; k++)
                sq.data[k] = temp[k];

            sq.size = (j - i) + 1;
            sq.capacity = capacity;
            sq.h = 1;
            sq.t = (j - i) + 1;
            return sq;
        } else
        {
            return new arrayseq(1);
        }
    }

    public arrayseq union(arrayseq a, arrayseq b)
    {
        if(a.size == 0 && b.size == 0)
            new arrayseq(1);
        arrayseq newseq = a.copy(a.size() + b.size());
        for(int i = 0; i < b.size(); i++)
            newseq.data[a.size() + i] = b.data[i];

        newseq.size = a.size() + b.size();
        newseq.capacity = a.size() + b.size();
        newseq.h = 1;
        newseq.t = a.size() + b.size();
        return newseq;
    }

    public void exchang(int i, int j)
    {
        if(i < h || j > this.t)
        {
            throw new ArrayIndexOutOfBoundsException(i);
        } else
        {
            Object t = new Object();
            t = data[i];
            data[i] = data[j];
            data[j] = t;
            return;
        }
    }

    public boolean is_equal(arrayseq a, arrayseq b)
    {
        if(a.size != b.size)
            return false;
        for(int i = 0; i < b.size(); i++)
            if(a.data[i] != b.data[i])
                return false;

        return true;
    }

    public arrayseq replsubseq(arrayseq a, arrayseq b, int i, int j)
    {
        if(i < b.h || i < a.h || j > b.t || j > a.t)
            throw new ArrayIndexOutOfBoundsException(i);
        arrayseq newseq = a.copy();
        for(int k = i; k <= j; k++)
            newseq.data[k] = b.data[k];

        newseq.size = a.size;
        newseq.capacity = a.capacity;
        newseq.h = a.h;
        newseq.t = a.t;
        return newseq;
    }

    private arrayseq copy(int capacity)
    {
        Object temp[] = new Object[size];
        copyInto(temp);
        arrayseq sq = new arrayseq(capacity);
        for(int i = 0; i < size; i++)
            sq.data[i] = temp[i];

        sq.size = size;
        sq.capacity = capacity;
        sq.h = h;
        sq.t = t;
        return sq;
    }

    public arrayseq copy()
    {
        return copy(capacity);
    }

    private boolean contains(arrayseq a, Object elem)
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
    int h;
    int t;
    Object data[];
}
