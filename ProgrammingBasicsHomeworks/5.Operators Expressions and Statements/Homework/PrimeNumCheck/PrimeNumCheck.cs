using System;

class PrimeNumCheck
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        bool isPrime = n > 1;
        for (int i = 2; i <= Math.Sqrt(n); i++)
        {
            if (n <= 1)
            {
                isPrime = false;
                break;
            }

            if (n % i == 0)
            {
                isPrime = false;
                break;
            }
            else 
            {
                isPrime = true; 
            }
        }

        Console.WriteLine(isPrime);
    }
}

