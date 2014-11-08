// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MathOp.java

package strulib;

import java.io.PrintStream;

public class MathOp
{

    public MathOp()
    {
    }

    public static int ord(String x)
    {
        char b = x.charAt(0);
        int c = b;
        return c;
    }

    public static int succ(int x)
    {
        return ++x;
    }

    public static String succ(String x)
    {
        char b = x.charAt(0);
        int c = b;
        if(b == 'z')
            b = 'a';
        else
            b = (char)(++c);
        char cc[] = new char[1];
        cc[0] = b;
        String str = new String(cc);
        return str;
    }

    public static int pred(int x)
    {
        return --x;
    }

    public static String pred(String x)
    {
        char b = x.charAt(0);
        int c = b;
        if(b == 'a')
            b = 'z';
        else
            b = (char)(--c);
        char cc[] = new char[1];
        cc[0] = b;
        String str = new String(cc);
        return str;
    }

    public static boolean odd(int x)
    {
        return x % 2 != 0;
    }

    public static boolean isint(int x)
    {
        return true;
    }

    public static boolean isint(float x)
    {
        return false;
    }

    public static boolean isint(String x)
    {
        return false;
    }

    public static int s_add(int a, int b)
    {
        return a + b;
    }

    public static float s_add(float a, float b)
    {
        return a + b;
    }

    public static double s_add(double a, double b)
    {
        return a + b;
    }

    public static String s_add(String a, String b)
    {
        return String.valueOf(a) + String.valueOf(b);
    }

    public static int s_sub(int a, int b)
    {
        return a - b;
    }

    public static float s_sub(float a, float b)
    {
        return a - b;
    }

    public static double s_sub(double a, double b)
    {
        return a - b;
    }

    public static int s_multi(int a, int b)
    {
        return a * b;
    }

    public static float s_multi(float a, float b)
    {
        return a * b;
    }

    public static double s_multi(double a, double b)
    {
        return a * b;
    }

    public static int s_div(int a, int b)
    {
        return a / b;
    }

    public static float s_div(float a, float b)
    {
        return a / b;
    }

    public static double s_div(double a, double b)
    {
        return a / b;
    }

    public static int s_mod(int a, int b)
    {
        return a % b;
    }

    public static float s_mod(float a, float b)
    {
        return a % b;
    }

    public static double s_mod(double a, double b)
    {
        return a % b;
    }

    public static double s_max(double a, double b)
    {
        return Math.max(a, b);
    }

    public static float s_max(float a, float b)
    {
        return Math.max(a, b);
    }

    public static int s_max(int a, int b)
    {
        return Math.max(a, b);
    }

    public static long s_max(long a, long b)
    {
        return Math.max(a, b);
    }

    public static char s_max(char a, char b)
    {
        if(a > b)
            return a;
        else
            return b;
    }

    public static String s_max(String a, String b)
    {
        if(a.compareTo(b) > 0)
            return a;
        else
            return b;
    }

    public static double s_min(double a, double b)
    {
        return Math.min(a, b);
    }

    public static float s_min(float a, float b)
    {
        return Math.min(a, b);
    }

    public static int s_min(int a, int b)
    {
        return Math.min(a, b);
    }

    public static long s_min(long a, long b)
    {
        return Math.min(a, b);
    }

    public static char s_min(char a, char b)
    {
        if(a > b)
            return b;
        else
            return a;
    }

    public static String s_min(String a, String b)
    {
        if(a.compareTo(b) > 0)
            return b;
        else
            return a;
    }

    public static boolean s_and(boolean a, boolean b)
    {
        return a && b;
    }

    public static boolean s_or(boolean a, boolean b)
    {
        return a || b;
    }

    public static void main(String arg[])
    {
        boolean a = true;
        boolean b = false;
        System.out.print(s_and(a, b));
    }
}
