// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   input.java

package strulib;

import java.io.*;

// Referenced classes of package strulib:
//            Newinteger, Newreal, Newchar, Newboolean, 
//            NewString, vertex, MyObject

public final class input
{

    public input()
    {
    }

    /*修改时间：2014-03-03		修改人：吴莫海
     *备注：新添加read，统一输入
     * 
     * */
    public static MyObject read(MyObject b)
    {
        if(b instanceof Newinteger)
            b = new Newinteger(readint());
        else
        if(b instanceof Newreal)
            b = new Newreal(readfloat());
        else
        if(b instanceof Newchar)
            b = new Newchar(readstring());
        else
        if(b instanceof Newboolean)
            b = new Newboolean(readboolean());
        else
        if(b instanceof NewString)
            b = new NewString(readstring());
        else
        if(b instanceof vertex)
            if(((vertex)b).get_d() instanceof Newinteger)
                b = new Newinteger(readint());
            else
            if(((vertex)b).get_d() instanceof Newreal)
                b = new Newreal(readfloat());
            else
            if(((vertex)b).get_d() instanceof Newchar)
                b = new Newchar(readstring());
            else
            if(((vertex)b).get_d() instanceof Newboolean)
                b = new Newboolean(readboolean());
            else
            if(((vertex)b).get_d() instanceof NewString)
                b = new NewString(readstring());
        return b;
    }
    
    /*修改时间：2014-03-03		修改人：吴莫海
     *备注：保留以前，待删除，可用read统一输入
     * 
     * */
    public static MyObject readobject(MyObject b) 
    {
        if(b instanceof Newinteger)
            b = new Newinteger(readint());
        else
        if(b instanceof Newreal)
            b = new Newreal(readfloat());
        else
        if(b instanceof Newchar)
            b = new Newchar(readstring());
        else
        if(b instanceof Newboolean)
            b = new Newboolean(readboolean());
        else
        if(b instanceof NewString)
            b = new NewString(readstring());
        else
        if(b instanceof vertex)
            if(((vertex)b).get_d() instanceof Newinteger)
                b = new Newinteger(readint());
            else
            if(((vertex)b).get_d() instanceof Newreal)
                b = new Newreal(readfloat());
            else
            if(((vertex)b).get_d() instanceof Newchar)
                b = new Newchar(readstring());
            else
            if(((vertex)b).get_d() instanceof Newboolean)
                b = new Newboolean(readboolean());
            else
            if(((vertex)b).get_d() instanceof NewString)
                b = new NewString(readstring());
        return b;
    }

    public static void writeobject(Object b)
    {
        if(b instanceof Newinteger)
            System.out.print(((Newinteger)b).value);
        else
        if(b instanceof Newreal)
            System.out.print(((Newreal)b).value);
        else
        if(b instanceof Newchar)
            System.out.print(((Newchar)b).value);
        else
        if(b instanceof Newboolean)
            System.out.print(((Newboolean)b).value);
        else
        if(b instanceof NewString)
            System.out.print(((NewString)b).value);
    }
    /*修改时间：2014-03-03		修改人：吴莫海
     *备注：新加write，统一输出
     * 
     * */
    public static void write(Object b)
    {
        if(b instanceof Newinteger)
            System.out.print(((Newinteger)b).value);
        else
        if(b instanceof Newreal)
            System.out.print(((Newreal)b).value);
        else
        if(b instanceof Newchar)
            System.out.print(((Newchar)b).value);
        else
        if(b instanceof Newboolean)
            System.out.print(((Newboolean)b).value);
        else
        if(b instanceof NewString)
            System.out.print(((NewString)b).value);
    }
    public static void write(Integer out)
    {
    	System.out.println(out + "\n");
    }
    public static void write(Double out)
    {
    	System.out.println(out + "\n");
    }
    public static void write(String out)
    {
    	System.out.println(out + "\n");
    }
    public static void write(Boolean out)
    {
    	System.out.println(out + "\n");
    }
    public static void writelnobject(Object b)
    {
        if(b instanceof Newinteger)
            System.out.println(((Newinteger)b).value);
        else
        if(b instanceof Newreal)
            System.out.println(((Newreal)b).value);
        else
        if(b instanceof Newchar)
            System.out.println(((Newchar)b).value);
        else
        if(b instanceof Newboolean)
            System.out.println(((Newboolean)b).value);
        else
        if(b instanceof NewString)
            System.out.println(((NewString)b).value);
    }
    
    /*修改时间：2014-03-03		修改人：吴莫海
     *备注：新添加四个read，统一输入
     * 
     * */
    public static int read(Integer in)
    {
    	return readint();
    }
    public static float read(Double in)
    {
    	return readfloat();
    }
    public static String read(String in)
    {
    	return readstring();
    }
    public static Boolean read(Boolean in)
    {
    	return readboolean();
    }
    public static float readfloat()
    {
        float i = 0.0F;
        try
        {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("please input a double number. ");
            i = Float.valueOf(in.readLine().trim()).floatValue();
            System.out.println(i);
        }
        catch(IOException e)
        {
            System.out.println("io error");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Not a floating point number. Please try again!");
        }
        return i;
    }

    public static boolean readboolean()
    {
        boolean i = false;
        try
        {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("please input a boolean. ");
            i = Boolean.valueOf(in.readLine().trim()).booleanValue();
            System.out.println(i);
        }
        catch(IOException e)
        {
            System.out.println("io error");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Not a boolean. Please try again!");
        }
        return i;
    }

    public static String readstring()
    {
        String i = "";
        try
        {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("please input a string . ");
            i = in.readLine().trim();
            System.out.println(i);
        }
        catch(IOException e)
        {
            System.out.println("io error");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Not a string. Please try again!");
        }
        return i;
    }
    public static int readint()
    {
        int i = 0;
        try
        {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("please input a int number. ");
            i = Integer.valueOf(in.readLine().trim()).intValue();
            System.out.println(i);
        }
        catch(IOException e)
        {
            System.out.println("io error");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Not a int number. Please try again!");
        }
        return i;
    }

    public static void readentertoend()
    {
        try
        {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("press enter key  ");
            in.readLine();
        }
        catch(IOException e)
        {
            System.out.println("Please try again!");
        }
    }

    public static int readeweight()
    {
        int i = 0;
        try
        {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("\u8BF7\u8F93\u5165\u8FB9\u6743 ");
            i = Integer.valueOf(in.readLine().trim()).intValue();
            System.out.println(i);
        }
        catch(IOException e)
        {
            System.out.println("io error");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Not a int number. Please try again!");
        }
        return i;
    }

    public static int readebegin()
    {
        int i = 0;
        try
        {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("\u8BF7\u8F93\u5165\u8FB9\u7684\u8D77\u59CB\u7ED3\u70B9 ");
            i = Integer.valueOf(in.readLine().trim()).intValue();
            System.out.println(i);
        }
        catch(IOException e)
        {
            System.out.println("io error");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Not a int number. Please try again!");
        }
        return i;
    }

    public static int readeend()
    {
        int i = 0;
        try
        {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("\u8BF7\u8F93\u5165\u8FB9\u7684\u7EC8\u6B62\u7ED3\u70B9 ");
            i = Integer.valueOf(in.readLine().trim()).intValue();
            System.out.println(i);
        }
        catch(IOException e)
        {
            System.out.println("io error");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Not a int number. Please try again!");
        }
        return i;
    }

    public static void main(String arg[])
    {
		int a = 0;
		int b = -1;
		MyObject aa = new Newinteger(1000);
		b = read(a);
		write(a);
		write(b);
		write(aa);
          
    }
}
