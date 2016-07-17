using System;

namespace AgeAfterTenYears
{
    class Program
    {
        static void Main(string[] args)
        {
          
            Console.WriteLine("Please fill in your birth year: ");

            int birthYear = Convert.ToInt32(Console.ReadLine());
            int currentAge = 2015 - birthYear;
            int futureAge = currentAge + 10;

            Console.WriteLine("Now : " + currentAge);
            Console.WriteLine("After 10 years : " + futureAge);

        }
    }
}
