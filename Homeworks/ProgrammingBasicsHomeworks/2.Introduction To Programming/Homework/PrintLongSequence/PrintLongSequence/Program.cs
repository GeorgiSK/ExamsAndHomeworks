using System;

namespace PrintLongSequence
{
    class Program
    {
        static void Main(string[] args)
        {
            //creating an array that will hold the numbers
            int[] array = new int[1000];
            int n = 2;

            //a loop with a condition that saves the numbers in the array
            for (int i = 0; i < 1000; i++)
            {
                if (n % 2 != 0)
                {
                    array[i] = -n;
                }
                else
                {
                    array[i] = n;
                }

                n++;
            }

            //a loot that prints out the numbers
            for (int i = 0; i < 1000; i++)
            {
                if (i == 999)
                {
                    Console.WriteLine(array[i]);
                }
                else
                {
                    System.Console.Write(array[i] + ",");
                }
            }

        }
    }
}