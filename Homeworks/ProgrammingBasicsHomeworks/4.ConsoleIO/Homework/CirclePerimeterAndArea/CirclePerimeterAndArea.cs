using System;

class CirclePerimeterAndArea
{
    static void Main(string[] args)
    {
        double radius = double.Parse(Console.ReadLine());
        double pi = Math.PI;
        double perimeter = pi * (radius * radius);
        double area = 2 * pi * radius;

        Console.WriteLine("{0:0.00}", perimeter);
        Console.WriteLine("{0:0.00}", area);
    }
}

