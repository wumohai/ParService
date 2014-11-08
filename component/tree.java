// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   tree.java

package strulib;

import java.io.PrintStream;
import java.util.Vector;

// Referenced classes of package strulib:
//            MyObject, treenode

public class tree extends MyObject
    implements Cloneable
{

    public tree()
    {
    }

    public tree(int size)
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
        tree p = new tree();
        tree q = new tree();
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
        tree p = new tree();
        tree q = new tree();
        Vector v = new Vector();
        v = seek(a);
        try
        {
            if(((tree)v.elementAt(0)).isempty())
            {
                p = new tree();
            } else
            {
                p = new tree();
                p = (tree)v.elementAt(0);
            }
            if(((tree)v.elementAt(1)).isempty())
            {
                q = new tree();
            } else
            {
                q = new tree();
                q = (tree)v.elementAt(1);
            }
            if(q.isempty())
            {
                tree temp = new tree();
                temp.root = new treenode();
                temp.root.key = a;
                temp.root.left = new tree();
                temp.root.right = new tree();
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
        tree p = new tree();
        tree q = new tree();
        tree u = new tree();
        tree v = new tree();
        tree w = new tree();
        Vector va = seek(a);
        p = (tree)va.elementAt(0);
        try
        {
            if(!((tree)va.elementAt(1)).isempty())
            {
                q = (tree)va.elementAt(1);
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
            return null;
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

    public tree getltree()
    {
        if(root == null)
            return new tree();
        else
            return root.left;
    }

    public tree getparent()
    {
        if(root == null)
            return new tree();
        else
            return root.parent;
    }

    public tree getrtree()
    {
        if(root == null)
            return new tree();
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
            if(((tree)va.elementAt(1)).isempty() || ((tree)vb.elementAt(1)).isempty())
            {
                System.out.println("not found the string");
            } else
            {
                treenode temp = new treenode();
                temp.key = ((tree)va.elementAt(1)).root.key;
                ((tree)va.elementAt(1)).root.key = ((tree)vb.elementAt(1)).root.key;
                ((tree)vb.elementAt(1)).root.key = temp.key;
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("\u51FA\u9519\uFF1A\u975E\u6CD5\u4F7F\u7528\u7A7A\u53E5\u67C4");
        }
    }

    public boolean isequal(tree p, tree q)
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

    public tree replacewith(tree t2)
    {
        clear();
        return t2.copy();
    }

    public tree made(tree t1, treenode n, tree t2)
    {
        tree temptree = new tree();
        temptree.root = n;
        temptree.root.left = t1;
        temptree.root.right = t2;
        return temptree;
    }

    public Object clone()
    {
        tree t = null;
        try
        {
            t = (tree)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception) { }
        return t;
    }

    public tree copy()
    {
        Vector v = new Vector();
        tree temp = new tree();
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

    public tree copy(tree t)
    {
        Vector v = new Vector();
        tree temp = new tree();
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
