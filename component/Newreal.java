// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Newreal.java

package strulib;


// Referenced classes of package strulib:
//            MyObject

public class Newreal extends MyObject
{

    public Newreal(double Str)
    {
        value = Str;
    }

    public Object Clone()
    {
        Newreal Str = new Newreal(value);
        return Str;
    }

    public int compareTo(Object that)
    {
        if(value == ((Newreal)that).value)
            return 0;
        return value <= ((Newreal)that).value ? -1 : 1;
    }

    public String toString()
    {
        return (new Double(value)).toString();
    }

    public double value;
}
