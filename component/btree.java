// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   btree.java

package strulib;

import java.io.PrintStream;
import java.util.Vector;

// Referenced classes of package strulib:
//            MyObject, treenode

public class btree extends MyObject
    implements Cloneable
{

    public btree()
    {
    }

    public btree(int size)
    {
    }

    public boolean isempty()
    {
        if(this == null)
            return true;
        return root == null;
    }

    public int compareTo(Object that)
    {
        return 0;
    }

    public Vector seek(MyObject a)
    {
        boolean found = false;
        btree p = new btree();
        btree q = new btree();
        q = this;
        try
        {
            while(!q.isempty() && !found) 
                if(q.root.key.compareTo(a) == 0)
                {
                    found = true;
                } else
                {
                    p = q;
                    if(q.root.key.compareTo(a) > 0)
                        q = q.root.left;
                    else
                        q = q.root.right;
                }
        }
        catch(NullPointerException e)
        {
            System.out.println("\u51FA\u9519\uFF1A\u975E\u6CD5\u4F7F\u7528\u7A7A\u53E5\u67C4");
        }
        Vector v = new Vector();
        v.addElement(p);
        v.addElement(q);
        return v;
    }

    public void insert(MyObject a)
    {
        btree p = new btree();
        btree q = new btree();
        Vector v = new Vector();
        v = seek(a);
        try
        {
            if(((btree)v.elementAt(0)).isempty())
            {
                p = new btree();
            } else
            {
                p = new btree();
                p = (btree)v.elementAt(0);
            }
            if(((btree)v.elementAt(1)).isempty())
            {
                q = new btree();
            } else
            {
                q = new btree();
                q = (btree)v.elementAt(1);
            }
            if(q.isempty())
            {
                btree temp = new btree();
                temp.root = new treenode();
                temp.root.key = a;
                temp.root.left = new btree();
                temp.root.right = new btree();
                temp.root.parent = p;
                if(p.isempty())
                    root = temp.root;
                else
                if(p.root.key.compareTo(a) > 0)
                    p.root.left = temp;
                else
                    p.root.right = temp;
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("\u51FA\u9519\uFF1A\u975E\u6CD5\u4F7F\u7528\u7A7A\u53E5\u67C4");
        }
    }

    public void remove(MyObject a)
    {
        btree p = new btree();
        btree q = new btree();
        btree u = new btree();
        btree v = new btree();
        btree w = new btree();
        Vector va = seek(a);
        p = (btree)va.elementAt(0);
        try
        {
            if(!((btree)va.elementAt(1)).isempty())
            {
                q = (btree)va.elementAt(1);
                if(q.root.left.isempty())
                {
                    v = q.root.right;
                } else
                {
                    u = q;
                    v = q.root.right;
                    for(w = v.root.left; !w.isempty(); w = w.root.left)
                    {
                        u = v;
                        v = w;
                    }

                    if(!u.isequal(u, q))
                    {
                        u.root.left = v.root.right;
                        v.root.right = q.root.right;
                        if(v.root.right != null)
                            v.root.right.root.parent = u;
                    }
                    v.root.left = q.root.left;
                }
                if(p.isempty())
                {
                    root = v.root;
                    v.root.parent = null;
                } else
                {
                    if(!p.root.left.isempty())
                    {
                        if(q.root.key.compareTo(p.root.left.root.key) == 0)
                            p.root.left = v;
                        else
                            p.root.right = v;
                    } else
                    {
                        p.root.right = v;
                    }
                    v.root.parent = p;
                }
                q = null;
                System.gc();
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("\u51FA\u9519\uFF1A\u975E\u6CD5\u4F7F\u7528\u7A7A\u53E5\u67C4");
        }
    }

    public treenode getroot()
    {
        return root;
    }

    public MyObject getrootkey()
    {
        if(root != null)
            return root.key;
        else
            return (MyObject)null;
    }

    public int getsize()
    {
        Vector v = new Vector();
        v.addElement(root);
        int head = 0;
        int tail = 0;
        int i = 0;
        treenode p = null;
        do
        {
            if(head > tail)
                break;
            p = (treenode)v.elementAt(head);
            head++;
            i++;
            if(!p.left.isempty())
            {
                tail++;
                v.addElement(p.left.root);
            }
            if(!p.right.isempty())
            {
                tail++;
                v.addElement(p.right.root);
            }
        } while(true);
        return i;
    }

    public btree getltree()
    {
        if(root == null)
            return new btree();
        else
            return root.left;
    }

    public btree getparent()
    {
        if(root == null)
            return new btree();
        else
            return root.parent;
    }

    public btree getrtree()
    {
        if(root == null)
            return new btree();
        else
            return root.right;
    }

    public void swap(MyObject a, MyObject b)
    {
        Vector va = new Vector();
        Vector vb = new Vector();
        va = seek(a);
        vb = seek(b);
        try
        {
            if(((btree)va.elementAt(1)).isempty() || ((btree)vb.elementAt(1)).isempty())
            {
                System.out.println("not found the string");
            } else
            {
                treenode temp = new treenode();
                temp.key = ((btree)va.elementAt(1)).root.key;
                ((btree)va.elementAt(1)).root.key = ((btree)vb.elementAt(1)).root.key;
                ((btree)vb.elementAt(1)).root.key = temp.key;
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("\u51FA\u9519\uFF1A\u975E\u6CD5\u4F7F\u7528\u7A7A\u53E5\u67C4");
        }
    }

    public boolean isequal(btree p, btree q)
    {
        boolean flag = false;
        try
        {
            if(p.isempty() && q.isempty())
                flag = true;
            else
            if(!p.isempty() && !q.isempty() && p.root.key.compareTo(q.root.key) == 0 && isequal(p.root.left, q.root.left))
                flag = isequal(p.root.right, q.root.right);
        }
        catch(NullPointerException e)
        {
            System.out.println("\u51FA\u9519\uFF1A\u975E\u6CD5\u4F7F\u7528\u7A7A\u53E5\u67C4");
        }
        return flag;
    }

    public void clear()
    {
        root = null;
    }

    public btree replacewith(btree t2)
    {
        clear();
        return t2.copy();
    }

    public btree made(btree t1, treenode n, btree t2)
    {
        btree temptree = new btree();
        temptree.root = n;
        temptree.root.left = t1;
        temptree.root.right = t2;
        return temptree;
    }

    public Object clone()
    {
        btree t = null;
        try
        {
            t = (btree)super.clone();
        }
        catch(CloneNotSupportedException e) { }
        return t;
    }

    public btree copy()
    {
        Vector v = new Vector();
        btree temp = new btree();
        v.addElement(root);
        int head = 0;
        int tail = 0;
        treenode p = null;
        do
        {
            if(head > tail)
                break;
            p = (treenode)v.elementAt(head);
            head++;
            if(p != null && !p.left.isempty())
            {
                tail++;
                v.addElement(p.left.root);
            }
            if(p != null && !p.right.isempty())
            {
                tail++;
                v.addElement(p.right.root);
            }
        } while(true);
        Vector vcopy = (Vector)v.clone();
        for(int i = 0; i < v.size(); i++)
            vcopy.setElementAt((treenode)((treenode)vcopy.elementAt(i)).clone(), i);

        temp.root = (treenode)vcopy.elementAt(0);
        return temp;
    }

    public btree copy(btree t)
    {
        Vector v = new Vector();
        btree temp = new btree();
        if(t.root == null)
        {
            temp.root = null;
            return temp;
        }
        v.addElement(t.root);
        int head = 0;
        int tail = 0;
        treenode p = null;
        do
        {
            if(head > tail)
                break;
            p = (treenode)v.elementAt(head);
            head++;
            if(p != null && !p.left.isempty())
            {
                tail++;
                v.addElement(p.left.root);
            }
            if(p != null && !p.right.isempty())
            {
                tail++;
                v.addElement(p.right.root);
            }
        } while(true);
        Vector vcopy = (Vector)v.clone();
        for(int i = 0; i < v.size(); i++)
            vcopy.setElementAt((treenode)((treenode)vcopy.elementAt(i)).clone(), i);

        temp.root = (treenode)vcopy.elementAt(0);
        return temp;
    }

    protected treenode root;
}
