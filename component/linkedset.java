// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   linkedset.java

package strulib;

import java.io.PrintStream;

// Referenced classes of package strulib:
//            link, node, Newinteger, edge, 
//            MyObject, input

public class linkedset extends link
{

    public linkedset()
    {
        super.head = new node();
        super.size = 0;
    }

    public linkedset(MyObject b)
    {
        super.head = new node();
        super.head.next = new node(b);
        super.size = 1;
    }

    public linkedset(int b)
    {
        super.head = new node();
        super.head.next = new node(new Newinteger(b));
        super.size = 1;
    }

    public void modify(int i, MyObject obj)
    {
        if(i > super.size - 1 || i < 0)
            throw new ArrayIndexOutOfBoundsException(i);
        node finger = super.head.next;
        for(int tag = 0; i != tag && finger != null; tag++)
            finger = finger.next;

        finger.data = obj;
    }

    public void modify(int i, int obj)
    {
        if(i > super.size - 1 || i < 0)
            throw new ArrayIndexOutOfBoundsException(i);
        node finger = super.head.next;
        for(int tag = 0; i != tag && finger != null; tag++)
            finger = finger.next;

        finger.data = new Newinteger(obj);
    }

    public linkedset clear()
    {
        super.head.next = null;
        return this;
    }

    public boolean is_subset(linkedset a, linkedset b)
    {
        if(a.size() == 0)
            return true;
        for(node finger = ((link) (a)).head.next; finger != null; finger = finger.next)
            if(!b.is_contains(b, finger.data))
                return false;

        return true;
    }

    public boolean is_realsubset(linkedset a, linkedset b)
    {
        return is_subset(a, b) && a.size() < b.size();
    }

    public boolean is_equal(linkedset a, linkedset b)
    {
        return is_subset(a, b) && is_subset(b, a);
    }

    public linkedset copy()
    {
        linkedset newlist = new linkedset();
        node newfinger = ((link) (newlist)).head;
        for(node finger = super.head.next; finger != null; finger = finger.next)
        {
            node newnode = new node(finger.data);
            newfinger.next = newnode;
            newfinger = newfinger.next;
        }

        newlist.size = newlist.size();
        return newlist;
    }

    public linkedset union(linkedset a, linkedset b)
    {
        linkedset newa = a.copy();
        node newafinger = ((link) (newa)).head;
        node bfinger = ((link) (b)).head.next;
        for(; newafinger.next != null; newafinger = newafinger.next);
        for(; bfinger != null; bfinger = bfinger.next)
            if(!newa.is_contains(newa, bfinger.data))
            {
                node newnode = new node(bfinger.data);
                newafinger.next = newnode;
                newafinger = newafinger.next;
            }

        newa.size = newa.size();
        return newa;
    }

    public linkedset intersection(linkedset a, linkedset b)
    {
        linkedset newa = new linkedset();
        node newfinger = ((link) (newa)).head;
        for(node afinger = ((link) (a)).head.next; afinger != null; afinger = afinger.next)
            if(b.is_contains(b, afinger.data))
            {
                node newnode = new node(afinger.data);
                newfinger.next = newnode;
                newfinger = newfinger.next;
            }

        newa.size = newa.size();
        return newa;
    }

    public void removeelement(Object elem)
    {
        node finger = super.head.next;
        node posefinger = super.head;
        if(elem == null)
            do
            {
                if(finger == null)
                    break;
                if(finger.data == null)
                {
                    posefinger.next = finger.next;
                    break;
                }
                finger = finger.next;
                posefinger = posefinger.next;
            } while(true);
        else
            do
            {
                if(finger == null)
                    break;
                if(finger.data.equals(elem))
                {
                    posefinger.next = finger.next;
                    break;
                }
                finger = finger.next;
                posefinger = posefinger.next;
            } while(true);
    }

    public boolean is_contains(linkedset A, Object value)
    {
        node finger;
        for(finger = ((link) (A)).head.next; finger != null && finger.data.compareTo(value) != 0; finger = finger.next);
        return finger != null;
    }

    public linkedset different(linkedset a, linkedset b)
    {
        linkedset newa = a.copy();
        node bfinger = ((link) (b)).head.next;
        node afinger = ((link) (newa)).head.next;
        node aprefinger = ((link) (newa)).head;
        while(afinger != null) 
            if(b.is_contains(b, afinger.data))
            {
                aprefinger.next = afinger.next;
                afinger = aprefinger.next;
            } else
            {
                afinger = afinger.next;
                aprefinger = aprefinger.next;
            }
        newa.size = newa.size();
        return newa;
    }

    public static void main(String arg[])
    {
        linkedset S = new linkedset();
        edge ee = new edge(input.readeweight(), new Newinteger(input.readint()), new Newinteger(input.readint()));
        edge e = ee;
        S = S.union(S, new linkedset(e));
        System.out.println("size".concat(String.valueOf(String.valueOf(S.size()))));
        ee = new edge(input.readeweight(), new Newinteger(input.readint()), new Newinteger(input.readint()));
        e = ee;
        S = S.union(S, new linkedset(e));
        System.out.println("size".concat(String.valueOf(String.valueOf(S.size()))));
    }
}
