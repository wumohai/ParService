// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   linkeddigraphcp.java

package strulib;

import java.io.PrintStream;

// Referenced classes of package strulib:
//            linkedset, node, vexnode, Newinteger, 
//            edge, vertex, NewString, link, 
//            MyObject, input, linkedlist

public class linkeddigraphcp
{

    public linkeddigraphcp()
    {
        v = new linkedset();
        e = new linkedset();
    }

    public void clear()
    {
    }

    public boolean visequal(vertex u, vertex v)
    {
        return v.d == u.d;
    }

    public void setv(vertex v, vertex u)
    {
        v.d = u.d;
        v.f = u.f;
    }

    public int arcvalue(vertex begin, vertex end)
    {
        return getevalue(begin, end).get_w();
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

    public boolean is_containsv(MyObject value)
    {
        node finger;
        for(finger = ((link) (dictin)).head.next; finger != null && ((vexnode)finger.data).gv.d.compareTo(value) != 0; finger = finger.next);
        return finger != null;
    }

    public edge getevalue(vertex v1, vertex v2)
    {
        setedgeset();
        return edgeset[((Newinteger)v1.d).value][((Newinteger)v2.d).value];
    }

    public int sizeofv()
    {
        return v.size();
    }

    public int sizeofe()
    {
        return e.size();
    }

    public boolean is_equal(linkeddigraphcp g1, linkeddigraphcp g2)
    {
        return g1.v.is_equal(g1.v, g2.v) && g1.e.is_equal(g1.e, g2.e);
    }

    public linkeddigraphcp copy()
    {
        linkeddigraphcp g = new linkeddigraphcp();
        g.v = v.copy();
        g.e = e.copy();
        return g;
    }

    public void addv(vertex u)
    {
        v = v.union(v, new linkedset(u));
    }

    public void adde(edge e1)
    {
        e = e.union(e, new linkedset(e1));
    }

    public void modifyin(linkedset a, linkedset b)
    {
        a = b;
    }

    public void setedgeset()
    {
        int size = getv().size();
        edgeset = new edge[size + 1][size + 1];
        for(int i = 0; i < e.size(); i++)
        {
            int row = ((Newinteger)((edge)e.get_a_value(i)).get_h().get_d()).value;
            int col = ((Newinteger)((edge)e.get_a_value(i)).get_t().get_d()).value;
            edgeset[row][col] = (edge)e.get_a_value(i);
        }

    }

    public linkedset in(vertex u)
    {
        boolean flag = false;
        int col = 0;
        do
        {
            if(col >= v.size())
                break;
            if(((vertex)v.get_a_value(col)).d == u.d)
            {
                flag = true;
                break;
            }
            col++;
        } while(true);
        linkedset outset = new linkedset();
        setedgeset();
        if(flag)
        {
            for(int j = 0; j < v.size(); j++)
                if(edgeset[j][col] != null)
                    outset = outset.union(outset, new linkedset(v.get_a_value(j)));

        }
        return outset;
    }

    public linkedset out(vertex u)
    {
        boolean flag = false;
        int row = 0;
        do
        {
            if(row >= v.size())
                break;
            if(((vertex)v.get_a_value(row)).d == u.d)
            {
                flag = true;
                break;
            }
            row++;
        } while(true);
        linkedset outset = new linkedset();
        setedgeset();
        if(flag)
        {
            for(int j = 0; j < v.size(); j++)
                if(edgeset[row][j] != null)
                    outset = outset.union(outset, new linkedset(v.get_a_value(j)));

        }
        return outset;
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
        linkeddigraphcp g = new linkeddigraphcp();
        g.clear();
        vertex v = new vertex(new NewString(input.readstring()));
        g.addv(v);
        v = new vertex(new NewString(input.readstring()));
        g.addv(v);
        edge e = new edge(4, new NewString("v1"), new NewString("v3"));
        g.adde(e);
        g.removev(v);
        System.out.print("sizeofe:  ");
        System.out.print(g.sizeofe());
        System.out.print("sizeofv:  ");
        System.out.print(g.sizeofv());
        linkedset inset = new linkedset();
        inset.print();
        System.out.print(inset.equals(inset));
    }

    linkedset v;
    linkedset e;
    edge edgeset[][];
    int sizeofv;
    int sizeofe;
    linkedlist dictin;
    linkedlist dictout;
}
