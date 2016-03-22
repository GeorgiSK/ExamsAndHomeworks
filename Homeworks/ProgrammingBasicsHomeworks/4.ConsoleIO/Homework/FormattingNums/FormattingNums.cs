using System;

class FormattingNums
{
    static void Main(string[] args)
    {
        int a = int.Parse(Console.ReadLine());
        double b = double.Parse(Console.ReadLine());
        double c = double.Parse(Console.ReadLine());

        Console.WriteLine("|{0, -10:X}|{1}|{2, 10:0.00}|{3, -10:0.000}|", a, Convert.ToString(a, 2).PadLeft(10, '0'), b, c);
    }
}

