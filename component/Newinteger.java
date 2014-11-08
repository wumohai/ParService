// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Newinteger.java

package strulib;


// Referenced classes of package strulib:
//            MyObject

public class Newinteger extends MyObject
{

    public Newinteger(int Str)
    {
        value = Str;
    }

    public Object Clone()
    {
        Newinteger Str = new Newinteger(value);
        return Str;
    }

    public int compareTo(Object that)
    {
        if(value == ((Newinteger)that).value)
            return 0;
        return value <= ((Newinteger)that).value ? -1 : 1;
    }

    public String toString()
    {
        return (new Integer(value)).toString();
    }

    public int value;
    public static void main(String argv[])
    {
    	
    }
}
