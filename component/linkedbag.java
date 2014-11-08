// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   linkedbag.java

package strulib;


// Referenced classes of package strulib:
//            link, node, MyObject

public class linkedbag extends link
{

    public linkedbag()
    {
        super.head = new node();
        super.size = 0;
    }

    public linkedbag(MyObject b)
    {
        super.head = new node();
        super.head.next = new node(b);
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

    public linkedbag clear()
    {
        super.head.next = null;
        return this;
    }

    public boolean is_subbag(linkedbag a, linkedbag b)
    {
        if(a.size() == 0)
            return true;
        for(node finger = ((link) (a)).head.next; finger != null; finger = finger.next)
            if(!b.is_contains(b, finger.data))
                return false;

        return true;
    }

    public boolean is_realsubbag(linkedbag a, linkedbag b)
    {
        return is_subbag(a, b) && a.size() < b.size();
    }

    public boolean is_equal(linkedbag a, linkedbag b)
    {
        return is_subbag(a, b) && is_subbag(b, a);
    }

    public linkedbag copy()
    {
        linkedbag newlist = new linkedbag();
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

    public linkedbag union(linkedbag a, linkedbag b)
    {
        linkedbag newa = a.copy();
        linkedbag newb = b.copy();
        node finger;
        for(finger = ((link) (newa)).head; finger.next != null; finger = finger.next);
        finger.next = ((link) (newb)).head.next;
        newa.size = a.size() + b.size();
        return newa;
    }

    public linkedbag intersection(linkedbag b, linkedbag c)
    {
        linkedbag newa = new linkedbag();
        linkedbag c1 = c.copy();
        node newfinger = ((link) (newa)).head;
        for(node bfinger = ((link) (b)).head.next; bfinger != null; bfinger = bfinger.next)
            if(c1.is_contains(c1, bfinger.data))
            {
                c1.removeelement(bfinger.data);
                node newnode = new node(bfinger.data);
                newfinger.next = newnode;
                newfinger = newfinger.next;
            }

        newa.size = newa.size();
        return newa;
    }

    public void removeelement(Comparable elem)
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

    public boolean is_contains(linkedbag A, Object value)
    {
        node finger;
        for(finger = ((link) (A)).head.next; finger != null && !finger.data.equals(value); finger = finger.next);
        return finger != null;
    }

    public linkedbag different(linkedbag b, linkedbag c)
    {
        linkedbag newa = b.copy();
        node cfinger = ((link) (c)).head.next;
        node afinger = ((link) (newa)).head.next;
        for(; cfinger != null; cfinger = cfinger.next)
            if(newa.is_contains(newa, cfinger.data))
                newa.removeelement(cfinger.data);

        newa.size = newa.size();
        return newa;
    }
}
