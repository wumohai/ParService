// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   arrayset.java

package strulib;

import java.io.PrintStream;

// Referenced classes of package strulib:
//            MyObject, Newinteger, vertex

public class arrayset
{

    public arrayset()
    {
    }

    public arrayset(int i)
    {
        size = 0;
        capacity = i;
        data = new MyObject[i];
    }

    public arrayset(MyObject b)
    {
        size = 1;
        capacity = 10;
        data = new MyObject[10];
        data[0] = b;
    }

    public int size()
    {
        return size;
    }

    public MyObject get_a_value(int i)
    {
        if(i >= 0 && i <= size - 1)
            return data[i];
        else
            throw new ArrayIndexOutOfBoundsException(i);
    }

    public void modify(int i, MyObject obj)
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
            data[i] = new Newinteger(obj);
            return;
        }
    }

    public arrayset clear()
    {
        for(int i = 0; i < size; i++)
            data[i] = null;

        size = 0;
        return this;
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

    public synchronized void copyInto(Object anArray[])
    {
        System.arraycopy(data, 0, ((Object) (anArray)), 0, size);
    }

    public boolean is_subset(arrayset a, arrayset b)
    {
        if(a.size() == 0)
            return true;
        for(int i = 0; i < a.size(); i++)
            if(!b.is_contains(b, a.data[i]))
                return false;

        return true;
    }

    public arrayset intersection(arrayset a, arrayset b)
    {
        arrayset newset = new arrayset(a.capacity + b.capacity);
        int position = 0;
        for(int i = 0; i < b.size(); i++)
            if(a.is_contains(a, b.data[i]))
            {
                newset.data[position] = b.data[i];
                position++;
            }

        newset.size = position;
        newset.capacity = a.capacity + b.capacity;
        return newset;
    }

    public arrayset union(arrayset a, arrayset b)
    {
        arrayset newset = a.copy(a.capacity + b.capacity);
        int position = 0;
        for(int i = 0; i < b.size(); i++)
            if(!a.is_contains(a, b.data[i]))
            {
                newset.data[a.size() + position] = b.data[i];
                position++;
            }

        newset.size = a.size() + position;
        newset.capacity = a.capacity + b.capacity;
        return newset;
    }

    public arrayset different(arrayset a, arrayset b)
    {
        arrayset newset = new arrayset(a.capacity + b.capacity);
        int position = 0;
        for(int i = 0; i < a.size(); i++)
            if(!b.is_contains(b, a.data[i]))
            {
                newset.data[position] = a.data[i];
                position++;
            }

        newset.size = position;
        newset.capacity = a.capacity + b.capacity;
        return newset;
    }

    public void different(arrayset b)
    {
        for(int i = 0; i < size(); i++)
        {
            if(b.is_contains(b, data[i]))
                continue;
            if(i + 1 < size())
                System.arraycopy(this, i + 1, this, i, size() - i - 1);
            else
                data[i] = null;
        }

        size = size();
    }

    public boolean is_realsubset(arrayset a, arrayset b)
    {
        return is_subset(a, b) && a.size() < b.size();
    }

    public boolean is_equal(arrayset a, arrayset b)
    {
        return is_subset(a, b) && is_subset(b, a);
    }

    public boolean is_empty()
    {
        return size() == 0;
    }

    public arrayset copy(int capacity)
    {
        MyObject temp[] = new MyObject[size];
        copyInto(temp);
        arrayset sq = new arrayset(capacity);
        for(int i = 0; i < size; i++)
            sq.data[i] = temp[i];

        sq.size = size;
        sq.capacity = capacity;
        return sq;
    }

    public arrayset copy()
    {
        return copy(capacity);
    }

    public boolean is_contains(arrayset a, Object elem)
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

    public static void main(String args[])
    {
        arrayset a = new arrayset(5);
        arrayset b = new arrayset(5);
        a = a.union(a, new arrayset(new vertex(new Newinteger(5))));
        a = a.union(a, new arrayset(new vertex(new Newinteger(4))));
        a.is_contains(a, new vertex(new Newinteger(5)));
        System.out.print(a.is_contains(a, new vertex(new Newinteger(6))));
    }

    int size;
    int capacity;
    MyObject data[];
}
