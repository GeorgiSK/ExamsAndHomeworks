using System;


class Rectangles
{
    static void Main(string[] args)
    {
        double width = double.Parse(Console.ReadLine());
        double heigth = double.Parse(Console.ReadLine());
        double perimeter = (2 * width) + (2 * heigth);
        double area = width * heigth;

        Console.WriteLine("Perimeter: {0}", perimeter);
        Console.WriteLine("Area: {0}", area);
    }
}

