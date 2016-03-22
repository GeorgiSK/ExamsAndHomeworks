using System;

class GravitationOnTheMoon
{
    static void Main(string[] args)
    {
        double weigth = double.Parse(Console.ReadLine());

        double result = weigth * 0.17;
        Console.WriteLine("{0:0.000}",result);
    }
}

