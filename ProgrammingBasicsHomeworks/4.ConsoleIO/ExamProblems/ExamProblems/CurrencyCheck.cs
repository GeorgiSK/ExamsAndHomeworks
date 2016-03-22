using System;

class CurrencyCheck
{
    static void Main(string[] args)
    {
        double r = (double.Parse(Console.ReadLine()) / 100) * 3.5;
        double d = (double.Parse(Console.ReadLine()) * 1.5);
        double e = (double.Parse(Console.ReadLine()) * 1.95);
        double b = (double.Parse(Console.ReadLine()) / 2);
        double m = double.Parse(Console.ReadLine());

        double result = r;

        if (d < result)
        {
            result = d;
        }

        if (e < result)
        {
            result = e;
        }

        if (b < result)
        {
            result = b;
        }

        if (m < result)
        {
            result = m;
        }

        Console.WriteLine("{0:0.00}", result);
    }
}

