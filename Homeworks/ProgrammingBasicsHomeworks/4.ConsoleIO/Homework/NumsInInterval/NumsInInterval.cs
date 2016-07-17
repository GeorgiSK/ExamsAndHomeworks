using System;

class NumsInInterval
{
    static void Main(string[] args)
    {
        int start = int.Parse(Console.ReadLine());
        int end = int.Parse(Console.ReadLine());
        int p = 0;

        for (int i = start; i <= end; i++)
        {
            if (i % 5 == 0)
            {
                p++;
            }
        }
        Console.WriteLine(p);

        for (int i = start; i <= end; i++)
        {
            if (i % 5 == 0)
            {
                Console.Write(i + " ");
            }
        }
    }
}

