using System;

class DevideBySevenAndFive
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        bool result = n % 5 == 0 && n % 7 == 0;

        Console.WriteLine(result);
    }
}

