// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Newboolean.java

package strulib;


// Referenced classes of package strulib:
//            MyObject

public class Newboolean extends MyObject
{

    public Newboolean(boolean Str)
    {
        value = Str;
    }

    public Object Clone()
    {
        Newboolean Str = new Newboolean(value);
        return Str;
    }

    public int compareTo(Object that)
    {
        return 0;
    }

    public String toString()
    {
        return (new Boolean(value)).toString();
    }

    public boolean value;
}
