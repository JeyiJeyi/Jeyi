package cn.hdu.acm;

import java.io.*;
import java.util.*;

public class Templete
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int a, b;

        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }
    }
}

