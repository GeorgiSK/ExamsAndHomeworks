using System;

class FibonacciNumbers
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int x = 0;
        int xn = 1;
        int xs = 1;

        for (int i = 0; i < n; i++)
        {
            Console.Write(x + " ");
            xn = xn + xs;
            xs = xn - xs;
            xn = x;
            x = xn + xs;
        }
        Console.WriteLine();
    }
}

