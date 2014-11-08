// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Newchar.java

package strulib;


// Referenced classes of package strulib:
//            MyObject

public class Newchar extends MyObject
{

    public Newchar(String Str)
    {
        value = Str;
    }

    public Object Clone()
    {
        String Str = new String(value);
        return Str;
    }

    public int compareTo(Object that)
    {
        return value.compareTo(((Newchar)that).value);
    }

    public String toString()
    {
        return value;
    }

    public String value;
}
