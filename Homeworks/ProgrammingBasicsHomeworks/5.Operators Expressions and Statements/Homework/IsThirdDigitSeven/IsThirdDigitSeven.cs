using System;

class IsThirdDigitSeven
{
    static void Main(string[] args)
    {
        string n = Console.ReadLine();
        int num = n[n.Length - 3];
        bool result = num == 55;

        Console.WriteLine(result);
    }
}

