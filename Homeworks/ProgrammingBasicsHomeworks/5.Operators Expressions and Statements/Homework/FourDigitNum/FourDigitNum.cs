using System;

class FourDigitNum
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        string x = Convert.ToString(n);
        char a = x[0];
        char b = x[1];
        char c = x[2];
        char d = x[3];
        int sum = Convert.ToInt32(Convert.ToString(a)) + Convert.ToInt32(Convert.ToString(b)) + Convert.ToInt32(Convert.ToString(c)) + Convert.ToInt32(Convert.ToString(d));
        Console.WriteLine(sum);
        Console.WriteLine("{0}{1}{2}{3}", d, c, b, a);
        Console.WriteLine("{0}{1}{2}{3}", d, a, b, c);
        Console.WriteLine("{0}{1}{2}{3}", a, c, b, d);
    }
}

