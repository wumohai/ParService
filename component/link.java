// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   link.java

package strulib;

import java.io.PrintStream;

// Referenced classes of package strulib:
//            MyObject, node, Newinteger

public class link extends MyObject
{

    public link()
    {
    }

    public int compareTo(Object that)
    {
        return 0;
    }

    public int size()
    {
        node finger = head.next;
        int i = 0;
        for(; finger != null; finger = finger.next)
            i++;

        return i;
    }

    public boolean is_empty()
    {
        return size() == 0;
    }

    public void print()
    {
        for(node finger = head.next; finger != null; finger = finger.next)
            System.out.print(finger.data);

    }

    public MyObject get_a_value(int index)
    {
        if(index < 0 || index > size() - 1)
            throw new IndexOutOfBoundsException(String.valueOf(String.valueOf((new StringBuffer("Index: ")).append(index).append(", Size: ").append(size))));
        node finger = head.next;
        for(int tag = 0; index != tag && finger != null; tag++)
            finger = finger.next;

        return finger.data;
    }

    public void modify(int index, MyObject obj)
    {
        if(index < 0 || index > size() - 1)
            throw new IndexOutOfBoundsException(String.valueOf(String.valueOf((new StringBuffer("Index: ")).append(index).append(", Size: ").append(size))));
        node e = head.next;
        for(int i = 0; i != index; i++)
            e = e.next;

        e.data = obj;
    }

    public void modify(int index, int obj)
    {
        if(index < 0 || index > size() - 1)
            throw new IndexOutOfBoundsException(String.valueOf(String.valueOf((new StringBuffer("Index: ")).append(index).append(", Size: ").append(size))));
        node e = head.next;
        for(int i = 0; i != index; i++)
            e = e.next;

        e.data = new Newinteger(obj);
    }

    public void removeelement(Object elem)
    {
        node finger = head.next;
        node prefinger = head;
        do
        {
            if(finger == null)
                break;
            if(finger.data.equals(elem))
            {
                prefinger.next = finger.next;
                break;
            }
            prefinger = prefinger.next;
            finger = finger.next;
        } while(true);
    }

    protected int size;
    protected node head;
}
