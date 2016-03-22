using System;

class PointInACircle
{
    static void Main(string[] args)
    {
        double x = double.Parse(Console.ReadLine());
        double y = double.Parse(Console.ReadLine());

        bool isInside = (x * x) + (y * y) <= 4;

        Console.WriteLine(isInside);
    }
}

