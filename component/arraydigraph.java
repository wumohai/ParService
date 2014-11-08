// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   arraydigraph.java

package strulib;


// Referenced classes of package strulib:
//            MyObject, arrayset, vertex, edge

public class arraydigraph extends MyObject
{

    public arraydigraph(int sizev, int sizee)
    {
        v = new arrayset(sizev);
        e = new arrayset(sizee);
        sizeofv = sizev;
        sizeofe = sizee;
        edgeset = new edge[sizeofv][sizeofv];
    }

    public int compareTo(Object that)
    {
        return 0;
    }

    public void clear(int sizev, int sizee)
    {
        v = new arrayset(sizev);
        e = new arrayset(sizee);
        sizeofv = sizev;
        sizeofe = sizee;
        edgeset = new edge[sizeofv][sizeofv];
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
        int m = 0;
        int n = 0;
        boolean flag = false;
        boolean flag1 = false;
        int row = 0;
        do
        {
            if(row >= v.size())
                break;
            if(((vertex)v.get_a_value(row)).d.compareTo(begin.d) == 0)
            {
                flag = true;
                m = row;
                break;
            }
            row++;
        } while(true);
        int col = 0;
        do
        {
            if(col >= v.size())
                break;
            if(((vertex)v.get_a_value(col)).d.compareTo(end.d) == 0)
            {
                flag1 = true;
                n = col;
                break;
            }
            col++;
        } while(true);
        if(flag && flag1 && edgeset[m][n] != null)
            return edgeset[m][n].w;
        else
            return 0x1869f;
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

    public arrayset getv()
    {
        return v;
    }

    public arrayset gete()
    {
        return e;
    }

    public edge getevalue(vertex v1, vertex v2)
    {
        int m = 0;
        int n = 0;
        boolean flag = false;
        boolean flag1 = false;
        int row = 0;
        do
        {
            if(row >= v.size())
                break;
            if(((vertex)v.get_a_value(row)).d.compareTo(v1.d) == 0)
            {
                flag = true;
                m = row;
                break;
            }
            row++;
        } while(true);
        int col = 0;
        do
        {
            if(col >= v.size())
                break;
            if(((vertex)v.get_a_value(col)).d.compareTo(v2.d) == 0)
            {
                flag1 = true;
                n = col;
                break;
            }
            col++;
        } while(true);
        if(flag && flag1)
            return edgeset[m][n];
        else
            return null;
    }

    public int sizeofv()
    {
        return v.size();
    }

    public int sizeofe()
    {
        return e.size();
    }

    public boolean is_equal(arraydigraph g1, arraydigraph g2)
    {
        return g1.v.is_equal(g1.v, g2.v) && g1.e.is_equal(g1.e, g2.e);
    }

    public arraydigraph copy()
    {
        arraydigraph g = new arraydigraph(v.capacity, e.capacity);
        g.v = v.copy();
        g.e = e.copy();
        return g;
    }

    public void addv(vertex u)
    {
        v = v.union(v, new arrayset(u));
    }

    public void adde(edge e1)
    {
        e = e.union(e, new arrayset(e1));
        boolean flag = false;
        boolean flag1 = false;
        int row;
        if(e1.h == null)
        {
            row = 0;
            do
            {
                if(row >= v.size())
                    break;
                if(v.get_a_value(row) == null)
                {
                    flag = true;
                    break;
                }
                row++;
            } while(true);
        } else
        {
            row = 0;
            do
            {
                if(row >= v.size())
                    break;
                if(((vertex)v.get_a_value(row)).d.compareTo(e1.h.d) == 0)
                {
                    flag = true;
                    break;
                }
                row++;
            } while(true);
        }
        int col;
        if(e1.t == null)
        {
            col = 0;
            do
            {
                if(col >= v.size())
                    break;
                if(v.get_a_value(col) == null)
                {
                    flag1 = true;
                    break;
                }
                col++;
            } while(true);
        } else
        {
            col = 0;
            do
            {
                if(col >= v.size())
                    break;
                if(((vertex)v.get_a_value(col)).d.compareTo(e1.t.d) == 0)
                {
                    flag1 = true;
                    break;
                }
                col++;
            } while(true);
        }
        if(flag && flag1)
            edgeset[row][col] = e1;
    }

    public void modifyin(arrayset a, arrayset b)
    {
        a = b;
    }

    public arrayset in(vertex u)
    {
        boolean flag = false;
        int col = 0;
        do
        {
            if(col >= v.size())
                break;
            if(((vertex)v.get_a_value(col)).d.compareTo(u.d) == 0)
            {
                flag = true;
                break;
            }
            col++;
        } while(true);
        arrayset outset = new arrayset(v.size());
        if(flag)
        {
            for(int j = 0; j < v.size(); j++)
                if(edgeset[j][col] != null)
                    outset = outset.union(outset, new arrayset(v.get_a_value(j)));

        }
        return outset;
    }

    public arrayset out(vertex u)
    {
        boolean flag = false;
        int row = 0;
        do
        {
            if(row >= v.size())
                break;
            if(((vertex)v.get_a_value(row)).d.compareTo(u.d) == 0)
            {
                flag = true;
                break;
            }
            row++;
        } while(true);
        arrayset outset = new arrayset(v.size());
        if(flag)
        {
            for(int j = 0; j < v.size(); j++)
                if(edgeset[row][j] != null)
                    outset = outset.union(outset, new arrayset(v.get_a_value(j)));

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

    arrayset v;
    arrayset e;
    edge edgeset[][];
    int sizeofv;
    int sizeofe;
}
