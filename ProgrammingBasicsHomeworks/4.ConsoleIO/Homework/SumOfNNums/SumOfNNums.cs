using System;

class SumOfNNums
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        double sum = 0;

        for (int i = 0; i < n; i++)
        {
            double currentNum = double.Parse(Console.ReadLine());
            sum += currentNum;
        }

        Console.WriteLine(sum);
    }
}

