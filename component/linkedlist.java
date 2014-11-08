// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   linkedlist.java

package strulib;


// Referenced classes of package strulib:
//            link, node, cursornode, Newreal, 
//            Newinteger, MyObject

public class linkedlist extends link
{

    public linkedlist()
    {
        super.head = new node();
        hoflist = new cursornode();
        toflist = new cursornode();
        super.size = 0;
    }

    public linkedlist(MyObject b)
    {
        super.head = new node();
        hoflist = new cursornode();
        toflist = new cursornode();
        super.head.next = new node(b);
        super.size = 1;
        hoflist.refnode = super.head.next;
        hoflist.index = 0;
        toflist.refnode = super.head.next;
        toflist.index = 0;
    }

    public linkedlist(double b)
    {
        super.head = new node();
        hoflist = new cursornode();
        toflist = new cursornode();
        super.head.next = new node(new Newreal(b));
        super.size = 1;
        hoflist.refnode = super.head.next;
        hoflist.index = 0;
        toflist.refnode = super.head.next;
        toflist.index = 0;
    }

    public linkedlist(int b)
    {
        super.head = new node();
        hoflist = new cursornode();
        toflist = new cursornode();
        super.head.next = new node(new Newinteger(b));
        super.size = 1;
        hoflist.refnode = super.head.next;
        hoflist.index = 0;
        toflist.refnode = super.head.next;
        toflist.index = 0;
    }

    public int get_h()
    {
        return hoflist.index;
    }

    public int get_t()
    {
        return toflist.index;
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

    public linkedlist clear()
    {
        super.head.next = null;
        super.size = 0;
        hoflist.refnode = null;
        hoflist.index = -1;
        toflist.refnode = null;
        toflist.index = -1;
        return this;
    }

    public boolean is_equal(linkedlist a, linkedlist b)
    {
        if(a.size() != b.size())
            return false;
        node afinger = ((link) (a)).head.next;
        for(node bfinger = ((link) (b)).head.next; afinger != null; bfinger = bfinger.next)
        {
            if(afinger.data != bfinger.data)
                return false;
            afinger = afinger.next;
        }

        return true;
    }

    public void exchang(int i, int j)
    {
        node ifinger = super.head.next;
        for(int tag = 0; i != tag && ifinger != null; tag++)
            ifinger = ifinger.next;

        node jfinger = super.head.next;
        for(int tag = 0; j != tag && jfinger != null; tag++)
            jfinger = jfinger.next;

        node temp = null;
        temp.data = ifinger.data;
        ifinger.data = jfinger.data;
        jfinger.data = temp.data;
    }

    public linkedlist subseq(int i, int j)
    {
        if(i <= j)
        {
            linkedlist sq = new linkedlist();
            node sqfinger = ((link) (sq)).head;
            node finger = super.head.next;
            for(int tag = 0; i != tag && finger != null; tag++)
                finger = finger.next;

            for(int k = 0; k < (j - i) + 1; k++)
            {
                node temp = new node();
                temp.data = finger.data;
                sqfinger.next = temp;
                sq.toflist.refnode = sqfinger;
                sqfinger = sqfinger.next;
                finger = finger.next;
            }

            sq.toflist.index = j - i;
            sq.hoflist.refnode = ((link) (sq)).head.next;
            sq.hoflist.index = 0;
            sq.size = (j - i) + 1;
            return sq;
        } else
        {
            linkedlist sq = new linkedlist();
            return sq;
        }
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

    public boolean is_contains(linkedlist A, Object value)
    {
        node finger;
        for(finger = ((link) (A)).head.next; finger != null && !finger.data.equals(value); finger = finger.next);
        return finger != null;
    }

    public linkedlist replsubseq(linkedlist a, linkedlist b, int i, int j, int g)
    {
        if(a == null || b == null)
            throw new ArrayIndexOutOfBoundsException(i);
        if(i < 0 || j > a.size() - 1 || g < 0 || (g + j) - i > b.size() - 1)
            throw new ArrayIndexOutOfBoundsException(i);
        linkedlist newseq = a.copy();
        node fingera = ((link) (newseq)).head;
        int taga;
        for(taga = 0; taga <= i; taga++)
            fingera = fingera.next;

        node fingerb = ((link) (b)).head;
        for(int tagb = 0; tagb <= g;)
        {
            fingerb = fingerb.next;
            taga++;
        }

        for(int k = i; k <= j; k++)
        {
            fingera.data = fingerb.data;
            fingera = fingera.next;
            fingerb = fingerb.next;
        }

        newseq.size = ((link) (a)).size;
        newseq.hoflist = a.hoflist;
        newseq.toflist = a.toflist;
        return newseq;
    }

    public linkedlist copy()
    {
        linkedlist newlist = new linkedlist();
        node newfinger = ((link) (newlist)).head;
        for(node finger = super.head.next; finger != null; finger = finger.next)
        {
            node newnode = new node(finger.data);
            newfinger.next = newnode;
            newfinger = newfinger.next;
        }

        newlist.size = newlist.size();
        newlist.hoflist = hoflist;
        newlist.toflist = toflist;
        return newlist;
    }

    public linkedlist union(linkedlist a, linkedlist b)
    {
        linkedlist newa = a.copy();
        node newafinger = ((link) (newa)).head;
        node bfinger = ((link) (b)).head.next;
        for(; newafinger.next != null; newafinger = newafinger.next);
        if(bfinger != null)
        {
            for(; bfinger != null; bfinger = bfinger.next)
            {
                node newnode = new node(bfinger.data);
                newafinger.next = newnode;
                newafinger = newafinger.next;
                newa.toflist.refnode = newafinger;
            }

            newa.size = newa.size();
            newa.toflist.index = ((link) (newa)).size - 1;
            newa.hoflist.refnode = ((link) (newa)).head.next;
            newa.hoflist.index = 0;
        } else
        {
            newa.size = newa.size();
            newa.toflist.refnode = newafinger;
            newa.toflist.index = ((link) (newa)).size - 1;
            newa.hoflist.refnode = ((link) (newa)).head.next;
            newa.hoflist.index = 0;
        }
        return newa;
    }

    cursornode hoflist;
    cursornode toflist;
}
