// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   arraylist.java

package strulib;

import java.io.PrintStream;

// Referenced classes of package strulib:
//            MyObject, Newreal, Newchar, Newinteger

public class arraylist
{

    public arraylist(int i)
    {
        size = 0;
        capacity = i;
        data = new MyObject[i];
        h = 0;
        t = 0;
    }

    public arraylist(double b)
    {
        size = 1;
        capacity = 10;
        data = new MyObject[10];
        data[0] = new Newreal(b);
        h = 1;
        t = 1;
    }

    public arraylist(String b)
    {
        size = 1;
        capacity = 10;
        data = new MyObject[10];
        data[0] = new Newchar(b);
        h = 1;
        t = 1;
    }

    public arraylist(MyObject b)
    {
        size = 1;
        capacity = 10;
        data = new MyObject[10];
        data[0] = b;
        h = 1;
        t = 1;
    }

    public arraylist(int i, int j)
    {
        size = 1;
        capacity = 1;
        data = new MyObject[j];
        data[0] = new Newinteger(i);
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

    public void modify(int i, MyObject obj)
    {
        if(size != 0 && (i > size - 1 || i < 0))
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
        if(size != 0 && (i > size - 1 || i < 0))
        {
            throw new ArrayIndexOutOfBoundsException(i);
        } else
        {
            data[i] = new Newinteger(obj);
            return;
        }
    }

    public arraylist clear()
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

    public MyObject get_a_value(int i)
    {
        if(size != 0 && (i > size - 1 || i < 0))
            throw new ArrayIndexOutOfBoundsException(i);
        else
            return data[i];
    }

    public synchronized void copyInto(Object anArray[], int sfrom, int dfrom, int len)
    {
        System.arraycopy(data, sfrom, ((Object) (anArray)), dfrom, len);
    }

    public synchronized void copyInto(Object anArray[])
    {
        System.arraycopy(data, 0, ((Object) (anArray)), 0, size);
    }

    public arraylist subseq(int i, int j)
    {
        if(i <= j)
        {
            MyObject temp[] = new MyObject[(j - i) + 1];
            copyInto(temp, i, 0, (j - i) + 1);
            arraylist sq = new arraylist(capacity);
            for(int k = 0; k < (j - i) + 1; k++)
                sq.data[k] = temp[k];

            sq.size = (j - i) + 1;
            sq.capacity = capacity;
            sq.h = 0;
            sq.t = ((j - i) + 1) - 1;
            return sq;
        } else
        {
            return new arraylist(1);
        }
    }

    public arraylist union(arraylist a, arraylist b)
    {
        if(a.size == 0 && b.size == 0)
            new arraylist(1);
        arraylist newseq = a.copy(a.size() + b.size());
        for(int i = 0; i < b.size(); i++)
            newseq.data[a.size() + i] = b.data[i];

        newseq.size = a.size() + b.size();
        newseq.capacity = a.size() + b.size();
        newseq.h = 0;
        newseq.t = (a.size() + b.size()) - 1;
        return newseq;
    }

    public void exchang(int i, int j)
    {
        if(i < h || j > this.t)
        {
            throw new ArrayIndexOutOfBoundsException(i);
        } else
        {
            MyObject t = data[i];
            data[i] = data[j];
            data[j] = t;
            return;
        }
    }

    public boolean is_equal(arraylist a, arraylist b)
    {
        if(a.size != b.size)
            return false;
        for(int i = 0; i < b.size(); i++)
            if(a.data[i] != b.data[i])
                return false;

        return true;
    }

    public arraylist replsubseq(arraylist a, arraylist b, int i, int j, int g)
    {
        if(i < 0 || j > a.size() - 1 || g < 0 || (g + j) - i > b.size() - 1)
            throw new ArrayIndexOutOfBoundsException(i);
        arraylist newseq = a.copy();
        for(int k = i; k <= j; k++)
            newseq.data[k] = b.data[(g + k) - i];

        newseq.size = a.size;
        newseq.capacity = a.capacity;
        newseq.h = a.h;
        newseq.t = a.t;
        return newseq;
    }

    private arraylist copy(int capacity)
    {
        MyObject temp[] = new MyObject[size];
        copyInto(temp);
        arraylist sq = new arraylist(capacity);
        for(int i = 0; i < size; i++)
            sq.data[i] = temp[i];

        sq.size = size;
        sq.capacity = capacity;
        sq.h = h;
        sq.t = t;
        return sq;
    }

    public arraylist copy()
    {
        return copy(capacity);
    }

    private boolean contains(arraylist a, Object elem)
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

    public void removeelement(Object elem)
    {
        int i;
        if(elem == null)
            for(i = 0; i < size && data[i] != null; i++);
        else
            for(i = 0; i < size && !elem.equals(data[i]); i++);
        int j = size - i - 1;
        if(j > 0)
            System.arraycopy(data, i + 1, data, i, j);
        size--;
        data[size] = null;
    }

    public void print()
    {
        for(int i = 0; i < size; i++)
            System.out.print(data[i]);

    }

    public static void main(String args[])
    {
        arraylist wh = new arraylist(5);
        wh = wh.union(wh, new arraylist(new Newinteger(1)));
        wh = wh.union(wh, new arraylist(new Newinteger(2)));
        wh = wh.union(wh, new arraylist(new Newinteger(3)));
        wh = wh.subseq(wh.get_h() + 1, wh.get_t());
        wh.print();
    }

    int size;
    int capacity;
    int h;
    int t;
    MyObject data[];
}
