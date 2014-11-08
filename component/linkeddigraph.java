// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   linkeddigraph.java

package strulib;

import java.io.PrintStream;

// Referenced classes of package strulib:
//            linkedset, linkedlist, vexnode, node, 
//            edge, vertex, Newinteger, MyObject, 
//            link, input

public class linkeddigraph
{

    public linkeddigraph()
    {
        v = new linkedset();
        e = new linkedset();
        dictin = new linkedlist();
        dictout = new linkedlist();
    }

    public void clear()
    {
        v.clear();
        e.clear();
        dictin.clear();
        dictout.clear();
        sizeofv = 0;
        sizeofe = 0;
    }

    public boolean visequal(vertex u, vertex v)
    {
        return v.d.compareTo(u.d) == 0;
    }

    public void setv(vertex v, vertex u)
    {
        v.d = u.d;
        v.f = u.f;
    }

    public boolean eisequal(edge e1, edge e)
    {
        return e1.w == e.w && e1.h.equals(e.h) && e1.t.equals(e.t);
    }

    public void sete(edge e1, edge e)
    {
        e1.w = e.w;
        e1.h = e.h;
        e1.t = e.t;
    }

    public linkedset getv()
    {
        return v;
    }

    public linkedset gete()
    {
        return e;
    }

    public int sizeofv()
    {
        return v.size();
    }

    public int sizeofe()
    {
        return e.size();
    }

    public boolean is_equal(linkeddigraph g1, linkeddigraph g2)
    {
        return g1.v.is_equal(g1.v, g2.v) && g1.e.is_equal(g1.e, g2.e);
    }

    public linkeddigraph copy()
    {
        linkeddigraph g = new linkeddigraph();
        g.v = v.copy();
        g.e = e.copy();
        return g;
    }

    public void addv(vertex u)
    {
        v = v.union(v, new linkedset(u));
        if(!is_containsv(u.d))
        {
            dictin = dictin.union(dictin, new linkedlist(new vexnode(u)));
            dictout = dictout.union(dictout, new linkedlist(new vexnode(u)));
        }
    }

    public void adde(edge e1)
    {
        e = e.union(e, new linkedset(e1));
        node finger;
        for(finger = ((link) (dictout)).head.next; finger != null && ((vexnode)finger.data).gv.d.compareTo(e1.get_h().d) != 0; finger = finger.next);
        if(finger != null)
            ((vexnode)finger.data).adjlist = ((vexnode)finger.data).adjlist.union(((vexnode)finger.data).adjlist, new linkedlist(e1));
        for(finger = ((link) (dictin)).head.next; finger != null && ((vexnode)finger.data).gv.d.compareTo(e1.get_t().d) != 0; finger = finger.next);
        if(finger != null)
            ((vexnode)finger.data).adjlist = ((vexnode)finger.data).adjlist.union(((vexnode)finger.data).adjlist, new linkedlist(e1));
    }

    public void modifyin(linkedset a, linkedset b)
    {
        a = b;
    }

    public int arcvalue(vertex begin, vertex end)
    {
        node dictinfinger = null;
        node finger;
        for(finger = ((link) (dictout)).head.next; finger != null && ((vexnode)finger.data).gv.d.compareTo(begin.d) != 0; finger = finger.next);
        if(finger != null)
            for(dictinfinger = ((link) (((vexnode)finger.data).adjlist)).head.next; dictinfinger != null && ((edge)dictinfinger.data).get_t().d.compareTo(end.d) != 0; dictinfinger = dictinfinger.next);
        if(dictinfinger != null)
            return ((edge)dictinfinger.data).get_w();
        else
            return 0x1869f;
    }

    public edge getevalue(vertex begin, vertex end)
    {
        node dictinfinger = null;
        node finger;
        for(finger = ((link) (dictout)).head.next; finger != null && ((vexnode)finger.data).gv.d.compareTo(begin.d) != 0; finger = finger.next);
        if(finger != null)
            for(dictinfinger = ((link) (((vexnode)finger.data).adjlist)).head.next; dictinfinger != null && ((edge)dictinfinger.data).get_t().d.compareTo(end.d) != 0; dictinfinger = dictinfinger.next);
        if(dictinfinger != null)
            return (edge)dictinfinger.data;
        else
            return null;
    }

    public linkedset in(vertex u)
    {
        linkedset inset = new linkedset();
        node finger;
        for(finger = ((link) (dictin)).head.next; finger != null && ((vexnode)finger.data).gv.d.compareTo(u.d) != 0; finger = finger.next);
        if(finger != null)
        {
            for(node dictinfinger = ((link) (((vexnode)finger.data).adjlist)).head.next; dictinfinger != null; dictinfinger = dictinfinger.next)
                inset = inset.union(inset, new linkedset(((edge)dictinfinger.data).get_h()));

        }
        return inset;
    }

    public linkedset out(vertex u)
    {
        linkedset inset = new linkedset();
        node finger;
        for(finger = ((link) (dictout)).head.next; finger != null && ((vexnode)finger.data).gv.d.compareTo(u.d) != 0; finger = finger.next);
        if(finger != null)
        {
            for(node dictinfinger = ((link) (((vexnode)finger.data).adjlist)).head.next; dictinfinger != null; dictinfinger = dictinfinger.next)
                inset = inset.union(inset, new linkedset(((edge)dictinfinger.data).get_t()));

        }
        return inset;
    }

    public boolean is_containsv(MyObject value)
    {
        node finger;
        for(finger = ((link) (dictin)).head.next; finger != null && ((vexnode)finger.data).gv.d.compareTo(value) != 0; finger = finger.next);
        return finger != null;
    }

    public void removev(vertex u)
    {
        v.removeelement(u);
    }

    public void removee(edge e1)
    {
        e.removeelement(e1);
    }

    public static void main(String arg[])
    {
        linkeddigraph g = new linkeddigraph();
        vertex v1 = new vertex(new Newinteger(input.readint()));
        g.addv(v1);
        vertex v2 = new vertex(new Newinteger(input.readint()));
        g.addv(v2);
        vertex v3 = new vertex(new Newinteger(input.readint()));
        g.addv(v3);
        System.out.println("size".concat(String.valueOf(String.valueOf(g.getv().size()))));
        System.out.print("edge:");
        edge e = new edge(input.readeweight(), new Newinteger(input.readint()), new Newinteger(input.readint()));
        g.adde(e);
        edge e1 = new edge(input.readeweight(), new Newinteger(input.readint()), new Newinteger(input.readint()));
        g.adde(e1);
    }

    linkedset v;
    linkedset e;
    linkedlist dictin;
    linkedlist dictout;
    int sizeofv;
    int sizeofe;
}
